package com.dyma.game;

import static com.dyma.game.StringConstants.LINE_SEPARATOR;
import static com.dyma.game.StringConstants.SPACE;

import com.dyma.exceptions.TicTacToeInvalidInputException;

public class TicTacToe {
  private char [][] grid = new char[][] {
    {'.', '.', '.'},
    {'.', '.', '.'},
    {'.', '.', '.'}
  };

  @Override
  public String toString() {
    final var builder = new StringBuilder();
    builder.append("Grille du morpion (exit ou quit pour quitter le jeu) : ").append(LINE_SEPARATOR);
    for (char[] lines : grid) {
      for (char cell : lines) {
        builder.append(SPACE).append(cell).append(SPACE);
      }
      builder.append(LINE_SEPARATOR);
    }
    return builder.toString();
  }

  public void processInput(Player player, int inputUser) throws TicTacToeInvalidInputException {
    var row = (inputUser - 1) / 3;
    var column = (inputUser - 1) % 3;

    if (grid[row][column] == '.') {
      grid[row][column] = player == Player.FIRST ? 'X' : 'O';
    } else {
      throw new TicTacToeInvalidInputException("La case est déjà prise");
    }
  }

  public boolean checkWin() {
    var checkDiagonal1 = grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '.';
    var checkDiagonal2 = grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '.';

    if (checkDiagonal1 || checkDiagonal2) {
      return true;
    }

    for (int i = 0; i < 3; i++) {
      var checkRow = grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '.';
      var checkColumn = grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '.';

      if (checkRow || checkColumn) {
        return true;
      }
    }

    return false;
  }

  public boolean checkDraw() {
    for (char[] row : grid) {
      for (char cell : row) {
        if (cell == '.') {
          return false;
        }
      }
    }
    return true;
  }
}
