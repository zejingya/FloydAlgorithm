public class ti2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //主要是简单的数学，用平均数称总数，减去m的数，剩下n的数，之后去除数，和余数，知道给小于余数位置的数加上一，凑出来
        int m = rolls.length;
        int sum = mean * (m + n);
        int nsum = sum;

        for(int s : rolls){
            nsum -= s;
        }

        if(nsum < n || nsum > 6 * n){
            return new int[0];
        }

        int a = nsum / n;
        int b = nsum % n;
        int[] miss = new int[n];

        for(int i = 0;i < n;i++){
            miss[i] = a + (i < b ? 1 : 0);
        }

        return miss;

    }
}
