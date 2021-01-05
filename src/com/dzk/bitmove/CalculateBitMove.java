package com.dzk.bitmove;

public class CalculateBitMove {
    public static void main(String[] args) {
        int count = getCountOfOne(-1);
        System.out.println("1的数量: " +count);
    }

    private static int getCountOfOne(int value) {
        int flag = 1;
        int count = 0;
        while (flag > 0){
            int result = value & flag;
            if (result != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
