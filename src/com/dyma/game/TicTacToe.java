package com.dyma.game;

import static com.dyma.game.StringConstants.LINE_SEPARATOR;
import static com.dyma.game.StringConstants.SPACE;

public class TicTacToe {
  private char [][] grid = new char[][] {
    {'.', '.', '.'},
    {'.', '.', '.'},
    {'.', '.', '.'}
  };

  @Override
  public String toString() {
    final var builder = new StringBuilder();
    builder.append("Grille du morpion : ").append(LINE_SEPARATOR);
    for (char[] lines : grid) {
      for (char cell : lines) {
        builder.append(SPACE).append(cell).append(SPACE);
      }
      builder.append(LINE_SEPARATOR);
    }
    return builder.toString();
  }

  public void processInput(Player player, int inputUser) {
    var row = (inputUser - 1) / 3;
    var column = (inputUser - 1) % 3;

    if (grid[row][column] == '.') {
      grid[row][column] = player == Player.FIRST ? 'X' : 'O';
    }
  }
}
