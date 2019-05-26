/*
假设你有一个encoded string “abbaabab”，和一个decode dict 比如 a:dog, b:cat, ab:mouse, ba:bird, aba: bear，这样，要求返回所有的decode result
*/
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        Map<String, String> dict = new HashMap<>();
        dict.put("a", "dog");
        dict.put("b", "cat");
        dict.put("ab", "mouse");
        dict.put("ba", "bird");
        dict.put("aba", "bear");
        
        System.out.println(decode("aba", dict, new HashMap<>()));
    }
    
    List<String> decode(String s, Map<String, 
                        String> dict, Map<String, List<String>> cache) {
        // base case
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        
        List<String> ans = new ArrayList<>();
        // **不要漏掉, 如果當前s原來就在dict中, 例如abc如果就是對應一個, 加入, 並繼續切
        if (dict.containsKey(s)) {
            ans.add(dict.get(s));
            cache.put(s, ans);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (dict.containsKey(left)) {
                String right = s.substring(i, s.length());
                List<String> rightAns = decode(right, dict, cache);
                for (String rightString : rightAns) {
                    ans.add(dict.get(left) + rightString);
                }
            }
        }
        
        cache.put(s, ans);
        return cache.get(s);
    }
}