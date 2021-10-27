# 深度优先和广度优先

广度优先和深度优先，是针对图、树（树是一种特殊的图）的搜索算法，算法复杂度是O(n)。
深度优先就是基于递归的技巧，而广度优先则是基于迭代的技巧

### 思想

1、深度优先：不撞南墙不回头。利用栈和递归来实现。
2、广度优先：层层递进。利用队列和递归来实现。

### 代码模板

    1.DFS
    visited = set()
    def dfs(node, visited):
        visited.add(node)

        #process current node here
        ...

        for next_node in node.children():
            if not next_node in visited:
                dfs(next_node, visited)

    //适用场景
    //1.快速发现底部节点
    //DFS还有一种使用栈来实现的方法，不如递归好用，了解即可

    2.BFS
    def BFS(graph, start, end):
        queue = []
        queue.append([start])
        visited.add(start)

        while(queue):
            node = queue.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
        # other processing work
        ...

    //适用场景
    //1.寻找最小路径问题

### LeetCode上经典题型

自己找吧☺

