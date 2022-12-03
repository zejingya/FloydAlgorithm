public class ti821 {
    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] answer = new int[n];

        for (int i = 0,ci = - n; i < n; i++) {
            if (c == s.charAt(i)){
                ci = i;
            }
            answer[i] = i - ci;
        }

        for (int i = n - 1,ci = 2 * n; i >= 0; i--) {
            if (c == s.charAt(i)){
                ci = i;
            }
            answer[i] = Math.min(answer[i],ci - i);
        }

        return answer;
    }
}
