点
        for x, y in [i-1, j], [i+1, j], [i, j-1], [i, j+1]:
            if 0 <= x < self.n and 0 <= y < self.m:
                location = (x, y)
                weight = self.matrix[x][y]
                ans.append((weight, location))
        return ans

def get_input():
    n, m = [int(x) for x in input().split()]
    arr = [[int(i) for i in input.split()] for i in range(2)]
    return n, m, arr

def main():
    n, m, arr = get_input()
    vis = [[0] * m for i in range(n)]
    
    graph = Graph(arr)
    
    pq = []
    cur = (arr[0][0], (0,0))
    heappush(pq, cur)
    while pq:
        cur = heappop(pq)
        dist = cur[0]
        i, j = cur[1]
        if vis[i][j]:
            continue
        elif i == n-1 and j == m-1:
            print(dist)
            return
        else:
            for weight, location in graph.neighbors(i, j):
                x, y = location
                if vis[x][y] == 0:
                    heappush(pq, (dist+weight, location))
            vis[i][j] = 1
    print(-1)
    return

main()