Java 提供了三种类型的注释，每种都有其特定的用途。其中，**文档注释（Javadoc）** 是最强大的，用于生成专业的 API 文档。

---

## 📝 Java 注释的使用

### 1\. 单行注释 (Single-line Comment)

- **格式：** `// 注释内容`
- **用途：** 用于对单行代码进行快速解释，或对代码片段的意图进行简短说明。
- **特点：** 只能注释从 `//` 符号开始到行尾的内容。

<!-- end list -->

```java
int score = 100; // 定义玩家的得分
// 这是一个快速说明
```

### 2\. 多行注释 (Multi-line Comment / Block Comment)

- **格式：** `/* 注释内容 */`
- **用途：**
  - 用于对代码进行较长的、多行的解释说明。
  - 最常用的是**临时禁用（注释掉）一大块代码**，以便进行调试。
- **特点：** 注释内容从 `/*` 开始，到第一个 `*/` 结束。所以，_多行注释里面不能嵌套多行注释_

<!-- end list -->

```java
/*
这是一个多行注释的例子。
它通常用于解释一段复杂的逻辑，
或者像这样，注释掉一段不需要执行的代码块。
int x = 10 / 0; // 这行代码不会被编译和执行
*/
```

---

## 📘 重点：文档注释 (Documentation Comment / Javadoc)

文档注释用于在 Java 源代码中嵌入**文档信息**。通过 Java 自带的 `javadoc` 工具处理后，这些注释可以直接生成结构化的 **HTML 格式的 API 文档**，就像您在 Oracle 官方网站上看到的 Java API 文档一样。

### 格式与位置

- **格式：** `/** 文档内容 */`
- **位置：** 必须放在**类、接口、方法、构造函数或字段（变量）** 的定义之前。

### 核心组成：描述与 Javadoc 标签

文档注释主要包含两部分：

#### 1\. 主描述（Main Description）

放在注释的开头，提供对该元素（类、方法等）的简要描述。通常第一句话被用作摘要。

#### 2\. Javadoc 标签（Tags）

以 `@` 符号开头，提供结构化的信息，例如参数、返回值、作者等。

### 📌 常用 Javadoc 标签

| 标签       | 作用域         | 目的                                        | 示例                                   |
| :--------- | :------------- | :------------------------------------------ | :------------------------------------- |
| `@param`   | 方法、构造函数 | 描述方法的**参数**名称和作用。              | `@param username 用户的登录名。`       |
| `@return`  | 方法           | 描述方法的**返回值**的含义。                | `@return 计算得到的年龄值。`           |
| `@throws`  | 方法、构造函数 | 描述方法可能抛出的**异常**类型和条件。      | `@throws IOException 如果文件不存在。` |
| `@author`  | 类、接口       | 描述代码的**作者**。                        | `@author Alice`                        |
| `@since`   | 类、方法       | 描述引入该元素或其修改的**版本**。          | `@since 1.2`                           |
| `@version` | 类、接口       | 描述当前元素的**版本**。                    | `@version 1.0`                         |
| `@see`     | 所有           | 创建一个指向其他类、方法或 URL 的**链接**。 | `@see com.example.MyClass`             |

### 完整示例

```java
package com.example.utility;

/**
 * 这是一个关于用户信息的工具类。
 * 用于演示 Javadoc 文档注释的使用和生成。
 * * @author Gemini
 * @version 1.0
 * @since 2023-11-14
 */
public class UserUtil {

    /**
     * 用户年龄的默认值。
     */
    public static final int DEFAULT_AGE = 18;

    /**
     * 根据出生年份计算用户的当前年龄。
     * 如果年份无效，将抛出异常。
     *
     * @param birthYear 用户的出生年份（例如：1990）。
     * @return 用户的精确年龄（整数）。
     * @throws IllegalArgumentException 如果出生年份小于1900年。
     * @see java.util.Calendar
     */
    public static int calculateAge(int birthYear) throws IllegalArgumentException {
        if (birthYear < 1900) {
            throw new IllegalArgumentException("出生年份不能早于1900年。");
        }
        // 假设当前年份是 2025 年
        return 2025 - birthYear;
    }
}
```

### 💡 如何生成文档？

在命令行中，切换到包含源代码的目录，然后运行：

```bash
javadoc -d doc_output_dir UserUtil.java
```

`javadoc` 工具就会读取 `/** ... */` 注释中的内容，并在 `doc_output_dir` 文件夹中生成一整套包含 HTML 文件、索引和导航的专业 API 文档。
