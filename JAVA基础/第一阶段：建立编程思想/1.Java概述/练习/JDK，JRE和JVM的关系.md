> **答：三个的关系简单说就是：**
>
> 1\. **JDK = JRE + 开发工具**
> 2\. **JRE = JVM + 核心类库**

---

下面可以具体了解三者的关系和功能：

### 1. JVM (Java Virtual Machine) - 纯粹的执行者

它的**唯一职责**是：**加载** `.class` **字节码文件**，并**按照其中的指令集执行**。

**它的联系与依赖：**

- **JVM 无法独立工作**。它依赖 JRE：即使是执行最简单的 `System.out.println()`，JVM 也需要 JRE 提供 `System` 这个类。JVM 只知道“执行”，但执行所需的“材料”（如 `ArrayList`、`String`、`System` 等核心类）必须由 JRE 提供，它是 JRE 的核心。
- 换句话说，**JVM 执行的是一个混合体：它既执行您自己编写的类，也执行系统提供的核心类。**

### 2. JRE (Java Runtime Environment) - 完整的运行平台

它的职责是：为 Java 程序提供**完整的、可运行的环境**。

**它的联系与依赖：**

- **JRE 包含 JVM**，以及 JVM 运行所需的所有**核心 Java 库（API：所有预先编写好的结构化的“类、接口和方法集合”）**，即：`JRE = JVM + Java核心类库`
  - 当 JVM 执行到 `new String("...")` 时，它会向 JRE 索要 `String` 类的定义。
  - 当 JVM 执行到 `System.out.println()` 时，它会向 JRE 索要 `System` 类的定义。
- **JRE 是“运行”的最小单元：** 如果你只是一个普通用户，想运行一个 Java 软件（比如《我的世界》Minecraft），你只需要安装 JRE 就足够了。

### 3. JDK (Java Development Kit) - 完整的开发工具包

它的职责是：为开发者提供**从“编写”到“运行”所需的一切工具**。

**它的联系与依赖：**

- **JDK 包含 JRE：** 除了完整的运行环境 JRE 以外 ，JDK 提供了 JRE 缺少的这些**创建、测试和调试** `.class` 文件的开发工具。即：`JDK = JRE + 各类开发工具`
  - `javac.exe`：**编译器**。将 `Hello.java`（源代码）制造成 `Hello.class`（字节码）。
  - `javadoc.exe`：**文档生成器**。
  - `jdb.exe`：**调试器**。
- **JDK 是“开发”的最小单元：** 如果你想成为一名 Java 程序员，你必须安装 JDK。

---

### 🚀 动态流程：完整的开发流程中它们如何协同工作？

让我们通过一个完整的开发流程，把三者的**联系**串联起来：

**情景：当编写并运行一个 `Hello.java` 程序。**

1.  **编写 (使用 JDK)：**
    您在电脑上安装了 JDK。您使用 JDK 提供的开发工具（比如 `javac` 编译器）来编译您的 `Hello.java` 文件。

    - `javac Hello.java`
    - 结果： `javac`**（来自 JDK）** 将您的源代码制造成了 `Hello.class` 字节码文件。

2.  **运行 (使用 JRE)：**
    您在命令行输入 `java Hello` 来准备运行程序。

    - 这个 `java.exe` 命令就是 **JRE 的启动器**，它 **包含在 JDK** 中。

3.  **启动 (JRE 启动 JVM)：**
    JRE 被激活后，它做的第一件核心的事，就是在操作系统中**启动一个 JVM 进程**

4.  **执行 (JVM + JRE 协同)：**
    - **JVM** 开始加载 `Hello.class` 字节码。
    - JVM 读到一条指令 `System.out.println("...")`。
    - **JVM** 会向 **JRE** 提问：“`System` 是什么？`println` 在哪里？”
    - **JRE** 回答：“`System` 在我的核心库（`rt.jar` 或 `java.base` 模块）里，这是它的定义。”
    - **JVM** 获取到 JRE 提供的类库后，**继续执行**这些库里的字节码，最终完成在屏幕上的打印。

---

因此，它们的联系是：**JDK 使用开发工具制造出 JVM 执行 的字节码，然后 JDK 里的 JRE 启动 JVM，JVM 在运行过程中不断地切换自己代码的字节码和系统核心类库字节码的执行权，最终完成代码的执行**
