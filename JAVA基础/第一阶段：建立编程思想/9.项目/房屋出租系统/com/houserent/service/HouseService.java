// 业务层和数据层二合一。并响应 视图层 进行各种操作，并明确返回值。视图层 根据拿到的返回值进行显示操作
package com.houserent.service;

import com.houserent.model.House;

public class HouseService {
    private House[] houses;
    // 记录当前已有房屋个数
    private int houseNums = 0;

    private int idCounter = 1;

    public HouseService(int size) {
        this.houses = new House[size];
    }

    public House[] getListHouses() {
        return houses;
    }

    public int getHouseNums() {
        return houseNums;
    }

    public void add(House house) {
        for(int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                houses[i] = house;
                houseNums++;
                houses[i].setId(idCounter++);
                return;
            }
        }
    }

    public House find(int id) {
        for (House house : houses) {
            if (house != null && house.getId() == id) {
                return house;
            }
        }
         return null;
    }

    public boolean delete(int id) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == id) {
                houses[i] = null;
                houseNums--;
                return true;
            }
        }
        return false;
    }






}
