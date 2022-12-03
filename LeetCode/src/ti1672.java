import java.util.Arrays;

public class ti1672 {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int[] max = new int[m];
        int moneymax = max[0];

        for (int i = 0; i < m; i++) {
            for (int j : accounts[i]){
                max[i] += j;
            }
        }

        for(int i : max){
            if(moneymax < i){
                moneymax = i;
            }
        }
        return moneymax;
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());
        }
        return maxWealth;
    }
}

