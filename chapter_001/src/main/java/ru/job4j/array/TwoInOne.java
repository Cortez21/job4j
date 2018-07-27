package ru.job4j.array;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TwoInOne {
    /**
     * Получает два отсортированных массива после чего копирует их в третий массив
     * в порядке возрастания.
     * @param arrayA массив А.
     * @param arrayB массив В
     * @return - отсортированный массив С полученный входе слияния двух первых.
     */
    public int[] oneFromTwo(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < arrayC.length; i++) {

            if (posA <= arrayA.length - 1 && arrayA[posA] <= arrayB[posB]) {
                arrayC[i] = arrayA[posA];
                posA++;
            } else if (posA > arrayA.length - 1 && posB <= arrayB.length - 1) {
                arrayC[i] = arrayB[posB];
                posB++;
            } else if (posB <= arrayB.length - 1 && arrayB[posB] <= arrayA[posA]) {
                arrayC[i] = arrayB[posB];
                posB++;
            } else if (posB > arrayB.length - 1 && posA <= arrayA.length - 1) {
                arrayC[i] = arrayA[posA];
                posA++;
            } else {
                break;
            }
        }
        return arrayC;
    }
}
