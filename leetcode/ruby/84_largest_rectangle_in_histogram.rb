def largest_rectangle_area(heights)
  stack = []
  best = 0
  n = heights.length

  0.upto(n).each do |idx|
    start_pos = idx
    while !stack.empty? && (idx == n || stack.last[1] > heights[idx])
      rect = stack.pop
      start_pos = rect[0]
      best = [best, (idx - start_pos) * rect[1]].max
    end

    stack << [start_pos, heights[idx]] if idx != n
  end

  best
end
