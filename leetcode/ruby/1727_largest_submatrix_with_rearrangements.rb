def largest_submatrix(matrix)
  m = matrix.length
  n = matrix[0].length

  (m - 2).downto(0).each do |r|
    n.times do |c|
      if matrix[r][c] == 1
        matrix[r][c] = matrix[r + 1][c] + 1
      end
    end
  end

  best_area = 0

  m.times do |r|
    matrix[r].sort!
    n.times do |c|
      best_area = [best_area, matrix[r][c] * (n - c)]
    end
  end

  best_area
end
