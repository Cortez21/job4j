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
            if (arrayA[posA] <= arrayB[posB]) {
                arrayC[i] = arrayA[posA];
                if (posA < arrayA.length - 1) {
                    posA++;
                } else {
                    arrayC[arrayC.length - 1] = arrayB[arrayB.length - 1];
                }
            } else {
                arrayC[i] = arrayB[posB];
                if (posB < arrayB.length - 1) {
                    posB++;
                } else {
                    arrayC[arrayC.length - 1] = arrayA[arrayA.length - 1];
                }
            }
        }
        return arrayC;
    }
}
