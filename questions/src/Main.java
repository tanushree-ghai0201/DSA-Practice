// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
       /* MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        int[] histogram = {2,1,5,6,2,3};
        int[] histogram2 = {1,1};
        System.out.println(LargestRect.largestRectangleArea(histogram2));
        System.out.println(TrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2}));
        System.out.println(LIS.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));*/
 /*       Calendar cl  = new Calendar();
        System.out.println(cl.book(47,50));
        System.out.println(cl.book(33,41));
        System.out.println(cl.book(39,45));
        System.out.println(cl.book(33,42));
        System.out.println(cl.book(25,32));
        System.out.println(cl.book(26,35));
        System.out.println(cl.book(19,25));
        System.out.println(cl.book(3,8));
        System.out.println(cl.book(8,13));
        System.out.println(cl.book(18,27));*/
        /*canChange cn = new canChange();
        System.out.println(cn.check("_L__R__R_", "L______RR"));*/
        WordLadder2 wl = new WordLadder2();
        System.out.println(wl.findLadders("hit", "cog", Arrays.asList("hot","dot", "dog", "lot", "log", "cog")));

    }
}