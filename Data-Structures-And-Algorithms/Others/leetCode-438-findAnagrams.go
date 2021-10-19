func findAnagrams(s string, p string) []int {
	n, m := len(s), len(p)
	if n < m {
		return []int{}
	}

	result := make([]int, 0)
	sCnt := [26]int{}
	pCnt := [26]int{}
	for i := 0; i < m; i++ {
		sCnt[s[i]-'a']++
		pCnt[p[i]-'a']++
	}
	if sCnt == pCnt {
		result = append(result, 0)
	}
	for i := m; i < n; i++ {
		sCnt[s[i]-'a']++
		sCnt[s[i-m]-'a']--
		if sCnt == pCnt {
			result = append(result, i-m+1)
		}
	}
	return result
}