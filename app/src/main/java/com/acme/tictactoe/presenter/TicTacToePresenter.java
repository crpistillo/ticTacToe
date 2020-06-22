package com.acme.tictactoe.presenter;

// TODO: Implementacion del Presenter
// TODO: Ya de alguna forma aca tenemos una manera de tener desacoplada la interfaz de la implementacion
// TODO: El presenter ya no tiene referencias a Android, sino que se trabaja directamente contra una interfaz
// TODO: que es una interfaz de la vista => Gestionamos la logica de la aplicacion sin en ningun momento
// TODO: estar trabajando con Android

import com.acme.tictactoe.model.Board;
import com.acme.tictactoe.model.Player;
import com.acme.tictactoe.view.TicTacToeView;

public class TicTacToePresenter implements Presenter {

    private TicTacToeView view; // TODO: La implementacion trabaja contra el view (linkea el view)
    private Board model; //TODO: La implementacion trabaja contra el modelo (linkea el modelo)

    public TicTacToePresenter(TicTacToeView view) {
        this.view = view;
        this.model = new Board();
    }

    @Override
    public void onCreate() {
        model = new Board();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onButtonSelected(int row, int col) {
        Player playerThatMoved = model.mark(row, col);

        if(playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString());

            if (model.getWinner() != null) {
                view.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSelected() {
        view.clearWinnerDisplay();
        view.clearButtons();
        model.restart();
    }


}
