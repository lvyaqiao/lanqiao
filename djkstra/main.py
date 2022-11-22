from heapq import heappush, heappop

class Graph:
    def __init__(self, n):
        self.n = n
        self.graph = [{} for i in range(n + 1)]
            
    def add_edge(self,u, v, weight):
        self.graph[u][v] = weight
        
    def get_weight(self, u, v):
        return self.graph[u][v]

    def neighbors(self, u):
        return self.graph[u].items()

def get_input():
    n, m = [int(x) for x in input().split()]
    g = Graph(n)
    for i in range(m):
        u, v, w = [int(x) for x in input().split()]
        g.add_edge(u, v, w)
    return n, g

def solution():
    n, g = get_input()
    vis = [False] * (n + 1)
    # 第一个元素是距离，第二个元素是节点，这样的话就可以自动比较距离
    # 因为元组的比较是从第一个元素开始比较的
    pq = [(0, 1)]
    while pq:
        # 拿出下一条最短路径
        d, u = heappop(pq)
        # 如果在之前就拿出过到这个点的路径，那这个路径一定不是最短的，直接跳过
        if vis[u]:
            continue
        # 是答案的话，直接输出，然后结束
        elif u == g.n:
            print(d)
            return
        else:
            # 否则，把这个点标记为已经访问过，然后把这个点的所有邻居加入到优先队列中
            vis[u] = True
            for v, w in g.neighbors(u):
                heappush(pq, (d + w, v))
    # 没找到
    print(-1)

solution()

