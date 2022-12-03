import java.util.HashMap;
import java.util.Map;

class Solution2351 {
    public char repeatedCharacter(String s) {
        Map<Character,Integer> ans = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            ans.put(c,ans.getOrDefault(c,0) + 1);
            if(ans.get(c) == 2){
                return c;
            }
        }
        return ' ';
    }
}