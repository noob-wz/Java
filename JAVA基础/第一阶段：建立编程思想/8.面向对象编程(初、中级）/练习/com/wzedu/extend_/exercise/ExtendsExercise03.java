/* 功能：
编写Computer类，包含CPU，内存，硬盘等属性，getDetails方法用于返回Computer的详细信息
编写PC子类，继承Computer，添加特有属性【品牌brand】
编写NotePad类，继承Computer，添加特有属性【color】
编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值
以及从Computer类继承的属性赋值，并使用方法并打印输出信息
 */

// 目的：
// （1）熟悉如何给子类和父类的属性进行赋值 或者说 初始化
// （2）关键字机制方向：`this` vs `super` 的本质区别：
//      问题：`this.xxx` 和 `super.xxx` 在查找属性和方法时有什么不同？
//      答：查找起点不同：
//          `this.`：先查自己（子类）。如果自己没有，再往上查父类。
//          `super.`：跳过自己，直接查父类，然后父类再按照继承的逻辑从下往上寻找。
//
//      特殊场景：
//          无重名/无重写时：无论是通过`this` 还是 `super` 访问父类属性都可以，殊途同归，都是访问同一个属性/方法。
//          有重名（属性遮蔽）或重写（方法覆盖）时：`this` 访问子类的版本，`super` 强制访问父类的老版本。



package com.wzedu.extend_.exercise;

/**
 * @author dchuan
 */
public class ExtendsExercise03 {
    public static void main(String[] args) {
        PC pc = new PC();

        // ---------------------------------------------------------
        // 场景 1：使用无参构造器 + Setter (对应你问的方式)
        // ---------------------------------------------------------
        System.out.println("=== 场景1：通过 Setter 赋值 ===");
        // 1. 调用父类继承来的 public 方法
        pc.setCpu("Intel i7");
        pc.setMemory(16);
        pc.setDisk(512);
        // 2. 调用自己特有的方法
        pc.setBrand("IBM");
        System.out.println("PC的品牌为：" + pc.getBrand() + " " + pc.getDetails());

        System.out.println("--------------------------");


        // ---------------------------------------------------------
        // 目前的 PC 构造器只接收 brand，导致父类的 CPU、内存等数据必须在创建对象后，再一行行去 set，很繁琐且不安全（可能忘了 set）。
        // 最佳实践：子类构造器接收所有参数，通过 super(...) 一口气把父类数据初始化好。

        // 场景 2：使用全参构造器 (大厂推荐 🔥)
        // ---------------------------------------------------------
        System.out.println("=== 场景2：通过 构造器 一步到位 ===");
        // 一行代码，完成父类和子类所有属性的初始化
        NotePad np = new NotePad("AMD R9", 32, 1024, "深空灰");
    }

}

class Computer {
    private String cpu;
    private int memory;
    private int disk;

    // 返回类型设置为 String 方便和子类字符串拼接
    public String getDetails() {
        return "Computer的CPU型号为：" + cpu + ", 内存大小为：" + memory + "G, 硬盘大小为：" + disk + "G";
    }

    // 无参构造器
    public Computer() {

    }

    public Computer(String cpu, int memory, int disk) {
        // 构造器调用方法的目的是统一安检逻辑，保证封装后进入任何时间、任何入口进入对象的数据都要是安全的
        setCpu(cpu);
        setDisk(disk);
        setMemory(memory);
    }

    public void setCpu(String cpu) {
        // 如果存在安全检查，则加入安检逻辑

        this.cpu = cpu;
    }

    public void setMemory(int memory) {
        // 如果存在安全检查，则加入安检逻辑

        this.memory = memory;
    }

    public void setDisk(int disk) {
        // 如果存在安全检查，则加入安检逻辑

        this.disk = disk;
    }
}

class PC extends Computer{
    private String brand;

    public PC() {}

    public PC(String brand) {
        // 这里默认执行的是super()，没有直接给父类初始化，所以后面还要一个一个的给父类赋值
        setBrand(brand);
    }

    public void setBrand(String brand){
        // 如果存在安全检查，则加入安检逻辑

        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

}

class NotePad extends Computer{
    private String color;

    public NotePad() {}

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        setColor(color);
    }

    public void setColor(String color){
        // 如果存在安全检查，则加入安检逻辑

        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


