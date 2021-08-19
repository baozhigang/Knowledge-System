import java.util.*;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6};
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] ret = msw.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ret));
    }
}
