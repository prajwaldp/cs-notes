def count_vowel_strings(n)
  cache = Hash.new
  backtrack(1, 1, n, cache)
end

def backtrack(pos, prev, n, cache)
  return 1 if pos == n + 1
  key = "#{pos}-#{prev}"
  return cache[key] if cache.has_key?(key)
  ans = 0
  prev.upto(5).each do |i|
    ans += backtrack(pos + 1, i, n, cache)
  end
  cache[key] = ans
end
