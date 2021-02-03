from collections import deque

class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.data = deque()

        if v1:
            self.data.append((len(v1), iter(v1)))
        if v2:
            self.data.append((len(v2), iter(v2)))

    def next(self) -> int:
        len_, it = self.data.popleft()
        if len_ > 1:
            self.data.append((len_ - 1, it))
        return next(it)

    def hasNext(self) -> bool:
        return len(self.data) > 0
