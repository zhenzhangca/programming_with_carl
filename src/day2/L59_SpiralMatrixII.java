package day2;

/**
 * Leetcode 59 螺旋矩阵II
 * 给一个正整数n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * e.g. n = 3   =>   n^2 = 9 (n%2 = 1 奇数，顺时针转1圈（n/2），中间的9做post-processing）
 * output = [
 * [1, 2, 3],
 * [8, 9, 4],
 * [7, 6, 5]
 * ]
 * n = 5    => n^2 = 25（n%2 = 1，奇数，顺时针转n/2=2圈，中间的25做post-processing）
 * output = [
 * [1, 2, 3, 4, 5],
 * [16,17,18,19,6],
 * [15,24,25,20,7],
 * [14,23,22,21,8],
 * [13,12,11,10,9]
 * ]
 * n = 4    => n^2 = 15(n%2 = 0，偶数，顺时针转n/2 = 2圈）
 * output = [
 * [1, 2, 3, 4],
 * [12,13,14,5],
 * [11,16,15,6],
 * [10,9, 8, 7]
 * ]
 * 方法：recursion
 *
 */
public class L59_SpiralMatrixII {
    public static void main(String[] args) {


    }

    private static int[][] spiralMatrix(int n) {
        int[][] result = new int[n][n];
        //result 是空的2D matrix
        // offset是指当前层recursion左上角的位置在哪，初始是0， 每往里走一圈，offset + 1 a[0][0], a[1][1]
        //size是边长，初始值是n，每往里走一圈，size - 2
        //counter是计数器，初始值是1， 直到n
        helper(result, 0, n, 1);
        return result;
    }

    private static void helper(int[][] a, int offset, int size, int counter) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            a[offset][offset] = counter;
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            a[0 + offset][i + offset] = counter;
            counter++;
        }
        for (int i = 0; i < size - 1; i++) {
            a[i + offset][size - 1 + offset] = counter;
            counter++;
        }
        for (int i = size - 1; i >= 1; i--) {
            a[size - 1 + offset][i + offset] = counter;
            counter++;
        }
        for (int i = size - 1; i >= 1; i--) {
            a[i + offset][0 + offset] = counter;
            counter++;
        }
        helper(a, offset + 1, size - 2, counter);
    }
}
