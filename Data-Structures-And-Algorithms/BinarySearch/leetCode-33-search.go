func search(nums []int, target int) int {
	minIdx := findMinIdx(nums)
	if nums[minIdx] == target {
		return minIdx
	}
	left, right := 0, len(nums)-1
	if target <= nums[right] {
		left = minIdx + 1
	} else {
		right = minIdx - 1
	}
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		}
	}
	return -1
}
func findMinIdx(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left)/2
		if nums[mid] > nums[right] {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}

