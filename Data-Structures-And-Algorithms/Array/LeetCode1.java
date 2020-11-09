//方法一： 时间复杂度 O(N^2) 空间复杂度 O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

// 方法二： 时间复杂度 O(N), 空间复杂度O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        hashtable.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            if (hashtable.containsKey(target-nums[i])) {
                return new int[]{hashtable.get(target-nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[]{};
    }
}
