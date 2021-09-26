class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == []:
            return 0

        def dfs(m, n, i, j):
            if i<0 or i>=m or j<0 or j>=n or grid[i][j]=="0":
                return
            grid[i][j] = "0"
            dfs(m, n, i-1, j)
            dfs(m, n, i+1, j)
            dfs(m, n, i, j-1)
            dfs(m, n, i, j+1)

        ret = 0
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    ret+=1
                    dfs(m, n, i, j)

        return ret
