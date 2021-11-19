class Solution {

    /**
    * @param Integer[] $nums
    * @param Integer $target
    * @return Integer[]
    */
    function twoSum($nums, $target) {
        $map = [];
        foreach ($nums as $k => $v) {
            $map[$v] = $k;
        }
        foreach ($nums as $key => $value) {
            $item = $target - $value;
            if (isset($map[$item]) && $map[$item] != $key) {
                return [$key, $map[$item]];
            }
        }
        return [];
    }

}