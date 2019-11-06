package com.sda.concentration;

import java.util.Random;

import static com.sda.concentration.Symbol.SYMBOL_DIEZ;

public class Board {

    private Piece[][] matrice;

    Board(int size) {
        matrice = new Piece[size][size];

        Symbol arr[] = Symbol.values();
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                int row;
                int col;
                do {
                    row = r.nextInt(size);
                    col = r.nextInt(size);
                } while (matrice[row][col] != null);
                matrice[row][col] = new Piece(arr[i]);
            }
        }
    }

    @Override
    public String toString() {
        String acumulator = "";
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if (matrice[i][j].hiden) {
                    acumulator += "X";
                } else {
                    acumulator += matrice[i][j].Sy;
                }
            }
            acumulator += "\n";
        }
        return acumulator;
    }


    public void reveal(int a, int b) {
        matrice[a][b].hiden = false;
    }

    public boolean isMatch(int[] coord, int[] secondCoord) {
        if(matrice[coord[0]][coord[1]].Sy == matrice[secondCoord[0]][secondCoord[1]].Sy){
            return true;
        } else {
            return false;
        }
    }

    public void hide(int i, int i1) {
        matrice[i][i1].hiden = true;
    }

    public boolean isHidden(int[] coord) {
       return matrice[coord[0]][coord[1]].hiden;
    }

    public boolean isGameOver() {
        boolean finish = false;
        int count = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if(matrice[i][j].hiden == true){
                    count++;
                }
                if(count !=0){
                    break;
                }
            }
        }
        if (count == 0){
            finish = true;
        }
        return finish;
    }
}
