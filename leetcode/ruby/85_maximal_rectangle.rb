# Strategy
# Build a matrix where each row is a histogram
# Use 84. Largest Rectangle in Histogram on every row

def maximal_rectangle(matrix)
  m = matrix.length
  return 0 if m == 0

  n = matrix[0].length

  n.times do |c|
    matrix[0][c] = matrix[0][c] == "1" ? 1 : 0
  end

  # Convert to histogram rows (of Integers)
  1.upto(m - 1).each do |r|
    n.times do |c|
      if matrix[r][c] == "1"
        matrix[r][c] = 1 + matrix[r - 1][c]
      else
        matrix[r][c] = 0
      end
    end
  end

  best_area = 0
  matrix.each do |row|
    best_area = [best_area, maximum_rectangle_in_histogram(row)].max
  end

  best_area
end

def maximum_rectangle_in_histogram(hist)
  stack = []
  best = 0
  n = hist.length

  0.upto(n).each do |idx|
    start_pos = idx
    while !stack.empty? && (idx == n || stack.last[1] > hist[idx])
      rect = stack.pop
      best = [best, (idx - rect[0]) * rect[1]].max
      start_pos = rect[0]
    end
    stack << [start_pos, hist[idx]] if idx != n
  end

  best
end
