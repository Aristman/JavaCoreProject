package lessons.lesson4;

import java.util.Random;
import java.util.Scanner;

public class BattleShip {

    public static void main(String[] args) {
        System.out.println("Начинаем новую игру!");
        do {
//            play();
        } while (isPlayAgain());
    }

    private static void play(int size, int ships) {
        int [][] board = genereteBoard(size, ships);
    }

    private static int[][] genereteBoard(int size, int ships) {
        int[][] board = new int[size][size];
        Random random = new Random();
        return board;
    }

    private static boolean isPlayAgain() {
        Scanner scaner = new Scanner(System.in);
        int answer;
        do {
            System.out.print("Игра окончена.\nПовторим игру(0 - да/1 - нет)?");
            answer = scaner.nextInt();
        } while (answer != 0 && answer != 1);
        return answer == 1;
    }
}
