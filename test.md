这是整个面向对象编程（OOP）中最迷人、也是最“魔法”的时刻。

如果说 **继承** 是让子类拥有了父类的身体（复用代码），那么 **多态 (Polymorphism)** 就是让子类拥有了独立的灵魂（改变行为）。

没有多态，Java 就是一门死板的语言；有了多态，代码才真正活了起来。

---

### 1. 🎭 场景：同一个指令，不同的动作

回到我们的游戏。

- **父类 Hero：** 定义了一个 `move()` 方法，默认是“步行”。
- **子类 Warrior：** 觉得步行太慢，想改成“奔跑”。
- **子类 Bird：** 根本不想走，想改成“飞行”。

**所谓的“重写 (Override)”，就是子类撕掉了父类给的那张旧说明书，贴上了自己的一张新说明书。**

#### 💻 代码实战

```java
// 1. 父类
class Hero {
    public void move() {
        System.out.println("Hero: 慢慢走...");
    }
}

// 2. 子类 Warrior (重写)
class Warrior extends Hero {
    // @Override 是给编译器看的：帮我检查一下，我是不是真的在覆盖父类方法？
    // 万一我手抖把 move 写成了 movee，编译器会报错提醒我。
    @Override
    public void move() {
        System.out.println("Warrior: 全力冲刺！");
    }
}

// 3. 子类 Bird (重写)
class Bird extends Hero {
    @Override
    public void move() {
        System.out.println("Bird: 扇动翅膀飞翔！");
    }
}

```

---

### 2. 🤯 核心魔法：向上转型 (Upcasting)

多态的精髓，发生在我们**声明变量**的那一刻。

请看这行极其反直觉的代码：

```java
// 👈 左边是父类引用   =   👉 右边是子类对象
Hero h = new Warrior();

```

**这是合法的！**
因为“战士”**是**“英雄”（Is-A 关系）。就像你说“我买了一只**动物**（引用类型），它是一只**猫**（实际对象）”，逻辑上完全通顺。

**关键问题来了：**
当你执行 `h.move()` 时，控制台打印的是父类的“慢慢走”，还是子类的“全力冲刺”？

```java
h.move(); // ??? 猜猜是谁？
```

**答案是：**
`Warrior: 全力冲刺！`

这就是 **多态**。
**尽管**你手里的遥控器（引用 `h`）标签上写着是用来控制 `Hero` 的，**但是**，因为连接的实际机器（堆内存里的对象）是 `Warrior`，所以机器做出的动作是 `Warrior` 的动作。

---

### 3. ⚙️ 底层原理：动态绑定 (Dynamic Binding)

为什么会这样？这和我们在“字段（变量）”那一章讲的完全不同啊！
（回忆一下：`h.name` 如果重名了，看的是引用类型 `Hero`，而不是对象类型 `Warrior`）。

**架构师揭秘：**
Java 对 **“变量”** 和 **“方法”** 的处理机制是截然不同的。

1. **变量 (Fields)：静态绑定 (Static Binding)**

- 看**编译时**的类型（左边的 `Hero`）。编译器看到 `h` 是 Hero，就直接去 Hero 的偏移量里找数据。这也是为什么之前说变量遮蔽看父类。

2. **方法 (Methods)：动态绑定 (Dynamic Binding)**

- 看**运行时**的类型（右边的 `new Warrior()`）。
- **执行过程：**

1. JVM 拿到 `h` 指针，顺藤摸瓜找到堆内存里的对象。
2. JVM 检查对象的**真实身份**（对象头里的 Klass Pointer）。发现：“哦，这货原来是个 `Warrior`！”
3. JVM 查找 `Warrior` 的**方法表 (Virtual Method Table)**。
4. 发现 `move()` 被重写了，于是执行 `Warrior` 的代码。

**一句话总结：**
**“变量看左边（引用类型），方法看右边（实际对象）。”**

---

### 5. 🛡️ 避坑指南：重写的铁律

要想成功实现“偷梁换柱”（重写），必须遵守 **“两同两小一大”** 规则（这里只讲最核心的）：

1. **方法名、参数列表必须完全一样：** 哪怕参数类型变了一点点，那就不是重写（Override），而是重载（Overload，那是另一个故事了）。
2. **访问权限只能更大，不能更小：**

- 父类是 `public`，子类不能改成 `private`。
- _道理：_ 既然我也能当父类用（多态），那父类对外承诺能做的事（public），我也必须能做，不能偷偷藏私。

---

### 💬 灵魂拷问

为了验证你是否真的懂了 **“变量看左边，方法看右边”** 这个多态的核心规则，请看这道经典的 **大厂笔试题**：

```java
class A {
    int i = 10;       // 变量
    void run() {      // 方法
        System.out.println("A run");
    }
}

class B extends A {
    int i = 20;       // 变量重名
    void run() {      // 方法重写
        System.out.println("B run");
    }
}

public class Main {
    public static void main(String[] args) {
        A x = new B(); // 👈 向上转型！重点！

        System.out.println(x.i);  // 问题 1：打印 10 还是 20？
        x.run();                  // 问题 2：打印 A run 还是 B run？
    }
}

```

**请给出你的答案和理由。**（如果你能答对，多态这一关你就满分通过了。）
