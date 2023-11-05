package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void playGame(){
        Long moneyToBuyLotto = askUserToInsertMoneyToBuyLotto();
        askUserToInsertLottoWinningNumbers();
        askUserToInsertBonusNumber();
        lottoService.playGame();
        endGame();
    }

    private Long askUserToInsertMoneyToBuyLotto(){
        outputView.askUserToInsertMoneyToBuyLotto();
        return inputView.getMoneyToBuyLottoFromUser();
    }

    private void askUserToInsertLottoWinningNumbers(){
        outputView.askUserToInsertLottoWinningNumbers();
    }

    private void askUserToInsertBonusNumber(){
        outputView.askUserToInsertBonusNumber();
    }

    private void endGame(){
        Console.close();
    }
}