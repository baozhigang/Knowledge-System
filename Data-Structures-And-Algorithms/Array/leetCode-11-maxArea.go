func maxArea(height []int) int {
	left, right, ans := 0, len(height)-1, 0
	for left < right {
		area := (right - left) * min(height[left], height[right])
		if area > ans {
			ans = area
		}
		if height[left] > height[right] {
			right--
		} else {
			left++
		}
	}
	return ans
}
func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}


