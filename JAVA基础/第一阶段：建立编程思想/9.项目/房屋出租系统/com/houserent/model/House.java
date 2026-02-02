// 数据层
package com.houserent.model;


// House 模型 ，有这样一些成员变量：编号   房主  电话  地址  月租  状态（已出租/未出租）
public class House {
    private int id;
    private String name;
    private String telephone;
    private String address;
    private double rent;
    private String state;

    public House(String name, String telephone, String address, double rent, String state) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

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

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
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

    // 重写 toString 方法，输出房屋信息
    @Override
    public String toString() {
        return id + "\t" + name +  "\t" +
                telephone + "\t" + address + "\t" +
                rent + "\t" + state;
    }
}

// 问题1: 业务层和视图层什么情况下需要交互，或者说，这份代码里的退出为什么写在HouseView中，添加房屋既在HouseView中有，又在HouseServie中写了
// 问题2: 关于用户输入内容需要校验，校验是放在视图层还是业务层。如果是业务层，那么在用户开始输入之前就要判断是否能够输入怎么做呢？
// 问题3: delete中，如果if(key==-1）中的循环体写成mainMenu()是否会构成嵌套栈。
// 问题4: 数组中删除某个元素，地址置空可以吗，会不会有空指针异常
// 问题5: nextInt()不能读空格，nextLine()能读空格，那么next()能不能读空格？
// 问题6: next()如果不输入内容，只换行，是不是跳不出去
