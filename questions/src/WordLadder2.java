import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        for(String s : wordList)
            dict.add(s);
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        q.add(cur);
        List<String> usedOnCurrLevel = new ArrayList<>();
        usedOnCurrLevel.add(beginWord);
        List<List<String>> ans = new ArrayList<>();
        int level = 0;
        while(!q.isEmpty()){
            List<String> vec = q.peek();
            q.poll();
            if(vec.size() > level){
                level ++;
                for(String it : usedOnCurrLevel){
                    dict.remove(it);
                }
            }
            String word = vec.get(vec.size() - 1);
            if(word.equals(endWord))
            {
                if(ans.size() == 0)
                    ans.add(vec);
                else if(ans.get(0).size() == vec.size())
                    ans.add(vec);

            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch ++){
                    char[] replaced = word.toCharArray();
                    replaced[i] = ch;
                    String replacedWord = new String(replaced);
                    if(dict.contains(replacedWord) == true)
                    {
                        vec.add(replacedWord);
                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        vec.remove(vec.size() - 1);
                        usedOnCurrLevel.add(replacedWord);
                    }
                }
            }
        }
        return ans;

    }
}
