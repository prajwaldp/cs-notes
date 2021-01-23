class SparseVector:
    def __init__(self, nums: List[int]):
        self.container = dict()
        
        for i, n in enumerate(nums):
            if n != 0:
                self.container[i] = n
        

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        s = 0
        for k, v in vec.container.items():
            if k in self.container:
                s += self.container[k] * v

        return s
