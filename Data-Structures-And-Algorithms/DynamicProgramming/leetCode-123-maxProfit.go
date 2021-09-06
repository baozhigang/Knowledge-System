func maxProfit(prices []int) int {
	buy1, buy2 := -prices[0], -prices[0]
	sell1, sell2 := 0, 0

	for i := 1; i < len(prices); i++ {
		buy1 = max(buy1, -prices[i])
		sell1 = max(sell1, buy1+prices[i])
		buy2 = max(buy2, sell1-prices[i])
		sell2 = max(sell2, buy2+prices[i])
	}
	return sell2
}

func max(x int, y int) int {
	if x > y {
		return x
	}
	return y
}
