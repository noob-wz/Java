// 目的：快速入门switch的用法，熟悉Scanner的使用

/* TODO(2025-11-19 16:06:08) 
 * 
 * 总结————本程序需要注意的地方
 * （1）switch的控制表达式返回值 和 case值 都不支持浮点型数据
 * （2）针对基本数据类型或者说整型时：switch的分支本质就是 “控制表达式 == case值”，如果数据类型统一，不会发生类型转换。但是如果数据
 *      类型不一致，会进行数据类型提升再比较
 */

public class Switch01 {
    public static void main(String[] args) {
        int i = 65;
        
        switch(i) {
            case 'A':
                System.out.println("ok1");
                break;

            // case 65: //报错，case标签重复
            //     System.out.println("ok2");
            //     break;
            case 78:
                System.out.println("ok3");
                break;
            case 'E':   // char本质也是整型，进行比较前会进行隐式类型转换（ i=='E')，即先统一为int再比较
                System.out.println("ok4");
                break;

            
            // case 65.2: 
            //     System.out.println("ok5");
            //     break;
            // 报错。switch的控制表达式返回值和case值不支持浮点型数据
            default:
                System.out.println("不ok");
        }
        
    }
}
