import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    Queue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(!minHeap.isEmpty() && minHeap.peek() < num){
            minHeap.add(num);
            if(minHeap.size() - maxHeap.size() > 1)
            {
                int x = minHeap.poll();
                maxHeap.add(x);
            }
        }
        else{
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        double median;
        if(minHeap.size() == maxHeap.size())
        {
            if(minHeap.size() == 0)
                return 0;
            median = (minHeap.peek() + maxHeap.peek())/2.0;
        }
        else if(minHeap.size() > maxHeap.size()){
            median = minHeap.peek();
        }
        else{
            median = maxHeap.peek();
        }
        return median;
    }
}