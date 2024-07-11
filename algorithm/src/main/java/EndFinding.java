import java.util.*;

/**
 * 给定一个正整数数组，设为 nums，最大为 100 个成员，求从第一个成员开始，正好走到数
 * 组最后一个成员，所使用的最少步骤数。
 * 要求：
 * 1、第一步必须从第一元素开始，且 1<=第一步的步长<len/2;（len 为数组的长度，需要自
 * 行解析）。
 * 2、从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少, 如果目标不可
 * 达返回-1，只输出最少的步骤数量。
 * 3、只能向数组的尾部走，不能往回走。
 * 输入描述:
 * 由正整数组成的数组，以空格分隔，数组长度小于 100，请自行解析数据数量。
 * 输出描述:
 * 正整数，表示最少的步数，如果不存在输出-1
 * 示例 1
 * 输入
 * 7 5 9 4 2 6 8 3 5 4 3 9
 * 输出
 * 2
 * 说明
 * 第一步： 第一个可选步长选择 2，从第一个成员 7 开始走 2 步，到达 9；第二步： 从 9 开
 * 始，经过自身数字 9 对应的 9 个成员到最后。
 * 示例 2
 * 输入
 * 1 2 3 7 1 5 9 3 2 1
 * 输出
 * -1
 */
public class EndFinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] numsStr = input.split("\\s+");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int len = nums.length;

        // dp[i] 表示从第一个元素走到第 i 个元素所需的最少步数，初始化为最大值
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 第一个元素到达自身的步数为 0

        // 开始动态规划求解
        for (int i = 0; i < len; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue; // 如果当前位置不可达，跳过
            }

            int maxStep = nums[i]; // 当前位置能走的最大步数

            // 根据题意，第一步步长范围为 [1, len/2)
            if (i == 0) {
                maxStep = Math.min(maxStep, len / 2 - 1);
            }

            // 遍历所有可能的下一步
            for (int step = 1; step <= maxStep; step++) {
                if (i + step < len) {
                    dp[i + step] = Math.min(dp[i + step], dp[i] + 1);
                }
            }
        }

        // 如果最后一个位置可达，则输出最少步数，否则输出 -1
        int minSteps = dp[len - 1];
        if (minSteps == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minSteps);
        }
    }
}