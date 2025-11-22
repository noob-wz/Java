// 功能：实现登陆验证，有3次机会，如果用户名为“丁真”，密码“666”提示登录成功，否则提示还有几次机会

import java.util.Scanner;

public class Break03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 1; i <= 3; i++){
            System.out.print("请输入用户名：");
            String username = sc.next();
            System.out.print("请输入密码：");
            String password = sc.next();

            if (username.equals("丁真") && password.equals("666") ) {
                System.out.println("登录成功！");
                break;
            } else {
                System.out.println("输出错误！还剩" + (3-i) + "次机会");
            }
        }
            


        sc.close();
    }
}
