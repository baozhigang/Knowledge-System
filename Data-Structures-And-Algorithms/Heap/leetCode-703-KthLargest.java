import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int value) {
        pq.offer(value);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2,7,9};
        KthLargest kl = new KthLargest(3, nums);
        int ret = kl.add(11);
        System.out.println(ret);
    }
}
