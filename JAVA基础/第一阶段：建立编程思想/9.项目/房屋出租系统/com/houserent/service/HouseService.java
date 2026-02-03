package com.houserent.service;

import com.houserent.model.House;

/**
 * Service层：业务逻辑
 * 1. 响应 View 的请求
 * 2. 维护 House[] 数组（增删改查）
 */
public class HouseService {
    private House[] houses;
    // 记录当前已有房屋个数
    private int houseNums = 0;
    // ID 自增长计数器
    private int idCounter = 1;

    public HouseService(int size) {
        this.houses = new House[size];
    }

    // 业务层校验   判断系统是否满了
    public boolean isFull() {
        return getHouseNums() == houses.length;
    }

    public void add(House house) {
        /* 方案一：搭配删除采用置空

        for(int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                houses[i] = house;
                houseNums++;
                houses[i].setId(idCounter++);
                return true;
            }
        }

         */

        // 方案二：
        houses[getHouseNums()] = house;
        houseNums++;
        houses[getHouseNums()].setId(idCounter++);
    }

    public House find(int id) {
        /* 方案一：搭配 删除采用置空导致数组不连续 ，需要遍历数组中的所有元素

        for (House house : houses) {
            // 如果对象数组直接采用 置空 的方式，那么使用的时候必须进行 判空。否则报错空指针异常
            if (house != null && house.getId() == id) {
                return house;
            }
        }
        return null;*/

        // 方案二：遍历当前存在元素数量
        for (int i = 0; i < getHouseNums(); i++) {
            if (id == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    public boolean delete(int id) {
        /* 方案一：懒人法（置空 + 判空）

        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == id) {
                houses[i] = null;
                houseNums--;
                return true;
            }
        }
        return false;

        */

        // 方案二：勤快方案（移位覆盖）
        for (int i = 0; i < getHouseNums(); i++) {
            if (houses[i].getId() == id) {
                houses[i] = null;
                // 最后一个数不需要遍历到
                for (int j = i; j < getHouseNums() - 1; j++) {
                    houses[j] = houses[j + 1];
                }
                houses[getHouseNums() - 1] = null;
                setHouseNums(getHouseNums() - 1);
                return true;
            }
        }
        return false;
    }

    // 修改信息：接收 View 传来的新数据对象，负责把旧数据覆盖掉
    public void update(int id, House newInfo) {
        House targetHouse = find(id);

        targetHouse.setName(newInfo.getName());
        targetHouse.setTelephone(newInfo.getTelephone());
        targetHouse.setAddress(newInfo.getAddress());
        targetHouse.setRent(newInfo.getRent());
        targetHouse.setState(newInfo.getState());
    }

    // Getter & Setter
    public House[] getListHouses() {
        return houses;
    }
    public int getHouseNums() {
        return houseNums;
    }
    public void setHouseNums(int houseNums) {
        this.houseNums = houseNums;
    }
}
