// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    class Pair {
        String name;
        int parent;
        public Pair(String name, int parent) {
            this.name = name;
            this.parent = parent;
        }
    }
    
    public Main() {
        List<Pair> tree = new ArrayList<>();
        tree.add(new Pair("A", -1));
        tree.add(new Pair("B", 0));
        tree.add(new Pair("C", 0));
        tree.add(new Pair("D", 1));
        tree.add(new Pair("F", 3));
        tree.add(new Pair("G", 1));
        
        Map<String, Integer> name2Index = new HashMap<>();
        Set<String> deleteSet = new HashSet<>();
        for (int i = 0; i < tree.size(); i++) {
            name2Index.put(tree.get(i).name, i);
        }
        deleteNode(tree, "B", name2Index, deleteSet);
        
        for (int i = 0; i < tree.size(); i++) {
            if (deleteSet.contains(tree.get(i).name)) {
                tree.remove(i);
                i--;  // 刪除當前, 後一個會移到當前index,此時idx不能動
            }
        }
        
        // print ans
        for (int i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i).name + " " + tree.get(i).parent);
        }
    }
    
    void deleteNode(List<Pair> tree, String del, Map<String, Integer> name2Index, Set<String> deleteSet) 
    {
        int curDeleteIndex = name2Index.get(del);
        deleteSet.add(del);
        
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).parent == curDeleteIndex) {
                deleteNode(tree, tree.get(i).name, name2Index, deleteSet);;
            }
        }
    }
}