def min_steps(n)
  primes = (n + 1).times.map { true }
  primes[0] = primes[1] = false

  (2...n).each do |i|
    next unless primes[i]
    j = i + i
    while j <= n
      primes[j] = false
      j += i
    end
  end

  primes = primes.each_with_index.filter do |is_prime, num|
    is_prime
  end.map do |_, num|
    num
  end

  steps = 0
  while n % 2 == 0
    steps += 2
    n /= 2
  end

  return steps if n == 1

  largest_prime_divisor = 1

  primes.each do |prime|
    largest_prime_divisor = prime if n % prime == 0
  end

  if largest_prime_divisor == n
    steps += n
  else
    steps += min_steps(n / largest_prime_divisor) + largest_prime_divisor
  end
end
