class Solution {

    /**
    * @param Integer $columnNumber
    * @return String
    */
    function convertToTitle($columnNumber) {
        $arr = array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
        $return = "";
        while ($columnNumber) {
            $columnNumber = $columnNumber - 1;
            $return = $arr[$columnNumber%26] . $return;
            $columnNumber = intdiv($columnNumber, 26);
        }
        return $return;
    }
}



