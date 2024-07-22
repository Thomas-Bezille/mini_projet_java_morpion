package com.dyma.exceptions;

public class TicTacToeInvalidInputException extends Exception {
  public TicTacToeInvalidInputException(String message) {
    super(message);
  }

  public TicTacToeInvalidInputException() {
    super();
  }
}
