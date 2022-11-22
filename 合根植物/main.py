class DisjoinSet:
    def __init__(self, n):
        self.father = [i for i in range(n)]
        
    def find(self, x):
        if self.father[x] == x:
            return x
        self.father[x] = self.find(self.father[x])
        return self.father[x]
    
    def union(self, x, y):
        fx = self.find(x)
        fy = self.find(y)
        if fx != fy:
            self.father[fx] = fy
    
    def num_of_sets(self):
        return len(set([self.find(x) for x in self.father]))


def solution():
    m, n = [int(x) for x in input().split()]
    k = int(input())
    s = DisjoinSet(m * n)
    for i in range(k):
        # 下标从 0 开始， 但是输入数据是从 1 开始的
        a, b = [int(x)-1 for x in input().split()]
        s.union(a, b)
    print(s.num_of_sets())
        
solution()
        
    
    
        
    
