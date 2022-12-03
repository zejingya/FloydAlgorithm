package com.zejing.array;

import static java.lang.System.out;

public class Array {

    public static void main(String[] args) {

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        int sum = 0;
        int count = 0;


        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (0 != chessArr1[i][j]) sum++;
            }
        }

        int[][] superArr = new int[sum + 1][3];
        superArr[0][0] = chessArr1.length;
        superArr[0][1] = chessArr1[0].length;
        superArr[0][2] = sum;

        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (0 != chessArr1[i][j]) {
                    superArr[++count][0] = i;
                    superArr[count][1] = j;
                    superArr[count][2] = chessArr1[i][j];
                }
            }
        }

        out.println("得到的稀疏数组：");
        for (int[] ints : superArr) out.println(ints[0] + "\t" + ints[1] + "\t" + ints[2]);

        //还原
        int[][] chessArr2 = new int[superArr[0][0]][superArr[0][1]];
        for(int i = 1; i < superArr.length; ++i) {
            chessArr2[superArr[i][0]][superArr[i][1]] = superArr[i][2];//赋值
        }

        out.println("恢复后的二维数组");

        int[][] var18 = chessArr2;
        int var8 = chessArr2.length;

        for (int var7 = 0; var7 < var8; ++var7) {
            int[] row = var18[var7];
            int[] var13 = row;
            int var12 = row.length;

            for (int var11 = 0; var11 < var12; ++var11) {
                int data = var13[var11];
                out.printf("%d\t", data);
            }

            out.println();

        }
    }
}
