/**
 * 有 N 个正整数组成的一个序列。给定整数 sum，求长度最长的连续子序列，使他们的和等于 sum，返回此子序列的长度，如果没有满足要求的序列，返回-1。
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 示例 1
 * 输入
 * 1,2,3,4,2
 * 6
 * 输出
 * 3
 * 说明
 * 解释：1,2,3 和 4,2 两个序列均能满足要求，所以最长的连续序列为 1,2,3，因此结果为 3
 * 示例 2
 * 输入
 * 1,2,3,4,2
 * 20
 * 输出
 * -1
 * 说明
 * 解释：没有满足要求的子序列，返回-1
 * 备注:
 * 输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔；
 * 序列长度：1 <= N <= 200；
 * 输入序列不考虑异常情况，由题目保证输入序列满足要求。
 * */
public class Solution {
    public static int findMaxLengthSubarrayWithSum(int[] arr, int sum) {
        int maxLength = -1;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];  // 将当前元素加到当前和中

            // 当当前和超过目标和时，尝试移动 start 指针缩小窗口
            while (currentSum > sum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // 检查当前和是否等于目标和，并更新最大长度
            if (currentSum == sum) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2};
        int sum = 6;
        int result = findMaxLengthSubarrayWithSum(arr, sum);
        System.out.println(result);  // 应输出 3
    }
}
