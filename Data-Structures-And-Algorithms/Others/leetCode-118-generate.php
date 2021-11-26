class Solution {

    /**
    * @param Integer $numRows
    * @return Integer[][]
    */
    function generate($numRows) {
        $ret = [];
        for ($i=0; $i<$numRows; $i++) {
            $row = [];
            for ($j=0; $j<=$i; $j++) {
                if ($j == 0 || $j == $i) {
                    $row[] = 1;
                } else {
                    $row[] = $ret[$i-1][$j-1] + $ret[$i-1][$j];
                }
            }
            $ret[] = $row;
        }
        return $ret;
    }
}



