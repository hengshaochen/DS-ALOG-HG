class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        long[] prefix = new long[S.length()];
        
        int sum = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            sum += shifts[i];
            sum = sum % 26; // 每次都要先mod, 不然會overflow, 先mod不影響結果
            shifts[i] = sum;
        }
        
        for (int i = 0; i < S.length(); i++) {
            shifts[i] %= 26;
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int curASCII = S.charAt(i) + shifts[i];
            if (S.charAt(i) + shifts[i] > 122) {
                curASCII = curASCII - 123 + 97;
            }
            ans.append((char)(curASCII));
        }
        
        return ans.toString();
    }
}