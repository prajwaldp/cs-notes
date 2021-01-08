public class UniqueMorseCodeWords {
    final String[] CODES = {
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set < String > s = new HashSet < > ();
        for (String word: words) {
            s.add(encode(word));
        }
        return s.size();
    }

    private String encode(String ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            sb.append(CODES[ch - 'a']);
        }
        return sb.toString();
    }
}
