func maxProfit(prices []int) int {
	var ans int
	for i := 1; i < len(prices); i++ {
		ans += max(prices[i]-prices[i-1], 0)
	}
	return ans
}
func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}