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
        task5();
        task6();
        task7();
        task8();
        task9();
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

    /** Задача 5*
     * Создайте матрицу 3х3 (двумерный массив типа int).
     *      Заполните единицами обе диагонали матрицы и напечатайте ее в консоль.
     *      Постарайтесь заполнить обе диагонали в одном цикле.
     *
     * Для печати следует использовать следующий код:
     *      for (int[] row : matrix) {
     * 	        for (int column : row) {
     * 		        System.out.print(column + " ");
     *          }
     * 	        System.out.println();
     *      }
     */
    public static void task5() {
        System.out.println("Task 5*");
        int arraySize = 3;
        int[][] matrix = new int[arraySize][arraySize];
        int j;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            j = matrix.length - i - 1;
            matrix[i][j] = 1;
        }
        for (int[] row : matrix) {
            for(int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Задание 6*
     * У нас есть массив, в котором содержатся целочисленные значения от 1 до 5.
     * Наш коллега что-то напутал, в итоге массив читается не с начала, а с конца.
     * Нам нужно исправить ошибку и переработать код так, чтобы массив читался в правильном порядке.
     * Нам дан массив чисел: {5, 4, 3, 2, 1}
     * Необходимо привести его к виду: {1, 2, 3, 4, 5}
     * Решите задачу с использованием дополнительного массива.
     * Напечатайте массив до преобразования и после с помощью
     *      System.out.println(Arrays.toString(arr));
     */
    public static void task6() {
        System.out.println("Task 6*");
        int[] wrongArray = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(wrongArray));
        int[] correctArray = new int[wrongArray.length];
        for (int i = 0; i < wrongArray.length; i++) {
            correctArray[i] = wrongArray[wrongArray.length - 1 - i];
        }
        System.out.println(Arrays.toString(correctArray));
        System.out.println();
    }

    /** Task 7*
     * Решите предыдущее задание, но без использования дополнительного массива.
     * Необходимо добиться того, чтобы исходный массив полностью соответствовал второму массиву из прошлого задания.
     * Выведите результат программы в консоль тем же способом.
     * Уточнения:
     * Это задание не на сортировку.
     * Не использовать Arrays.sort() и другие способы сортировок.
     * Числа в порядке убывания даны исключительно для указания направления чтения.
     * Массив может быть 5 8 2 3 9, нужно из него сделать 9 3 2 8 5.
     */
    public static void task7() {
        System.out.println("Task 7*");
        int[] wrongArray = {5, 4, 3, 2, 1};
        //int[] wrongArray = {5, 8, 2, 3, 9};
        int temp;
        System.out.println(Arrays.toString(wrongArray));
        for (int i = 0; i < wrongArray.length / 2; i++) {
            temp = wrongArray[i];
            wrongArray[i] = wrongArray[wrongArray.length - 1 - i];
            wrongArray[wrongArray.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(wrongArray));
        System.out.println();
    }

    /** Задание 8*
     * Задача, которая используется/бывает/встречается на собеседованиях.
     * Дан массив чисел {−6, 2, 5, −8, 8, 10, 4, −7, 12, 1}
     * Необходимо найти два числа, сумма которых равна −2.
     * Напечатать эти числа в консоль.
     */
    public static void task8() {
        System.out.println("Task 8*");
        int[] array = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        System.out.println(Arrays.toString(array));

        int requiredAmount = -2;
        int summCurrentNumbers;
        boolean isStop = false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                summCurrentNumbers = array[i] + array[j];
                if (summCurrentNumbers == requiredAmount) {
                    System.out.println("Сумма чисел " + array[i] + " и " + array[j] + " дают в сумме -2");
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }

        System.out.println();
    }

    /** Задание 9*
     * Усложняем предыдущую задачу.
     * Найдите все пары чисел, сумма которых равна −2.
     * Напечатайте их в консоль.
     */
    public static void task9() {
        System.out.println("Task 9*");
        int[] array = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        int requiredAmount = -2;
        Arrays.sort(array);
        int summCurrentNumbers = 0;
        for (int i = 0; array[i] < 0; i++) {
            for (int j = i + 1; j < array.length; j++) {
                summCurrentNumbers = array[i] + array[j];
                if (summCurrentNumbers == requiredAmount) {
                    System.out.println("Сумма чисел " + array[i] + " и " + array[j] + " дают в сумме -2");
                }
            }
        }

        System.out.println();
    }
}
