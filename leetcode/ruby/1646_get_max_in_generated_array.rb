def get_maximum_generated(n)
  return n if n <= 1
  nums = [0, 1]
  (2...n).each do |i|
    if i % 2 == 0
      nums[i] = nums[i/2]
    else
      nums[i] = nums[i/2] + nums[i/2 + 1]
    end
  end

  nums.max
end