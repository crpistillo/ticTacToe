// TODO: Esta es la interfaz de la vista, totalmente desacoplada de su implementacion

package com.acme.tictactoe.view;

public interface TicTacToeView {
    void showWinner(String winningPlayerDisplayLabel);
    void clearWinnerDisplay();
    void clearButtons();
    void setButtonText(int row, int col, String text);
}
