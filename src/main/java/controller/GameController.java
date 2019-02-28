package controller;

import domain.Chip;
import domain.Dealer;
import domain.User;
import view.InputView;

public class GameController {
    private static User user;
    private static User computer;
    private static Dealer dealer;

    public static void run() {
        user = new User(InputView.name());
        computer = new User("컴퓨터");
        dealer = new Dealer();
        start();
    }

    private static void start() {
        baseBet();
        divideCard();

    }

    private static void baseBet() {
        Chip baseChip = new Chip(100);
        user.defaultBet(baseChip);
        dealer.plus(baseChip);
        computer.defaultBet(baseChip);
        dealer.plus(baseChip);
    }

    private static void divideCard() {
        dealer.cardShuffle();
        user.receiveCard(dealer.passCard());
        computer.receiveCard(dealer.passCard());
    }
}