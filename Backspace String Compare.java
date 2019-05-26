class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (char c : T.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

// 最優解法，不用空間
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        
        int counterS = 0, counterT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || counterS > 0)) {
                if (S.charAt(i) == '#') {
                    counterS++;
                } else {
                    counterS--;
                }
                i--;
            }
            
            while (j >= 0 && (T.charAt(j) == '#' || counterT > 0)) {
                if (T.charAt(j) == '#') {
                    counterT++;
                } else {
                    counterT--;
                }
                j--;
            }
            
            char curS = i < 0 ? '*' : S.charAt(i);
            char curT = j < 0 ? '*' : T.charAt(j);
            
            if (curS != curT) {
                System.out.println(curS + " " + curT);
                return false;
            }
            i--;
            j--;
        }
        
        return true;
    }
}