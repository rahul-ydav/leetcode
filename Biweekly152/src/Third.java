import java.util.HashMap;
import java.util.Map;

public class Third {

    public int[] longestCommonPrefix(String[] words, int k) {
        Trie tree = new Trie('*');
        tree.limit = k;

        for (String curr : words) {
            tree.insert(curr);
        }

        int[] res = new int[words.length];
        int idx =0;
        for (int i=0; i<words.length; i++) {

            //remove current word from trie
            tree.remove(words[i]);

            for(Character ch : tree.hm.keySet()){
//                if((words[i].length()<=idx || ch==words[i].charAt(idx))
//                        && tree.hm.get(ch).count>= tree.limit+1){
//                    words[i]
//                }
                if(tree.hm.get(ch).count>= tree.limit){
                    res[i] = 0;
                    res[i] = Math.max(res[i], tree.maxLen(tree.hm.get(ch), res[i], 1)) ;
                }
            }

            // add current word in trie
            tree.insert(words[i]);
        }
        return res;
    }
    class Trie{
        public char val;
        public HashMap<Character, Trie> hm;
        public Boolean isEnd = false;
        public int count;
        public int limit = 0;
        Trie(char ch){
            this.val = ch;
            this.hm = new HashMap<Character, Trie>();
            this.count = 0;

        }

        public void printTree(Trie tree){
            if(tree==null)  return;
            System.out.println("currNode->val: "+ tree.val + ", count: " + tree.count);
            if(tree.isEnd)  System.out.println("Ending");

            System.out.print("Hm: ");
            for(Map.Entry<Character, Trie> entry: tree.hm.entrySet()){
                System.out.print(entry.getKey()+", ");
            }
            System.out.println();
            for(Map.Entry<Character, Trie> entry: tree.hm.entrySet()){
                printTree(entry.getValue());
            }
        }

        public void insert(String word){
            Trie node = this;
            for(int j=0; j<word.length(); j++){
                char ch = word.charAt(j);
                if(!node.hm.containsKey(ch)){
                    Trie newNode = new Trie(ch);
                    node.hm.put(ch, newNode);
                }
                node.count++;
                node = node.hm.get(ch);
            }

            node.isEnd = true;
        }

        public void remove(String word){
            Trie node  = this;

            for(int j=0; j<word.length(); j++){

                node.count--;

                char ch = word.charAt(j);

                if(node.hm.containsKey(ch) && node.hm.get(ch).count==1){
                    node.hm.remove(ch);
                    break;
                }

                if(node.hm.containsKey(ch)){
                    node = node.hm.get(ch);
                }
            }

            //Removing isEnd check if it is the only word;
            int nextCounts = 0;
            for(Character ch : node.hm.keySet()){
                nextCounts += node.hm.get(ch).count;
            }
            if(node.count == nextCounts){
                node.isEnd = false;
            }

        }

        public int check(String word){
            Trie node = this;

            for(int j=0; j<word.length(); j++){
                char ch = word.charAt(j);

                if(node.hm.containsKey(ch)){
                    node = node.hm.get(ch);
                }
                else    return 0;
            }

            if(node.isEnd) return 1;

            return 0;
        }

        public int maxLen(Trie node, int currMax, int currLen){
            int ans = currMax+1;
            for(Character ch : node.hm.keySet()){

                if(node.hm.get(ch).count>= node.limit){
                    ans = Math.max(ans, node.maxLen(node.hm.get(ch), currMax+1, currLen+1));
                }
            }
            return ans;
        }
    }
}
