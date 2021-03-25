package com.linmu.q1603;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/19 10:25 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1603 {
    public static void main(String[] args) {

    }
}

class ParkingSystem {
    private int[] packingSize;

    public ParkingSystem(int big, int medium, int small) {
        packingSize = new int[3];
        packingSize[0] = big;
        packingSize[1] = medium;
        packingSize[2] = small;
    }

    public boolean addCar(int carType) {
        if(packingSize[carType-1] == 0){
            return false;
        }
        packingSize[carType-1]--;
        return true;
    }
}
