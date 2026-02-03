
package com.houserent.model;


/**
 * Model层：House 对象
 * 纯粹的数据载体，不含业务逻辑
 */
public class House {
    private int id;
    private String name;
    private String telephone;
    private String address;
    private int rent;
    private String state;

    // 构造器：用于 View 层创建对象（ID由Service分配，所以这里没ID）
    public House(String name, String telephone, String address, int rent, String state) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    // 重写 toString，方便打印列表
    @Override
    public String toString() {
        return id + "\t" + name +  "\t" +
                telephone + "\t" + address + "\t" +
                rent + "\t" + state;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRent() {
        return rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setId(int id) {
        this.id = id;
    }
}


