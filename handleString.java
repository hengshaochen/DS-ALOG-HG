// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        List<String> lists = new ArrayList<>();
        lists.add("henrychen@google.com");
        lists.add("henry.chen@google.com");
        lists.add("heng.shao@google.com");
        lists.add("heng.shao@ansys.com");
        lists.add("heng.s.ha.o@ansys.com");
        lists.add("heng.s.ha.o+@ansys.com");
        lists.add("+@goo.com");
        lists.add("+@goo.com");
        lists.add("ab+c@goo.com");
        lists.add("a.b+c@goo.com");
        
        System.out.println(groupEmail(lists));
        System.out.println(filter(lists));
    }
    
    int groupEmail(List<String> emails) {
        if (emails == null) {
            return 0;
        }
        int ans = 0;
        Map<String, Integer> count = new HashMap<>();
        
        for (String email : emails) {
            String[] splitEmail = email.split("@");
            StringBuilder local = new StringBuilder();
            for (char c : splitEmail[0].toCharArray()) {
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    break;
                } else {
                    local.append(c);
                }
            }
            
            String finalEmail = local.toString() + "@" + splitEmail[1];
            if (!count.containsKey(finalEmail)) {
                count.put(finalEmail, 1);
            } else {
                count.put(finalEmail, count.get(finalEmail) + 1);
            }
            if (count.get(finalEmail) == 2) {
                ans++;
            }
        }
        return ans;
    }
    
    int filter(List<String> emails){
        Map<String, Integer> map= new HashMap<>();
        int res=0;
        for (String s: emails){
            String[] strArr= s.split("@");
            String name= strArr[0].replaceAll("\\.", ""), domain=strArr[1];
            int plusIdx= name.indexOf("+");
            if (plusIdx!=-1) name=name.substring(0, plusIdx);
            String email=name+"@"+domain;
            int cnt=map.getOrDefault(email, 0)+1;
            if (cnt==2) res++;
            map.put(email, cnt);
        }
        return res;
    }
}