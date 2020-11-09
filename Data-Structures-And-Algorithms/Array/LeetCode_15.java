class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        
        // 数组排序
        Arrays.sort(nums);
        int len = nums.length;
        // 数组个数小于3，直接返回
        if (len < 3) return lists;

        for(int i=0; i<len; ++i) {
            // 排序后第一个数不能大于0
            if (nums[i] > 0) return lists;
            // 对第一个数进行去重处理
            if(i>0 && nums[i-1] == nums[i]) continue;        
            
            // 双指针排序
            int curr = nums[i];
            int L = i+1; int R = len-1;
            while (L < R) {
                int temp = curr + nums[L] + nums[R];
                if(temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 第二、三个数去重复
                    while (L<R && nums[L] == nums[L+1]) ++L;
                    while (L<R && nums[R] == nums[R-1]) R--;
                    ++L;
                    --R;
                } else if (temp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }

        return lists;
    }
}
