def find_kth_largest(nums, k):
    lo = 0
    hi = len(nums) - 1

    # Change problem statement "Find the element at index k in the sorted version of nums"
    k = len(nums) - k

    while lo <= hi:
        mid = partition(nums, lo, hi)
        if mid == k:
            return nums[mid]

        if mid < k:
            lo = mid + 1
        else:
            hi = mid - 1


def partition(nums, lo, hi):
    r = random.randint(lo, hi)
    swap(nums, hi, r)

    # Lomuto's partitioning algorithm
    i = j = 0
    while j < hi:
        if nums[j] <= nums[hi]:
            swap(nums, i, j)
            i += 1
        j += 1
    swap(nums, i, hi)
    return i


def swap(nums, i, j):
    nums[i], nums[j] = nums[j], nums[i]


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return find_kth_largest(nums, k)
