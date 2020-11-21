=begin
3[a2[c]]

3, ""
0, "acc"
=end

def decode_string(s)
  k, curr_str = 0, ""
  stack = []

  s.chars.each do |c|
    if c == '['
      stack.push [k, curr_str]
      k = 0
      curr_str = ""
    elsif c == ']'
      prev_k, prev_str = stack.pop
      curr_str = prev_str + curr_str * prev_k
    elsif c >= '0' && c <= '9'
      k = k * 10 + c.to_i;
    else
      curr_str += c
    end
  end

  curr_str
end

p decode_string("3[a2[c]]")
p decode_string("3[a]2[bc]")
