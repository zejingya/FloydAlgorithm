import java.util.HashSet;
import java.util.Set;

public class ti804 {
    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> m = new HashSet<String>();
        for (String word : words){
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                code.append(MORSE[ch - 'a']);
            }
            m.add(code.toString());
        }
        return m.size();
    }
}
