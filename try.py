import networkx as nx

g = nx.DiGraph()
g.add_edge(1, 2, weight=3, label='a')
g.add_edge(1, 3, weight=4, label='b')
g.add_edge(2, 3, weight=5)
g.add_edge(1, 4, weight=6)
g