DIRECTIONS = [[0, -1], [0, 1], [-1, 0], [1, 0]]

def num_islands2(m, n, positions)
  root = Array.new(m * n, -1)
  island_count = 0

  positions.map do |i, j|
    curr_island = i * n + j
    if root[curr_island] == -1
      root[curr_island] = curr_island
      island_count += 1

      DIRECTIONS.each do |x, y|
        x += i
        y += j
        neigh_island = x * n + y
        next if x < 0 || y < 0 || x >= m || y >= n || root[neigh_island] == -1

        neigh_island_root = find(root, neigh_island)
        if root[curr_island] != neigh_island_root
          root[curr_island] = neigh_island_root
          curr_island = neigh_island_root
          island_count -= 1
        end
      end
    end
    island_count
  end
end

def find(root, x)
  if x != root[x]
    root[x] = find(root, root[x])
  end
  root[x]
end
