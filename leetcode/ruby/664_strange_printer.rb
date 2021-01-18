# Can be solved similar to 546. Count Boxes
def strange_printer(s)
  n = s.length
  dp = Array.new(n) { Array.new(n, 0) }
  n.times do |i|
    dp[i][i] = 1
    dp[i][i + 1] = (s[i] == s[i + 1] ? 1 : 2) if i + 1 < n
  end

  2.upto(n - 1).each do |len|
    start = 0
    while start + len < n
      dp[start][start + len] = len + 1
      len.times do |k|
        temp = dp[start][start + k] + dp[start + k + 1][start + len]
        dp[start][start + len] = [
          dp[start][start + len],
          s[start + k] == s[start + len] ? temp - 1 : temp
        ].min
      end
      start += 1
    end
  end

  dp[0][n - 1]
end
