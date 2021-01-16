# frozen_string_literal: true

# An element to be inserted into the Priority Queue
class Element
  include Comparable
  attr_accessor :key, :val

  def initialize(key, val)
    @key = key
    @val = val
  end

  def <=>(other)
    @key <=> other.key
  end
end

# A heap data-structure for implementing a priority queue
# Usages in: leetcode/ruby/253_meeting_rooms_ii.rb
class PriorityQueue
  def initialize
    @elements = [nil]
  end

  def <<(element)
    @elements << element
    bubble_up(@elements.size - 1)
  end

  def empty?
    @elements.size == 1
  end

  def size
    @elements.size - 1
  end

  def top
    @elements[1].val
  end

  def pop
    swap(1, @elements.size - 1)
    top = @elements.pop
    bubble_down(1)
    top
  end

  private

  def bubble_up(idx)
    return if idx <= 1

    parent_idx = idx / 2
    return if @elements[parent_idx] >= @elements[idx]

    swap(idx, parent_idx)
    bubble_up(parent_idx)
  end

  def bubble_down(idx)
    child_idx = idx * 2
    return if child_idx > @elements.size - 1

    not_the_last_element = child_idx < @elements.size - 1
    left_element = @elements[child_idx]
    right_element = @elements[child_idx + 1]
    child_idx += 1 if not_the_last_element && right_element > left_element

    return if @elements[idx] >= @elements[child_idx]

    swap(idx, child_idx)
    bubble_down(child_idx)
  end

  def swap(i, j)
    @elements[i], @elements[j] = @elements[j], @elements[i]
  end
end
