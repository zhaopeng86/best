package com.example.myapplication.test;

public class PowerAdapter3 extends PowerPort3 implements Target{
    @Override
    public void Convert_3TO2() {
        this.Output_3();
        System.out.println("将三个转换成两个插孔");
    }
}
