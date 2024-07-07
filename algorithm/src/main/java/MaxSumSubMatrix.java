/**
 * 给定一个二维整数矩阵，要在这个矩阵中选出一个子矩阵，使得这个子矩阵内所有的数字和尽量大，我们把这个子矩阵称为和最大子矩阵
 * 子矩阵的选取原则是原矩阵中一块相互连续的矩形区域。
 * 输入描述:
 * 输入的第一行包含 2 个整数 n, m(1 <= n, m <= 10)，表示一个 n 行 m 列的矩阵，下面有 n
 * 行，每行有 m 个整数，同一行中，每 2 个数字之间有 1 个空格，最后一个数字后面没有空
 * 格，所有的数字的在[-1000, 1000]之间。
 * 输出描述:
 * 输出一行一个数字，表示选出的和最大子矩阵内所有的数字和。
 * 示例 1
 * 输入
 * 3 4
 * -3 5 -1 5
 * 2 4 -2 4
 * -1 3 -1 3
 * 输出
 * 20
 * 说明
 * 一个 3*4 的矩阵中，后面 3 列的子矩阵求和加起来等于 20，和最大
 * */
public class MaxSumSubMatrix {
    public static int maxSumSubMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        // 外层两个循环用于确定子矩阵的上边界和下边界
        for (int top = 0; top < n; top++) {
            int[] columnSum = new int[m];
            for (int bottom = top; bottom < n; bottom++) {
                // 更新每一列的和
                for (int col = 0; col < m; col++) {
                    columnSum[col] += matrix[bottom][col];
                }

                // 寻找当前列和数组的最大子数组和
                int currentMax = findMaxSubarray(columnSum);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }

    // Kadane算法寻找一维数组的最大子数组和
    private static int findMaxSubarray(int[] array) {
        int currentSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-3, 5, -1, 5},
                {2, 4, -2, 4},
                {-1, 3, -1, 3}
        };
        System.out.println(maxSumSubMatrix(matrix)); // 应该输出 20
    }
}
