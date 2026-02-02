// 视图层：显示界面；接收用户输入并传给业务层
package com.houserent.view;

import com.houserent.model.House;
import com.houserent.service.HouseService;

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

    // 用户新建房屋信息，创建方法用于接收用户输入，并将
    public void addHouse() {

        if(houseService.getHouseNums() == houseService.getListHouses().length) {
            System.out.println("房屋列表已满，无法添加！");
            return;
        }

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
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                continue;
            }
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
            System.out.println("-------------------------- 没有该房屋 --------------------------");
        } else {
            System.out.println(house);
        }
    }

    // 删除房源
    public void deleteHouse() {

        System.out.print("请选择待删除的房屋编号（-1退出）：");
        int key = scanner.nextInt();

        if (key == -1) {
            System.out.println("放弃删除房屋信息！");

            // 这里的return没必要，因为是 'void' 方法的最后一条语句
            return;
        } else {
            // 1. 校验：判断房源中是否有要删除的房屋信息
            boolean isExist = false;
            for (House house : houseService.getListHouses()) {
                if (house != null && house.getId() == key) {
                    isExist = true;
                }
            }
            if (!isExist) {
                System.out.println("没有该条房源信息！");
                return;
            }

            // 2. 若存在该条房源信息，则正常删除
            System.out.print("确认是否删除（Y/N）：请小心选择！\n 请输入你的选择：");
            char deleteFlag = scanner.next().toUpperCase().charAt(0);
            if(deleteFlag == 'Y') {
                for (House house : houseService.getListHouses()) {
                    if (house != null && house.getId() == key) {
                        if (houseService.delete(key)) {
                            System.out.println("-------------------------- 删除完成 --------------------------");
                        }
                    }
                }
            } else if (deleteFlag == 'N') {
                return;
            }

        }
    }

    // 修改房屋信息
    public void changeHouse() {
        System.out.println("-------------------------- 修改客户 --------------------------");
        System.out.println("请选择待修改房屋编号（-1退出）：");

        int key = scanner.nextInt();
        scanner.nextLine();
        if (key == -1) {
            System.out.println("你已放弃修改！");
            return;
        } else {
            System.out.println("（如果不希望修改某个信息，则直接回车）");
            House house = houseService.find(key);

            System.out.print("姓名(" + house.getName() + "): ");
            String name = scanner.nextLine() ;
            if (!name.trim().isEmpty()) {
                house.setName(name);
            }
            System.out.print("电话(" + house.getTelephone() + "): ");
            String telephone = scanner.nextLine();
            if (!telephone.trim().isEmpty()) {
                house.setTelephone(telephone);
            }
            System.out.print("地址(" + house.getAddress() + "): ");
            String address = scanner.nextLine();
            if (!address.trim().isEmpty()) {
                house.setAddress(address);
            }
            System.out.print("租金(" + house.getRent() + "): ");
            String rent = scanner.nextLine();
            if (!rent.trim().isEmpty()) {
                house.setRent(Double.parseDouble(rent));
            }
            System.out.print("状态(" + house.getState() + "): ");
            String state = scanner.nextLine();
            if (!state.trim().isEmpty()) {
                house.setState(state);
            }
        }
    }

    // 退出界面
    public void exit() {
        loop = false;
    }
}
