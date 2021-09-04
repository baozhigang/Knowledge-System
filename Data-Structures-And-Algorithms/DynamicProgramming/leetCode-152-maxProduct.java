public class MaxProduct {
    public int maxProduct(int[] nums) {
        int ret = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = oneMaxProduct(nums, i);
            if (temp > ret) {
                ret = temp;
            }
        }
        return ret;
    }

    private int oneMaxProduct(int[] nums, int index) {
        int ret = nums[index];
        int temp = 1;
        for (int j = index; j < nums.length; j++) {
            temp *= nums[j];
            if (temp > ret) {
                ret = temp;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] arr = {2,3,-2,4};
        int ret = maxProduct.maxProduct(arr);
        System.out.println(ret);
    }
}
