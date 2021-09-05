func maxProfit(prices []int) int {
	low, diff := prices[0], 0
	for i := 1; i < len(prices); i++ {
		if prices[i] < low {
			low = prices[i]
		}
		if prices[i]-low > diff {
			diff = prices[i] - low
		}
	}
	return diff
}
