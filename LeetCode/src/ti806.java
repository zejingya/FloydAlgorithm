public class ti806 {
    public int[] numberOfLines(int[] widths, String s){
        int a = 0,b = 0;
        for(char c : s.toCharArray()){
            int w = widths[c - 'a'];
            if (b - w > 100 && ++a >= 0) b = w;
            else b += w;
        }
        if(b != 0)a++;
        return new int[]{a,b};
    }
}
