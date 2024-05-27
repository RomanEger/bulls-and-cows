package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //дописать
    private static String getRules(boolean isBot){
        if(isBot){
            return "\n" +
                    "--------------------\n" +
                    "Правила игры:\n" +
                    "\n" +
                    "Компьютер задумывает четыре различные цифры из 0,1,2,...9. Игрок делает ходы, чтобы узнать эти цифры и их порядок.\n" +
                    "Каждый ход состоит из четырёх цифр, 0 может стоять на первом месте.\n" +
                    "В ответ компьютер показывает число отгаданных цифр, стоящих на своих местах (число быков) и число отгаданных цифр, стоящих не на своих местах (число коров).\n" +
                    "Пример:\n" +
                    "Компьютер задумал 0834.\n" +
                    "Игрок сделал ход 8134.\n" +
                    "Компьютер ответил: 2 быка (цифры 3 и 4) и 1 корова (цифра 8).\n" +
                    "(Угаданные цифры остаются неизвестными)\n" +
                    "--------------------\n";
        }
        else {
            return  "\n" +
                    "--------------------\n" +
                    "Правила игры:\n" +
                    "\n" +
                    //дописать
                    "Пример:\n" +
                    "Игрок 1 задумал 0834.\n" +
                    "Игрок 2 сделал ход 8134.\n" +
                    "Игрок 2 получил ответ: 2 быка (цифры 3 и 4) и 1 корова (цифра 8).\n" +
                    "(Угаданные цифры остаются неизвестными)\n" +
                    "--------------------\n";
        }
    }

    public static void main(String[] args) {
        while(true) {
            boolean isUnique;
            int length;
            int choice;

            System.out.println("Добро пожаловать в игру быки и коровы!\n" +
                    "Выберите формат игры:\n" +
                    "1 Против бота\n" +
                    "2 Против игрока");

            while (true) {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice != 1 && choice != 2) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception ex) {
                    System.out.println("Ответ должен быть 1 или 2!\n" +
                            "Попробуйте ещё раз.");
                }
            }

            System.out.println(getRules(choice == 1));

            System.out.println("Уникальны ли цифры?\n" +
                    "1 Да\n" +
                    "Любая клавиша Нет");

            while (true) {
                try {
                    isUnique = new Scanner(System.in).nextInt() == 1;
                    break;
                } catch (Exception ex) {
                    System.out.println("Ответ должен быть 1 или 2!\n" +
                            "Попробуйте ещё раз.");
                }
            }

            if (choice == 1) {
                Bulls bulls;
                while (true) {
                    try {
                        System.out.print("Задайте размер загаданного числа:\t");

                        length = new Scanner(System.in).nextInt();

                        bulls = new Bulls(length, isUnique);

                        break;
                    } catch (Exception ex) {
                        System.out.println("Размер должен быть представлен целым числом!\n" +
                                "Попробуйте ещё раз.");
                    }
                }

                int[] arrBulls = bulls.getBulls();

                boolean isWin = false;
                while (!isWin) {
                    int[] attempt = writeResult(arrBulls.length);
                    int countBulls = 0, countCows = 0;
                    for (int i = 0; i < arrBulls.length; i++) {
                        if (attempt[i] == arrBulls[i]) {
                            countBulls++;
                        } else {
                            for (int j = 0; j < arrBulls.length; j++) {
                                if (attempt[i] == arrBulls[j] && i != j) {
                                    countCows++;
                                }
                            }
                        }
                    }

                    System.out.printf("Кол-во быков: %d\tКол-во коров: %d\n", countBulls, countCows);

                    if (countBulls == arrBulls.length)
                        isWin = true;
                }
            }
            else {
                Bulls bulls;
                while (true) {
                    try {
                        System.out.print("Задайте размер загаданного числа:\t");

                        length = new Scanner(System.in).nextInt();

                        bulls = new Bulls(length, isUnique);

                        break;
                    } catch (Exception ex) {
                        System.out.println("Размер должен быть представлен целым числом!\n" +
                                "Попробуйте ещё раз.");
                    }
                }

                int[] arrBulls = bulls.getBulls();

                boolean isWin = false;
                while (!isWin) {
                    int[] attempt = writeResult(arrBulls.length);
                    int countBulls = 0, countCows = 0;
                    for (int i = 0; i < arrBulls.length; i++) {
                        if (attempt[i] == arrBulls[i]) {
                            countBulls++;
                        } else {
                            for (int j = 0; j < arrBulls.length; j++) {
                                if (attempt[i] == arrBulls[j] && i != j) {
                                    countCows++;
                                }
                            }
                        }
                    }

                    System.out.printf("Кол-во быков: %d\tКол-во коров: %d\n", countBulls, countCows);

                    if (countBulls == arrBulls.length)
                        isWin = true;
                }

                System.out.println("Хотите начать игру заново?\n" +
                        "1 Да\n" +
                        "2 Нет");

                int next;

                try {
                    next = new Scanner(System.in).nextInt();
                } catch (Exception ex) {
                    System.out.println("До свидания!");
                    next = 2;
                }

                if (next != 1) {
                    break;
                } else {
                    try {
                        final String os = System.getProperty("os.name");

                        if (os.contains("Windows")) {
                            Runtime.getRuntime().exec("cls");
                        } else {
                            Runtime.getRuntime().exec("clear");
                        }
                    } catch (final Exception e) {
                        System.out.println("Ошибка при очистке консоли");
                    }
                }
            }
        }
    }

    private static int[] writeResult(int length){
        int[] attempt = new int[length];
        System.out.println("Введите Ваш ответ");
        try {
            for (int i = 0; i < attempt.length; ) {
                attempt[i++] = new Scanner(System.in).nextInt();
            }
        } catch (Exception e) {
            System.out.println("Необходимо вводить целое число!\n" +
                    "Попробуйте ещё раз");
        }
        return attempt;
    }


}