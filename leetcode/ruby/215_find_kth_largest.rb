def find_kth_largest(nums, k)
  lo = 0
  hi = nums.length - 1

  # Change problem statement "Find the element at index k in the sorted version of nums"
  k = nums.length - k

  while lo <= hi
    mid = partition(nums, lo, hi)
    return nums[mid] if mid == k

    if mid < k
      lo = mid + 1
    else
      hi = mid - 1
    end
  end
end

def partition(nums, lo, hi)
  r = rand(lo..hi)
  swap(nums, hi, r)

  # Lomuto's partitioning algorithm
  i = j = 0
  while j < hi
    if nums[j] <= nums[hi]
      swap(nums, i, j)
      i += 1
    end
    j += 1
  end
  swap(nums, i, hi)
  i
end

def swap(nums, i, j)
  nums[i], nums[j] = nums[j], nums[i]
end
