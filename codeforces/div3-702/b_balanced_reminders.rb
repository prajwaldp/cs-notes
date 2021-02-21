def solve
  count = [0, 0, 0]
  n = gets.to_i
  arr = gets.split(' ').map(&:to_i)
  arr.each do |i|
    count[i % 3] += 1
  end

  ans = 0

  2.times do
    3.times do |i|
      if count[i] > n / 3
        ans += count[i] - n / 3
        count[(i + 1) % 3] += count[i] - n / 3
        count[i] = n / 3
      end
    end
  end

  puts ans
end


t = gets.to_i
t.times { solve }