import heapq

from collections import defaultdict
from typing import List


def dijkstras(n: int, edges: List[List[int]]) -> List[int]:
    g = defaultdict(list)
    for u, v, w in edges:
        g[u].append((v, w))
        g[v].append((u, w))

    shortest_dist = [float('inf')] * n + [0]
    visited = set()
    heap = [(0, n)]

    while heap:
        node_dist, node = heapq.heappop(heap)
        visited.add(node)

        # Why not set shortest_dist[node] = node_dist here?
        # ----
        # Adding a (node, node_dist) pair into the heap just to ignore it here
        # because shortest_dist[node] is smaller than node_dist is
        # more computations.
        # Instead add the (node, node_dist) pair into the heap only if that pair
        # is a potential shortest distance pair

        for neighbor, weight in g[node]:
            if neighbor not in visited and (neighbor_dist := node_dist + weight) < shortest_dist[neighbor]:
                heapq.heappush(heap, (neighbor_dist, neighbor))
                shortest_dist[neighbor] = neighbor_dist

    return shortest_dist
