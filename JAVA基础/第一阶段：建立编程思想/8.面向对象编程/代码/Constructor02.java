public class Constructor02 {
    public static void main(String[] args) {
        // ❌ 编译报错：构造器是私有的，不能直接 new
        // DatabaseConfig db = new DatabaseConfig();

        // ✅ 正确：通过静态工厂创建
        DatabaseConfig db = DatabaseConfig.create("127.0.0.1", 3306);
        System.out.println(db);
    }

}

public class DatabaseConfig {
    // 1. 加 final：一旦赋值，终身不改（真正不可变）
    // 如果仅仅是用private，还是可以通过 setter 方法来更改
    private final String host;
    private final int port;

    // 2. 私有构造器 (Private Constructor)
    // 关键点：外部无法直接 new，必须走 create 方法，确保校验逻辑不被绕过
    private DatabaseConfig(String host, int port) {
        // 校验逻辑
        // 如果逻辑异常，就会报错，不会走到赋值那一步
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("端口异常: " + port);
        }
        if (host == null || host.isBlank()) {
            throw new IllegalArgumentException("Host 不能为空");
        }

        // 赋值
        this.host = host;
        this.port = port;
    }

    // 3. 静态工厂方法 (Static Factory Method)
    // 关键点：返回值类型必须是类本身，记得 return
    public static DatabaseConfig create(String host, int port) {
        // 这里调用内部的私有构造器
        return new DatabaseConfig(host, port);
    }
}



