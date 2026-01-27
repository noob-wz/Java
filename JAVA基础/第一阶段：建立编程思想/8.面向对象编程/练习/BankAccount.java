/*功能：你正在开发一个"银行账户"类。
**要求**：
    1. 编写 `BankAccount` 类，包含 `accountNumber` (账号), `balance` (余额), `pinCode` (支付密码)。
    2. 重写 `toString`。
    3. **安全要求**：绝对不能打印密码。
    4. **隐私要求**：账号只显示最后 4 位（如 `******1234`）。
    5. **格式要求**：使用 `StringBuilder` 或 `String.format` 或 `+` 拼接均可，格式清晰。
 */

//2026-01-27 21:47:44

// 目的：熟悉 Object 的 toString 方法的重写，并了解字符串截取
public class BankAccount {
    private String accountNumber;
    private double balance;
    private String pinCode;

    public BankAccount(String accountNumber, double balance, String pinCode) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "BankAccount{账号：******" + setAccount() + ", 余额：" + balance + ", 密码：" + "*********";
    }

    // 获取账号的后四位
    private String setAccount() {
        if (accountNumber == null) return "null";
        int len = accountNumber.length();

        // 防御性编程：如果账号太短（比如只有3位），就直接显示，或者全部显示星号
        if (len <= 4) {
            return accountNumber;
        }

        // 使用 substring 截取最后4位
        // substring(开始索引) -> 从这个位置一直截取到末尾
        return accountNumber.substring(len - 4);

    }
}