# Tarjan's Algorithm for Strongly Connected Components

## DFS Number

- As a DFS traverses a graph, it visits nodes in some order.
- Starting with the number 0, we number each vertex according to the order in which the DFS visits it.
- Can be written as `dfsNum[v]`

## Tarjan's Algorithm

- Runs DFS on the graph
- Outputs the SCC [SCC = Strongly Connected Component] when that SCC's lowest DFS numbered vertex is finished by the DFS.


```
A ----- B
|      /|
|    /  |
|  /    |
| /     |
D       C
```

1. Visit and label `A`, dfsNumber[A] = 1, oldestReachable[A] = 1
2. Visit and label `D`. dfsNumber[D] = 2, oldestReachable[D] = 2
3. Visit and label `B`, dfsNumber[B] = 3, oldestReachable[B] = 3
4. Visit and label `C`, dfsNumber[C] = 4, oldestReachable[C] = 4
5. Backtrack to the call to *Visit and label `B`*
6. Compare oldestReachable[C] (what was previously processed) and oldestReachable[B] (the current call in the stack)
