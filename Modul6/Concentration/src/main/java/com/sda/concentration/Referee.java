package com.sda.concentration;

public class Referee {

    IPlayeri player1;
    Board table;

    public Referee(int size, IPlayeri player) {
        table = new Board(size);
        this.player1 = player;
    }


    public void play() {

        while (table.isGameOver() == false) {
            System.out.println(table);

            int[] coord;
            while (true) {
                coord = player1.getCoord();
                if (table.isHidden(coord)) {
                    table.reveal(coord[0], coord[1]);
                    break;
                }
            }

            System.out.println(table);

            int[] secondCoord;
            while (true) {
                secondCoord = player1.getCoord();
                if (table.isHidden(secondCoord)) {
                    table.reveal(secondCoord[0], secondCoord[1]);
                    break;
                }
            }

            System.out.println(table);

            if (table.isMatch(coord, secondCoord) == false) {
                table.hide(coord[0], coord[1]);
                table.hide(secondCoord[0], secondCoord[1]);
            }
        }
    }
}
