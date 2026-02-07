// 目的：演示接口的多态传递

package com.wz.interface_;

public class Interface03 {
    public static void main(String[] args) {
        IG ig = new Test();

        // 多态传递，IG继承IH，Test实现IG，也就实现了IH
        IH ih = new Test();

    }
}

interface IH {}
interface IG extends IH{}

class Test implements IG {

}
