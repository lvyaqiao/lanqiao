from heapq import heappush, heappop

class Graph:
    def __init__(self,n, m, arr):
        self.n = n
        self.m = m
        self.matrix = arr
        
    def neighbors(self, i, j):
        ans = [] # 点到他的邻居的距离和邻居的位置
        # 一个点可以通向的点是他的上下左右四个点，但是不包括边界点
        for x, y in [i-1, j], [i+1, j], [i, j-1], [i, j+1]:
            # 他的上下左右四个点
            if 0 <= x < self.n and 0 <= y < self.m:
                # 如果在矩阵内
                location = (x, y)
                weight = self.matrix[x][y]
                ans.append((weight, location))
        return ans

def get_input():
    n, m = [int(x) for x in input().split()]
    arr = [[int(i) for i in input().split()] for i in range(n)]
    return n, m, arr

def main():
    n, m, arr = get_input()
    vis = [[0] * m for i in range(n)]
    min_time = {}
    graph = Graph(n,m,arr)
    
    pq = [] # 优先队列 
    cur = (arr[0][0], (0,0)) # 1号点的距离和位置
    heappush(pq, cur)
    while pq:
        cur = heappop(pq) # 取出当前点
        dist = cur[0]  # 到这个点的距离
        i, j = cur[1]  # 当前点的位置
        if vis[i][j]:
            # 如果这个点已经被染色过
            continue
        else:
            for neighbor_weight, location in graph.neighbors(i, j):
                # 这个点的邻居
                x, y = location # 相邻点的坐标
                if vis[x][y] == 0:
                    heappush(pq, (dist+ neighbor_weight, location))
            vis[i][j] = 1
            min_time[(i,j)] = dist
    
    print(max(min_time.values()))
    return

main()