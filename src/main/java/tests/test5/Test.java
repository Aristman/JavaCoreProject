/*
 *
 * Домашнее задание по занятию №5. Введение в ООП
 * Выполнил студент Аристов Сергей Константинович
 *
 */

package tests.test5;

public class Test {
    private static Worker[] workers;

    public static void main(String[] args) {
        createWorkers();
        printWorkers();

    }

    private static void printWorkers() {
        for (Worker worker : workers) {
            if (worker.getAge() > 40) {
                worker.printInfo();
                System.out.println("---------------------------------------");
            }
        }
    }

    private static void createWorkers() {
        workers = new Worker[5];
        workers[0] = new Worker("Иванов Виктор Петрович",
                "Генеральный директор",
                "ivanov@mail.com",
                "253545",
                150000,
                46);
        workers[1] = new Worker("Сидоров Петр Викторович",
                "Начальник ОМТС",
                "sidorov@mail.com",
                "+749529898333",
                60000,
                51);
        workers[2] = new Worker("Протасевич Игорь Владимирович",
                "Менеджер",
                "protas@mail.com",
                "3377773828",
                50000,
                25);
        workers[3] = new Worker("Филонова Мария Сергеевна",
                "Бухгалтер",
                "filonova@mail.com",
                "892788489384",
                55000,
                32);
        workers[4] = new Worker("Миронов Олег Фомич",
                "Грузчик",
                "miron@mail.com",
                "994777363",
                25000,
                27);
    }
}
