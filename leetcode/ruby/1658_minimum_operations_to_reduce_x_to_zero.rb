def min_operations(nums, x)
  target_window_sum = nums.sum - x
  return nums.length if target_window_sum == 0
  ans, i, window_sum = -1, 0, 0

  nums.length.times do |j|
    window_sum += nums[j]
    while i <= j && window_sum >= target_window_sum
      if window_sum == target_window_sum
        ans = [ans, j - i + 1].max
      end

      window_sum -= nums[i]
      i += 1
    end
  end

  ans == -1 ? ans : nums.length - ans
end

# total_sum = sum(nums)
# target_window_sum = total_sum - x
# find the largest window with target_window_sum
#
# Finding the largest window sum?
# Two pointers
# i .... j (inclusive defines a window)
# if sum(window) == target_sum, check window size, then increment j
# if sum(window) > target_sum, increment i
# if sum(window) < target_sum, increment j