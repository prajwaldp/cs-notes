class TicTacToe
  def initialize(n)
    @n = n
    @rows = Array.new(n)
    @cols = Array.new(n)
    @diag = 0
    @anti_diag = 0
  end

  def move(row, col, player)
    code = player == 1 ? 1 : -1
    @rows[row] += code
    @cols[col] += code

    if row == col
      @diag += code
    end

    if row == @n - 1 - col
      @anti_diag += code
    end

    if @rows[row] == @n || @cols[col] == @n || @diag == @n || @anti_diag == @n ||
       @rows[row] == -@n || @cols[col] == -@n || @diag == -@n || @anti_diag == -@n
      return player
    end

    0
  end
end
