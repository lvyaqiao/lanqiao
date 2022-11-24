from collections import deque

class Graph:
    def __init__(self, n):
        self.n = n
        self.edges = [{} for _ in range(n+1)]
        
    def add_edge(self, x, y, z):
        self.edges[x][y] = z
    
    def neighbors(self, x):
        return self.edges[x].items()
    
    
def get_input():
    n, m = [int(i) for i in input().split()]
    g = Graph(n)
    for _ in range(m):
        x, y, z = [int(i) for i in input().split()]
        g.add_edge(x, y, z)
    return n,m,g


def main():
    n,m,g = get_input()
    q = deque()    
    dist = [float('inf') for _ in range(n+1)]
    dist[1] = 0
    q.append(1)
    while q:
        cur = q.popleft()
        for nei, cost in g.neighbors(cur):
            if dist[nei] > dist[cur] + cost:
                dist[nei] = dist[cur] + cost
                q.append(nei)
                
    if dist[n] == float('inf'):
        print("impossible")
    else:
        print(dist[n])
    return

main()
    
    
        
    