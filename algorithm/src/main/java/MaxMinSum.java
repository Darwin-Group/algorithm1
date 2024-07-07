import java.util.*;

/**
 * 给定一个数组，编写一个函数来计算它的最大 N 个数与最小 N 个数的和。你需要对数组进
 * 行去重。
 * 说明：
 * *数组中数字范围[0, 1000]
 * 最大 N 个数与最小 N 个数不能有重叠，如有重叠，输入非法返回-1
 * 输入描述:
 * 第一行输入 M， M 标识数组大小
 * 第二行输入 M 个数，标识数组内容
 * 第三行输入 N，N 表达需要计算的最大、最小 N 个数
 * 输出描述:
 * 输出最大 N 个数与最小 N 个数的和。
 * 示例 1
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明
 * 最大 2 个数[100,95],最小 2 个数[83,64], 输出为 342
 * 示例 2
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明
 * 最大 2 个数[4,3],最小 2 个数[3,2], 有重叠输出为-1
 * */
public class MaxMinSum {
    public static int calculateMaxMinSum(int[] arr, int N) {
        if (arr == null || arr.length < 2 * N) return -1;

        // 使用HashSet去重
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }

        // 检查去重后的元素是否足够
        if (uniqueElements.size() < 2 * N) return -1;

        // 转换为列表并排序
        List<Integer> sortedElements = new ArrayList<>(uniqueElements);
        Collections.sort(sortedElements);

        // 获取最大和最小N个数
        List<Integer> minN = sortedElements.subList(0, N);
        List<Integer> maxN = sortedElements.subList(sortedElements.size() - N, sortedElements.size());

        // 计算和
        int sum = 0;
        for (int num : minN) sum += num;
        for (int num : maxN) sum += num;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();  // 读取数组大小
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = scanner.nextInt();  // 读取数组元素
        }
        int N = scanner.nextInt();  // 读取N

        int result = calculateMaxMinSum(arr, N);
        System.out.println(result);
    }
}
