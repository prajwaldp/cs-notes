class Vector2D:

    def __init__(self, v: List[List[int]]):
        self.v = v
        self.i = 0
        self.j = 0

    def next(self) -> int:
        if self.hasNext():
            next_ = self.v[self.i][self.j]
            self.j += 1
            return next_

        return -1

    def hasNext(self) -> bool:
        while self.i < len(self.v) and self.j == len(self.v[self.i]):
            self.i += 1
            self.j = 0

        return self.i < len(self.v)
