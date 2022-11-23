package com.itheima.test;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        int[] tempArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 打乱数组
        Random r = new Random();
        int temp;
        for (int i = 0; i < tempArr.length; i++) {
            int a = r.nextInt(16);
            temp = tempArr[a];
            tempArr[a] = tempArr[i];
            tempArr[i] = temp;
        }
        // 输出数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
        // 把打乱的一维数组放到二维数组中
        int[][] data = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
        // 输出二维数组
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }


        // 获取索引0的位置
        int x;
        int y;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
    }
}
