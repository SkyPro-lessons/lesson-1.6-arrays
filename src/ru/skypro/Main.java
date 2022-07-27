package ru.skypro;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        int[] buhBook = generateRandomArray();
        printArray(buhBook);
        int monthlyAmount = task1(buhBook);
        task2(buhBook);
        task3(buhBook, monthlyAmount);
        task4();
    }

    private static void printArray(int[] buhBook) {
        System.out.println("-> Исходный массив:");
        int i = 1;
        for (int currValue : buhBook) {
            System.out.print(currValue + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    /** Задание 1
     * Первым делом бухгалтеры попросили посчитать сумму всех выплат за месяц.
     * Нужно написать программу, которая решит эту задачу, и вывести в консоль результат
     *      в формате: «Сумма трат за месяц составила … рублей».
     * @param buhBook массив, содержащий расходы за месяц
     */
    public static int task1(int[] buhBook) {
        System.out.println("-> Task 1");
        int monthlyAmount = 0;
        for (int currentDayValue : buhBook) {
            monthlyAmount += currentDayValue;
        }
        System.out.println("Сумма трат за месяц составила " + monthlyAmount + " рублей");
        System.out.println();

        return monthlyAmount;
    }

    /** Задание 2
     * Следующая задача — найти минимальную и максимальную трату за день.
     * Нужно написать программу, которая решит эту задачу, и вывести в консоль результат
     * в формате: «Минимальная сумма трат за день составила … рублей. Максимальная сумма трат за день составила … рублей».
     * @param buhbook массив, содержащий расходы за месяц
     */
    public static void task2(int[] buhbook) {
        System.out.println("-> Task 2");
        int minValue = buhbook[0];
        int maxValue = buhbook[0];
        for (int currValue : buhbook) {
            if (currValue > maxValue) {
                maxValue = currValue;
            }
            if (currValue < minValue) {
                minValue = currValue;
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + minValue +
                " рублей. Максимальная сумма трат за день составила " + maxValue + " рублей");
        System.out.println();
    }

    /** Задача 3
     * А теперь нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
     * Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц
     *      поделить на количество дней), и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
     * Важно помнить: подсчет среднего значения может иметь остаток (то есть быть не целым, а дробным числом).
     * @param buhbook массив, содержащий расходы за месяц
     * @param montlyAmount сумма расходов за месяц
     */
    public static void task3(int[] buhbook, int montlyAmount) {
        System.out.println("-> Task 3");
        double averagePerDay = (double) montlyAmount / buhbook.length;
        System.out.println("Средняя сумма трат за месяц составила " + averagePerDay);
        System.out.println();
    }

    /** Задача 4
     * Отойдем от подсчетов.
     * В нашей бухгалтерской книге появился баг. Что-то пошло нет так, и Ф.И.О. сотрудников начали отображаться в обратную сторону.
     *      т.е. вместо «Иванов Иван Иванович» мы имеем «чивонавИ навИ вонавИ».
     * Данные с именами сотрудников хранятся в виде массива символов (char[]).
     * Напишите код, который в случае такого бага будет выводить Ф.И.О. сотрудников в корректном виде.
     *      В качестве данных для массива используйте:
     *          char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
     *      В результате в консоль должно быть выведено "Ivanov Ivan".
     *      Важно: не используйте дополнительные массивы для решения этой задачи. Необходимо корректно пройти по массиву циклом
     *          и распечатать его элементы в правильном порядке.
     */
    public static void task4() {
        System.out.println("-> Task 4");
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i]);
        }
        System.out.println();
    }
}
