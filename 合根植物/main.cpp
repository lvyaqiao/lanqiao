#include <stdio.h>

class DisjoinSet
{
public:
    int *parent;
    int n;
    DisjoinSet(int n);
    int find(int x);
    void unionSet(int a, int b);
    int count();
};

DisjoinSet::DisjoinSet(int n)
{
    this->n = n;
    parent = new int[n + 1];
    for (int i = 0; i <= n; i++)
    {
        parent[i] = i;
    }
}

int DisjoinSet::find(int x)
{
    if (parent[x] == x)
    {
        return x;
    }
    return parent[x] = find(parent[x]);
}

void DisjoinSet::unionSet(int x, int y)
{
    int a = find(x);
    int b = find(y);
    if (a != b)
    {
        parent[a] = b;
    }
}

int DisjoinSet::count()
{
    int cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        if (parent[i] == i)
        {
            cnt++;
        }
    }
    return cnt;
}

int main()
{
    int n, m;
    int k;
    scanf("%d %d", &n, &m);
    DisjoinSet ds(n * m);
    scanf("%d", &k);

    for (int i = 0; i < k; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        ds.unionSet(a, b);
    }
    int count = 0;
    count = ds.count();
    printf("%d", count);
}