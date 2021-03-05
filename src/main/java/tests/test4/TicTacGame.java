/*
 *
 *Занятие №4. Домашнее задание.
 *Выполнил: Студент Аристов Сергей Константинович
 *Реализации консольной игры "Крестики-Нолики"
 *
 * ИИ реализован не полностью.
 */


package tests.test4;

import java.util.Random;
import java.util.Scanner;

public class TicTacGame {

    private static final int DIMENSION = 15; // Размер игрового поля
    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final int WIN_COUNT = 5; // Длина победной цепочки
    private static char[][] gameField;


    public static void main(String[] args) {
        System.out.println(
                "---------------------------------------\n" +
                        "Добро пожаловать в игру Крестики-нолики" +
                        "\n---------------------------------------");
        if (confirm("Показать правила игры?")) {
            rules();
        }
        do {
            play();

        } while (confirm("Продолжим новую партию?"));
    }

    private static void play() {
        gameField = getBeginGameField();
        printGameField();
        do {
            int[] humanXY = humanTurn();
            if (isWin("Вы победили! Поздравляю", DOT_X)) {
                printGameField();
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }
            computerTurn(humanXY);
            if (isWin("Победил компьютер", DOT_0)) {
                printGameField();
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                printGameField();
                break;
            }
            printGameField();
        } while (true);
    }

    public static boolean isFieldFull() {
        for (char[] row : gameField) {
            for (char item : row) {
                if (item == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void computerTurn(int[] humanXY) {
        if (humanXY[0] == 0 && humanXY[1] == 0 || humanXY[0] == DIMENSION - 1 && humanXY[1] == DIMENSION - 1
                || humanXY[0] == 0 && humanXY[1] == DIMENSION - 1 || humanXY[0] == DIMENSION - 1 && humanXY[1] == 0) {
            randomComputerTurn();
            return;
        }
        if (humanXY[0] == 0 || humanXY[0] == DIMENSION - 1) { // Обработка ответного хода если человек походил сверху или снизу поля
            if (putBlockStep(humanXY, 0, -1)) {
                return;
            }
            if (putBlockStep(humanXY, 0, 1)) {
                return;
            }
            randomComputerTurn();
            return;
        }
        if (humanXY[1] == 0 || humanXY[1] == DIMENSION - 1) { // Обработка ответного хода если человек походил слева или справа поля
            if (putBlockStep(humanXY, -1, 0)) {
                return;
            }
            if (putBlockStep(humanXY,1,0)) {
                return;
            }
            randomComputerTurn();
            return;
        }
        for (int stepX = -1; stepX <= 1; stepX++) {
            for (int stepY = -1; stepY <= 1; stepY++) {
                if (stepX == 0 && stepY == 0) {
                    continue;
                }
                if (putBlockStep(humanXY, stepX, stepY)) {
                    return;
                }
            }
        }
        randomComputerTurn();
    }

    // Метод для проведения блокирующего хода компьютера. Возвращает true если ход проведен.
    private static boolean putBlockStep(int[] humanXY, int x, int y) {
        if (gameField[humanXY[0] + x][humanXY[1] + y] == DOT_X
                && gameField[humanXY[0] - x][humanXY[1] - y] == DOT_EMPTY) {
            gameField[humanXY[0] - x][humanXY[1] - y] = DOT_0;
            return true;
        }
        return false;
    }


    private static void randomComputerTurn() {
        Random rnd = new Random();
        int stepX, stepY;
        do {
            stepX = rnd.nextInt(DIMENSION);
            stepY = rnd.nextInt(DIMENSION);
        } while (gameField[stepX][stepY] != DOT_EMPTY);
        gameField[stepX][stepY] = DOT_0;
//        System.out.printf("Ход компьютера %d-%d\n", stepX, stepY);;
    }

    private static int[] humanTurn() {
        Scanner scanner = new Scanner(System.in);
        int stepX, stepY;
        do {
            System.out.print("Ваш ход. Введите координаты в виде \"X Y\"");
            stepX = scanner.nextInt();
            stepY = scanner.nextInt();
            if (stepX > 0 && stepX <= DIMENSION &&
                    stepY > 0 && stepY <= DIMENSION &&
                    gameField[--stepX][--stepY] == DOT_EMPTY) {
                gameField[stepX][stepY] = DOT_X;
                break;
            }
            System.out.println("Неправильный ход. Повторите ввод координат хода");
            printGameField();
        } while (true);
        return new int[]{stepX, stepY};
    }

/*
 *    Метод проверки победы одного из игроков. Передаются два парамера:
 *    Строка поздравления проверяемого игрока.
 *    Игровой символ проверяемого игрока.
 *    Проверка реализуется в 3 прохода: Горизонтальные цепочки, вертикальные цепочки, диагональные цепочки.
 */
    private static boolean isWin(String winMessage, char winChar) {
        String winChain = String.valueOf(winChar).repeat(WIN_COUNT);
        StringBuilder checkedString;
        //Проверка горизонтальных цепочек
        for (char[] row : gameField) {
            checkedString = new StringBuilder(String.valueOf(row));
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
        }
        // Проверка вертикальных победных строк
        for (int i = 0; i < DIMENSION; i++) {
            checkedString = new StringBuilder();
            for (int j = 0; j < DIMENSION; j++) {
                checkedString.append(gameField[j][i]);
            }
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
        }
        // Проверка диагональных цепочек
        for (int beginIndex = 0; beginIndex < DIMENSION - WIN_COUNT + 1; beginIndex++) {
            checkedString = new StringBuilder(getDiagonalString(0, beginIndex, 1));
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
            checkedString = new StringBuilder(getDiagonalString(0, DIMENSION - beginIndex - 1, -1));
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
            checkedString = new StringBuilder(getDiagonalString(beginIndex, 0, 1));
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
            checkedString = new StringBuilder(getDiagonalString(beginIndex, DIMENSION - 1, -1));
            if (checkedString.toString().contains(winChain)) {
                System.out.println(winMessage);
                return true;
            }
        }
        return false;
    }

    private static StringBuilder getDiagonalString(int indexX, int indexY, int direction) {
        StringBuilder result = new StringBuilder();
        do {
            result.append(gameField[indexX][indexY]);
            indexX++;
            indexY += direction;
        } while (indexX < DIMENSION && indexY < DIMENSION && indexY > 0);
        return result;
    }


    private static void printGameField() {
        System.out.print("   ");
        for (int i = 1; i <= DIMENSION; i++) {
            System.out.printf(" %d", i);
            if (i/10 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("   " + "---".repeat(DIMENSION));
        int indexRow = 1;
        for (char[] row : gameField) {
            if (indexRow/10 == 0) {
                System.out.print(" ");
            }
            System.out.print(indexRow);
            System.out.print("|");
            for (char item : row) {
                System.out.printf(" %s ", item);
            }
            System.out.println("|" + indexRow++);
        }
        System.out.println("   " + "---".repeat(DIMENSION));
        System.out.print("   ");
        for (int i = 1; i <= DIMENSION; i++) {
            System.out.printf(" %d", i);
            if (i/10 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static boolean confirm(String message) {
        int answer;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(message + "(0-да / 1-нет)");
            answer = scanner.nextInt();
        } while (answer != 1 && answer != 0);
        return answer == 1;
    }

    private static void rules() {
        System.out.println("Правила игры:\n" +
                "В игру играет человек с компьютером. " +
                "В начале игры поле полностью пустое. \nИгроки ходят поочередно. " +
                "Человек играет крестиками, компьютер - ноликами.\n"+
                "Выигрывает тот, кто построит линию из " + TicTacGame.WIN_COUNT + " своих фишек");
    }

    private static char[][] getBeginGameField() {
        char[][] result = new char[TicTacGame.DIMENSION][TicTacGame.DIMENSION];
        for (int i = 0; i < TicTacGame.DIMENSION; i++) {
            result[i] = String.valueOf(DOT_EMPTY).repeat(TicTacGame.DIMENSION).toCharArray();
        }
        return result;
    }
}
