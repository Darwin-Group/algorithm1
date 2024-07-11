import java.util.*;

/**
 * 在学校中，N 个小朋友站成一队， 第 i 个小朋友的身高为 height[i]，
 * 第 i 个小朋友可以看到的第一个比自己身高更高的小朋友 j，那么 j 是 i 的好朋友(要求 j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，
 * 请在该位置用 0 代替。
 * 小朋友人数范围是 [0, 40000]。
 * 输入描述:
 * 第一行输入 N，N 表示有 N 个小朋友
 * 第二行输入 N 个小朋友的身高 height[i]，都是整数
 * 输出描述:
 * 输出 N 个小朋友的好朋友的位置
 * 示例 1
 * 输入
 * 2
 * 100 95
 * 输出
 * 0 0
 * 说明
 * 第一个小朋友身高 100，站在队尾位置，向队首看，没有比他身高高的小朋友，所以输出第
 * 一个值为 0。
 * 第二个小朋友站在队首，前面也没有比他身高高的小朋友，所以输出第二个值为 0。
 * 示例 2
 * 输入
 * 8
 * 123 124 125 121 119 122 126 123
 * 输出
 * 1 2 6 5 5 6 0 0
 * 说明
 * 123 的好朋友是 1 位置上的 124
 * 124 的好朋友是 2 位置上的 125
 * 125 的好朋友是 6 位置上的 126
 * 以此类推
 */
public class Companion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] height = new int[N];

        for (int i = 0; i < N; i++) {
            height[i] = scanner.nextInt();
        }

        int[] friends = new int[N];
        Arrays.fill(friends, 0); // 初始化为0

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                friends[i] = stack.peek() + 1; // 记录好朋友的位置（索引+1）
            }
            stack.push(i); // 当前小朋友入栈
        }

        // 栈中剩余的元素没有比自己更高的朋友，设置为0
        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(friends[i] + " ");
        }
        System.out.println();
    }
}
