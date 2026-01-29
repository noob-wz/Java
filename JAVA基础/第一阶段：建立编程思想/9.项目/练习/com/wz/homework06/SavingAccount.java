package com.wz.homework06;

public class SavingAccount extends BankAccount{
    // 存取款次数
    private int count = 3;
    // 利率
    private double rate = 0.001;

    public int getCount() {
        return count;
    }

    // 仅提供给内部逻辑使用
    private void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (count >= 1) {
            setCount(--count);
            super.deposit(amount);
            return;
        }
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        if (count >= 1) {
            setCount(--count);
            super.withdraw(amount);
            return;
        }
        super.withdraw(amount + 1);
    }

    // 每个月月初，计算利息和手续费
    public void earnMonthlyInterest() {
        setCount(3);
        super.deposit(getBalance() * getRate());
    }
}
