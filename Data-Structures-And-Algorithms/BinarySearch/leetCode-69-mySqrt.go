func mySqrt(x int) int {
	l, r := 0, x
	ans := -1
	for l <= r {
		m := l + (r-l)/2
		if m*m <= x {
			ans = m
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return ans
}