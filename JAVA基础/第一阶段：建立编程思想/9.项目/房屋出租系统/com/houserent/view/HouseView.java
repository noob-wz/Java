// 视图层：显示界面；接收用户输入并传给业务层
package com.houserent.view;

import com.houserent.model.House;
import com.houserent.service.HouseService;
import com.houserent.utils.Utility;

import java.util.Scanner;

/*
* 1. 显示主菜单
* 2. 接手用户输入
* 3. 调用 HouseService 完成对房屋信息的各种操作
* */
public class HouseView {
    private char key = ' ';
    private boolean loop = true;
    // 2、持有引用。方便 视图层 和 业务层 交互
    private HouseService houseService;
    private Scanner scanner = new Scanner(System.in);

    public HouseView(HouseService houseService) {
        this.houseService = houseService;
    }

    // 1、显示主菜单
    public void mainMenu() {
        do {
            System.out.println("-------------------------- 房屋出租系统 --------------------------");
            System.out.println("1. 新增房源" + "\n2. 查找房屋" +
                    "\n3. 删除房屋" + "\n4. 修改房屋信息" +
                    "\n5. 房屋列表" + "\n6. 退出");
            System.out.println("请选择（1-6）：");

            key = scanner.next().charAt(0);

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    changeHouse();
                    break;
                case '5':
                    list();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入有误！");
            }
        } while (loop);
    }

    // 分支1 ：用户新建房屋信息，创建方法用于接收用户输入，并将
    public void addHouse() {

        // 【第一道校验：业务校验】
        // 在用户动手输入之前，先问 Service
        if(houseService.isFull()) {
            System.out.println("房屋列表已满，无法添加！");
            return;
        }

        // 【第二道关：格式校验】
        // 这里调用 Utility 工具类，如果用户输错了，工具类会让他重输
        // 这就是 View 层的校验

        System.out.println("-------------------------- 添加房屋 --------------------------");
        System.out.print("姓名：");
        String name = scanner.next();
        System.out.print("\n电话：");
        String telephone = scanner.next();
        System.out.print("\n地址：");
        String address = scanner.next();
        System.out.print("\n月租：");
        int rent = scanner.nextInt();
        System.out.print("\n状态(已出租/未出租)：");
        String isRent = scanner.next();


        House h = new House(name, telephone, address, rent, isRent);
        houseService.add(h);
        System.out.println("-------------------------- 添加完成 --------------------------");
    }

    // 显示房屋列表
    public void list() {
        House[] houses = houseService.getListHouses();

        System.out.println("-------------------------- 房屋列表 --------------------------");
        for (int i = 0; i < houseService.getHouseNums(); i++) {
            /* 如果采用的 删除是 置空，就要加判空逻辑

            if (houses[i] == null) {
                continue;
            }
            */

            // 打印对象houses[i] ，会自动执行toString()方法
            System.out.println(houses[i]);
        }
    }

    // 查找房源
    public void findHouse() {
        System.out.println("-------------------------- 查找房屋 --------------------------");
        System.out.print("请输入你要查找的id: ");
        House house = houseService.find(scanner.nextInt());
        if (house == null) {
            System.out.println("-------------------------- 没有该房屋信息 --------------------------");
        } else {
            System.out.println(house);
        }
    }

    // 删除房源
    public void deleteHouse() {

        System.out.print("请选择待删除的房屋编号（-1退出）：");
        int delId = scanner.nextInt();

        if (delId == -1) {
            System.out.println("放弃删除房屋信息！");

            // 如果这里没有 return，那么下面的所有语句就要写到 else 里
            return;
        }

        // 1. 校验：判断房源中是否有要删除的房屋信息

            /* 原错误方案：
            原因 1：越权。View 层不应该知道底层是数组还是链表，也不应该去遍历它。View 只需要负责“下命令”，只负责收集和打包信息
            原因 2: 逻辑冗余。先遍历一遍看存不存在，确认删除后，Service 里又要遍历一遍去删除

            boolean isExist = false;
            for (House house : houseService.getListHouses()) {
                if (house != null && house.getId() == key) {
                    isExist = true;
                }
            }
            if (!isExist) {
                System.out.println("没有该条房源信息！");
                return;
            }*/

        // 新优化方案：复用 find 方法，这样就不需要自己遍历数组了
        House house = houseService.find(delId);

        // 2. 确认删除
        System.out.print("确认是否删除（Y/N）：请小心选择！\n 请输入你的选择：");

        // 这里处理一下输入信息：统一大小写；只取第一个字符
        char choice = scanner.next().toUpperCase().charAt(0);

        if(choice == 'Y') {
            // 3. 直接调用 delete，根据返回值判断
            if (houseService.delete(delId)) {
                System.out.println("-------------------------- 删除完成 --------------------------");
            } else {
                System.out.println("删除失败（可能刚刚被别人删了）");
            }
        } else{
            System.out.println("放弃删除");
        }
    }

    // 修改房屋信息
    public void changeHouse() {
        System.out.println("-------------------------- 修改客户 --------------------------");
        System.out.println("请选择待修改房屋编号（-1退出）：");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == -1) {
            System.out.println("你已放弃修改！");
            return;
        }

        System.out.println("（如果不希望修改某个信息，则直接回车）");
        House house = houseService.find(choice);

        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, house.getName()); // 如果回车，readString会自动返回原值

        System.out.print("电话(" + house.getTelephone() + "): ");
        String phone = Utility.readString(12, house.getTelephone());

        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, house.getAddress());

        System.out.print("租金(" + house.getRent() + "): ");
        int rent = Utility.readInt(house.getRent());

        System.out.print("状态(" + house.getState() + "): ");
        String state = Utility.readString(3, house.getState());

        House newInfo = new House(name, phone, address, rent, state);
        houseService.update(choice, newInfo);

    }

    // 退出界面
    public void exit() {
        loop = false;
    }
}
