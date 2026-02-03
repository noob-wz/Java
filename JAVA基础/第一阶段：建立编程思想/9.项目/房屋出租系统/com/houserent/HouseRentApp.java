package com.houserent;

import com.houserent.service.HouseService;
import com.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        HouseService hs = new HouseService(10);

        // 创建HouseView对象，显示主菜单
        // 视图层和业务层的交互，一般要在视图层把用户的输入传给业务层。一般有两种方式：（1）持有引用；（2）通过方法参数传递
        new HouseView(hs).mainMenu();
        System.out.println("你已退出房屋系统！");
    }
}
