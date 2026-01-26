太棒了！我们已经学会了如何把代码装进安全的"胶囊"（封装）。



我们分 3 个阶段来掌握它。

──────────────────────────────────

## 第1部分：建立认知（What & Why）

### 🧬 1.1 什么是继承？

**定义**：继承允许我们基于一个已存在的类（**父类/超类**），构建一个新的类（**子类/派生类**）。

**核心关系**：**IS-A (是一个)**。

* 信用卡 (CreditWallet) **是一个** 钱包 (Wallet)。
* 狗 (Dog) **是一个** 动物 (Animal)。

**语法**：使用 **`extends`** 关键字。

```java
// 父类 (Father)
public class Wallet {
    // ... 代码 ...
}

// 子类 (Son)
// 翻译：CreditWallet 继承了 Wallet 的所有能力
public class CreditWallet extends Wallet {
    // 这里哪怕一行代码都不写，它也拥有了 Wallet 的所有 public/protected 成员
}

```

### 🧠 1.2 内存模型：子类里藏着父类

这是理解继承最关键的一点：**当你 `new` 一个子类对象时，内存里发生了什么？**

JVM 会创建一个大的对象，**在这个子类对象的内部，完整地保留了一份父类的实例数据**。

```
Heap Memory (堆内存)
+-------------------------------------+
| New CreditWallet 对象                |
|                                     |
|   +-----------------------------+   |
|   | super (父类 Wallet 部分)     |   |
|   |-----------------------------|   |
|   | balance: 100.0              |   |
|   | history: [...]              |   |
|   +-----------------------------+   |
|                                     |
|   +-----------------------------+   |
|   | this (子类特有部分)          |   |
|   |-----------------------------|   |
|   | creditLimit: 5000.0         |   |
|   +-----------------------------+   |
|                                     |
+-------------------------------------+

```

**关键结论**：

1. **单继承**：Java 中一个儿子只能有一个亲生父亲（`extends` 后面只能跟一个类）。这是为了防止"多爹"带来的逻辑混乱（钻石问题）。
2. **构造顺序**：先造父，后造子。（还记得我们在"初始化顺序"那一节讲的吗？`super()` 永远在第一行）。

---

## 第2部分：工程实践（How to Do Right）

### 🌍 2.1 真实场景：信用卡钱包

我们需要实现 `CreditWallet`，它有两点不同：

1. 多了一个属性：`creditLimit` (信用额度)。
2. 修改了一个行为：`withdraw` (取钱) 允许透支，只要不超过额度。

**关键词**：

* **`super`**：指代父类引用。
* **`@Override`**：重写（覆盖）父类的方法。

```java
// 父类：普通钱包
public class Wallet {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() { return balance; }

    // 普通取钱：没钱就报错
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("余额不足");
        }
        balance -= amount;
    }
}

// 子类：信用卡钱包
public class CreditWallet extends Wallet {
    private double creditLimit;

    public CreditWallet(double balance, double creditLimit) {
        // 1. 必须先呼叫父类构造器 (必须在第一行)
        super(balance); 
        this.creditLimit = creditLimit;
    }

    // 2. 重写 (Override)：修改父类的行为
    @Override
    public void withdraw(double amount) {
        // 计算可用总额 = 余额 + 信用额度
        double totalAvailable = getBalance() + creditLimit;

        if (amount > totalAvailable) {
            throw new IllegalArgumentException("超过信用额度");
        }

        // 3. 复用父类的扣款逻辑？
        // 哎呀！父类的 withdraw 会检查 balance < amount 就报错，
        // 而我们需要透支。所以这里不能简单调用 super.withdraw(amount)。
        // 这种情况下，我们需要自己写扣款逻辑。
        
        // ⚠️ 注意：如果 balance 是 private 的，子类也访问不到！
        // 这就是为什么有时候要把父类变量设为 protected，或者提供 protected setBalance()
        
        // 假设父类提供了 protected setBalance
        super.setBalance(super.getBalance() - amount);
    }
}

```

### ✅ 2.2 方法重写 (Overriding) 的铁律

当你想要改变父类的某个行为时，这就是 **重写**。

**红绿灯规范**：

* **🟢 必须加 `@Override**`：
* 虽然不加也能跑，但加了之后编译器会帮你检查。如果你拼错了方法名（比如写成 `withDraw`），编译器会立即报错。


* **🔴 权限不能缩小**：
* 父类是 `public`，子类不能改成 `protected` 或 `private`。（你可以更开放，不能更自闭）。


* **🔴 返回值必须兼容**：
* 父类返回 `Number`，子类可以返回 `Integer`（子类型），但不能返回 `Object`（父类型）。



---

## 第3部分：避坑进阶（What to Avoid）

### ☠️ 3.1 滥用继承 (The Inheritance Hell)

这是新手最容易犯的错误：**为了复用代码而继承**。

**错误示范**：
你想写一个 `Person` 类，你需要存一堆名字。你发现 `ArrayList` 刚好能存一堆东西。
于是你写：`public class Person extends ArrayList<String>`。

**后果**：

* `Person` 忽然有了 `clear()`、`remove(0)` 方法。
* 别人可以调用 `person.clear()` 把这个人给"清空"了！这是完全不符合逻辑的。

**判断标准：IS-A 测试**

* 问自己：Person **是一个** ArrayList 吗？ -> **NO**。
* Person **有一个** 名字列表吗？ -> **YES**。

**✅ 正确做法：组合 (Composition)**

> **组合优于继承 (Favor Composition over Inheritance)**

```java
public class Person {
    // 把 ArrayList 作为一个成员变量 (HAS-A)
    private List<String> names = new ArrayList<>();
}

```

### ⚠️ 3.2 脆弱的基类 (Fragile Base Class)

继承不仅是"父传子"，也是"父控子"。
如果父类改了一个 `protected` 方法的内部逻辑，可能会导致所有子类莫名其妙地崩掉。

**工程建议**：

* 如果一个类不是专门为继承设计的（没有详细的文档说明 `protected` 方法的行为），最好把它设为 **`final`** 类（禁止继承）。
* Java 17 引入了 **`sealed class` (密封类)**，允许你指定只有哪些类能继承你，防止继承泛滥。

---

### 🎓 实战挑战

我们现在有 `Animal`（动物）和 `Dog`（狗）。

```java
class Animal {
    public void eat() {
        System.out.println("动物进食");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    
    public void bark() {
        System.out.println("汪汪叫");
    }
}

```

**请看下面的代码，判断哪一行会报错，或者输出什么？**

```java
public static void main(String[] args) {
    // 1. 向上转型 (Upcasting)
    Animal a = new Dog(); 
    
    // 2. 调用重写的方法
    a.eat(); 
    
    // 3. 调用子类特有的方法
    a.bark(); 
}

```

📝 **提示**：

* `a` 的**引用类型**是 `Animal`（这是编译器看到的）。
* `a` 的**实际对象**是 `Dog`（这是运行时内存里的）。
* 编译器只看引用类型，运行时才看实际对象。

👉 **回复你的判断**，这将引出面向对象最最最核心的概念——**多态**。