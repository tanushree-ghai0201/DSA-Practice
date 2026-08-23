import java.util.List;

public class Celebrities {
private static boolean knows(int a, int b, List<List<Integer>> relationships)
    {
        return relationships.get(a).get(b) == 1;
    }
    public static int findTheCelebrity(int n, List<List<Integer>> relationships) {
        int celebrity = 0;
        for(int i = 1; i < n; i ++){ //O(n)
            if(knows(celebrity, i, relationships))
                celebrity = i;
        }
        // reverse validate -O(2(n - 1))
        for(int i = 0; i < n && i != celebrity; i ++){
            if(!knows(i, celebrity, relationships) || knows(celebrity, i , relationships))
                return -1;
        }
        return celebrity;
    }
}
