import java.util.*;

public class RPCServerLogs {
    public int timeStamp;
    public int id;
    public String type; // 0 - start 1 - end

    public RPCServerLogs(int id, int timestamp, String type) {
        this.id = id;
        this.timeStamp = timestamp;
        this.type = type;
    }


    private static List<int[]> getAllTimeoutRequests(List<RPCServerLogs> requests, int timeout) {
        // Queue will keep the entry of [process id, timeout]
        Queue<int[]> queue = new LinkedList<>();
        // Set will keep only process id
        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (RPCServerLogs request: requests) {
            int currTS = request.timeStamp;

            // remove the entries which are supposed to be timedOut at current time
            while (!queue.isEmpty() && queue.peek()[1] < currTS) {
                int[] entry = queue.poll();
                if (!set.contains(entry[0])) {
                    continue;
                }
                result.add(new int[]{entry[0], currTS});
            }

            if (request.type.equals("START")) {
                set.add(request.id);
                queue.add(new int[]{request.id, currTS+timeout});
            } else {
                set.remove(request.id);
            }
        }
        return result;
    }

}