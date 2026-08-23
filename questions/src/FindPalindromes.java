import java.util.*;
class FindPlaindromes{
    private Set<String> solve(String s, int start, int end) {
        if(start > end)
            return new HashSet<>();
        Set<String> ans = new HashSet<>();
        if(start == end){
            ans.add(s.substring(start, end + 1));
            return ans;
        }
        if(s.charAt(start) == s.charAt(end)){
            ans.add("" + s.charAt(start) + s.charAt(end));
            Set<String> tempAns = solve(s, start +1, end - 1);

            if(tempAns.isEmpty()){
                ans.add(s.substring(start, end + 1));
            }else{
                for(String str : tempAns){
                    ans.add(s.charAt(start) + str + s.charAt(end)); 
        }
            }
        } 
        Set<String> leftAns = solve(s, start + 1, end);
        Set<String> rightAns = solve(s, start, end - 1);
        ans.addAll(leftAns);
        ans.addAll(rightAns);
        return ans;
    }
    public Set<String> findPalindromes(String s){
        return solve(s, 0, s.length() - 1);
    }
}