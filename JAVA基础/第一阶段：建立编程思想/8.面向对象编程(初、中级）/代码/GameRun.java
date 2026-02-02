// 功能：你正在开发一个 RPG 游戏。英雄（Hero）可以攻击怪物，但不同的武器造成的伤害计算方式不同。
// 要求：解决属性访问字段遮蔽的问题
// 总结：
// （1）单一数据源：只用父类的属性，子类无法直接定义，利用构造器传值。收益：无论你在代码的任何角落（父类方法里、子类方法里、外部类里）访问 getDamage()，拿到的永远是同一个值。
// （2）私有数据，公开方法。封装的低耦合，让不同的类之间彼此独立（避免一个类中数据修改，另一个类也要修改），保护了调用者（Hero）免受被调用者（Weapon）变化的影响
// （3）继承解决重复（通用逻辑）以及类型抽象（多态发生的前提，子类对象可以赋给父类的引用），多态解决多样化（特殊逻辑）

public class GameRun {
    public static void main(String[] args) {
        Weapon w1 = new Sword();
        Weapon w2 = new MagicWand();
        Hero hero = new Hero();
        hero.useWeapon(w1);
        hero.useWeapon(w2);
    }
}

// 基础武器类
// 1: 父类没有明确实际意义，且防止子类没有重写。常规父类 改成 抽象父类，修改后无法创建实例，且子类必须重写
abstract class Weapon {

    // 2. 改为 private：除了我自己，谁都别想碰这个变量
    // 这迫使子类必须通过构造器或者方法来和我交互
    private int damage;

    // 3. 提供构造器：子类出生时，必须告诉我它的伤害是多少
    public Weapon(int damage) {
        this.damage = damage;
    }

    // 4. 提供 Getter 方法：这就是那个"多态的窗口"
    // 因为它是方法，所以我们可以放心地调用它，不用担心字段遮蔽
    public int getDamage() {
        return damage;
    }

    public void attack() {
        // 4. 内部也不要直接用 damage，养成习惯调用 getDamage()
        System.out.println("普通攻击，造成 " + getDamage() + " 点伤害");
    }
}

// 魔法杖
class MagicWand extends Weapon {

    public MagicWand() {
        super(10); // 基础面板可能是 10
    }

    // 核心思想：我不仅仅是存一个值，我有自己的计算逻辑
    // 覆盖（重写）父类的"窗口"，任何人通过这个窗口看进来，看到的都是翻倍的值
    @Override
    public int getDamage() {
        // 调用父类的基础值 * 2
        return super.getDamage() * 2;
    }
}

// 宝剑
class Sword extends Weapon {
//    public int damage = 50; // ⚠️ 子类和父类都有该属性，子类试图覆盖父类字段 ，外部访问时发生属性遮蔽

    public Sword() {
        // 核心思想：复用父类的存储空间
        // 翻译："爸爸(super)，我是宝剑，请把你的那个 damage 变量设为 50"
        super(50);
    }

    // 注意：这里不需要再定义 int damage 了！
    // 也不需要重写 getDamage()，因为直接用父类的就能取到 50。因为继承本身就会使用父类的方法。多态是为了处理同一方法不同的逻辑
}

// 英雄
class Hero {
    public void useWeapon(Weapon w) {
        // 这里的业务逻辑需要打印具体的伤害数值
        System.out.println("英雄发起攻击...");
        w.attack();

        // 如果你要计算吸血：
        // 关键点：w.getDamage() 是方法调用。
        // 如果 w 是 Sword，JVM 会去执行 Sword 的逻辑（取回50）
        // 如果 w 是 MagicWand，JVM 会去执行 MagicWand 的逻辑（算出来20）
        int lifeSteal = w.getDamage() / 10;
        System.out.println("吸血回复: " + lifeSteal);
    }
}