class Solution {
    public String reverseOnlyLetters(String S) {
        String s = new String(S);
        Set<Integer> set = new HashSet<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(S.charAt(i)) == false) {
                set.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = len - 1;
        for (int i = 0; i < len; i++) {
            if (set.contains(i)) {
                sb.append(s.charAt(i));
            } else {
                while (Character.isLetter(S.charAt(idx)) == false) {
                    idx--;
                }
                sb.append(S.charAt(idx));
                idx--;
            }
        }
        return sb.toString();
    }
}