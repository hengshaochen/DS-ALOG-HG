// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        String s = "aaaa bbb cccc ddd ee ff ggggg";
        int k = 8;
        System.out.println(splitLine(s, k));
    }
    
    public List<String> splitLine(String s, int k) {
        int i = 0;
        StringBuilder curWord = new StringBuilder();
        int lineCount = 0;
        List<String> ans = new ArrayList<>();
        String lineWords = new String();
        while (i < s.length()) {
                while (i != s.length() && s.charAt(i) != ' ') {
                    curWord.append(s.charAt(i)); 
                    i++;
                }
                // 當前是空白, 如果加上現在這個字 + 1(空白) <= k 代表可以append
                if (lineCount + curWord.length() <= k) {
                    lineWords += lineWords.length() == 0 ? curWord : " " + curWord;
                    lineCount += curWord.length() + 1;
                    curWord.setLength(0);  // 清空sb
                    i++;
                } else {
                    System.out.println("curLine:" + lineWords);
                    ans.add(lineWords);
                    lineCount = curWord.length();
                    lineWords = curWord.toString();
                    curWord.setLength(0);
                    i++;
                }
        }
        // 加入最後一個
        ans.add(lineWords);
        return ans;
    }
}