// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    int idx = 0;
    public Main() {
        //System.out.println(dfs("a{b,c}"));
        System.out.println(dfs("a{c,{a,b}}"));
    }
    
    String dfs(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder buf = new StringBuilder();
        
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == '{') {
                String subS = dfs(s);
                if (buf.length() == 0) {
                    buf = new StringBuilder(subS);
                } else {
                    buf = combine(buf.toString(), subS);
                }
            } else if (c == ',') {
                buf.append(',');
                sb.append(buf);
                buf.setLength(0);
            } else if (c == '}') {
                sb.append(buf);
                return sb.toString();
            } else {
                buf.append(c);
            }
        }
        sb.append(buf);
        return sb.toString();
    }
    
    StringBuilder combine(String A, String B) {
        StringBuilder sb = new StringBuilder();
        String[] As = A.split(",");
        String[] Bs = B.split(",");
        
        for (int i = 0; i < As.length; i++) {
            for (int j = 0; j < Bs.length; j++) {
                sb.append(As[i] + Bs[j] + ",");
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }
}