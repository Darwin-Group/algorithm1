import java.util.*;

/**
 * 给定两个整数数组 array1、array2，数组元素按升序排列。假设从 array1、array2 中分别
 * 取出一个元素可构成一对元素，现在需要取出 k 对元素，并对取出的所有元素求和，计算和
 * 的最小值
 * 注意：两对元素如果对应于 array1、array2 中的两个下标均相同，则视为同一对元素。
 * 输入描述:
 * 输入两行数组 array1、array2，每行首个数字为数组大小 size(0 < size <= 100);
 * 0 < array1[i] <= 1000
 * 0 < array2[i] <= 1000
 * 接下来一行为正整数 k
 * 0 < k <= array1.size() * array2.size()
 * 输出描述:
 * 满足要求的最小和
 * 示例 1
 * 输入
 * 3 1 1 2
 * 3 1 2 3
 * 2
 * 输出
 * 4
 * 说明
 * 用例中，需要取 2 对元素
 * 取第一个数组第 0 个元素与第二个数组第 0 个元素组成 1 对元素[1,1];
 * 取第一个数组第 1 个元素与第二个数组第 0 个元素组成 1 对元素[1,1];
 * 求和为 1+1+1+1=4，为满足要求的最小和
 */
public class PriorityQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组1
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        // 读取数组2
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        // 读取 k
        int k = scanner.nextInt();

        // 使用最小堆来实现贪心策略
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (array1[a[0]] + array2[a[1]])));

        // 初始将所有 array1[0] 与 array2[0], array1[0] 与 array2[1], ..., array1[0] 与 array2[size2-1] 加入最小堆
        for (int j = 0; j < size2; j++) {
            minHeap.offer(new int[]{0, j});
        }

        int sum = 0;

        // 取出 k 对元素
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            int[] pair = minHeap.poll();
            sum += array1[pair[0]] + array2[pair[1]];

            // 如果 array1 还有下一个元素，将其与当前 array2[pair[1]] 组合加入堆中
            if (pair[0] < size1 - 1) {
                minHeap.offer(new int[]{pair[0] + 1, pair[1]});
            }
        }

        // 输出最小和
        System.out.println(sum);
    }
}
