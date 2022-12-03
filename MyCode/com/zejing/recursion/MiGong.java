package com.zejing.recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[11][11];
        //先上下
        for (int i = 0;i < map[0].length;i++){
            map[0][i] = 1;
            map[10][i] = 1;
        }
        //后左右
        for (int i = 0;i < map.length;i++) {
            map[i][0] = 1;
            map[i][10] = 1;
        }
        //阻挡
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    /**
     *
     * @param map
     * @param i
     * @param j
     * @return true/false
     */
    private static boolean setWay(int[][] map, int i, int j) {
        if(map[9][9] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] =2;
                if(setWay(map,i +1,j)){
                    return true;
                }else if (setWay(map,i - 1,j)){
                    return true;
                }else if (setWay(map,i,j + 1)){
                    return true;
                }else if (setWay(map,i,j -1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
