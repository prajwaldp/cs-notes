def max_operations(nums, k)
  count = Hash.new(0)
  ans = 0

  nums.each do |num|
    if count[k - num] >= 1
      count[k - num] -= 1
      ans += 1
    else
      count[num] += 1
    end
  end

  ans
end

def max_operations_alt(nums, k)
  nums.sort!
  lo = 0
  hi = nums.length - 1
  ans = 0

  while lo < hi
    diff = nums[lo] + nums[hi] - k
    if diff == 0
      ans += 1
      lo += 1
      hi -= 1
    elsif diff < 0
      lo += 1
    else
      hi -= 1
    end
  end

  ans
end
