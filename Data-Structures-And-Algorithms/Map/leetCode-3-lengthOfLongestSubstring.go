func lengthOfLongestSubstring(s string) int {
	left, ans := 0, 0
	m := map[byte]int{}
	for i := 0; i < len(s); i++ {
		if _, ok := m[s[i]]; ok { // 这里注意：判断map中是否存在当前key，用if这种方法
			left = max(m[s[i]]+1, left)
		}
		m[s[i]] = i
		ans = max(ans, i-left+1)
	}
	return ans
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
