class Solution {
    public int removeElement(int[] nums, int val) {
        int right = nums.length;
        int left = 0;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}

