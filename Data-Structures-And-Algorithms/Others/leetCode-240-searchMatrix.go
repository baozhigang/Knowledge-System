func searchMatrix(matrix [][]int, target int) bool {
	row, col := 0, len(matrix[0])-1
	for row < len(matrix) && col >= 0 {
		if target > matrix[row][col] {
			row++
		} else if target < matrix[row][col] {
			col--
		} else {
			return true
		}
	}
	return false
}

