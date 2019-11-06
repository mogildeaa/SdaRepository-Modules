package com.sda.concentration;

public class Main {

    public static void main(String[] args) {

        HumanPlayer player1 = new HumanPlayer("Gabriel");
        Referee arbitru = new Referee(4, player1);
//        arbitru.play();

        BotPlayer player2 = new BotPlayer("Calculator");
        Referee botArbistru = new Referee(4,player2);
        botArbistru.play();
    }
}
