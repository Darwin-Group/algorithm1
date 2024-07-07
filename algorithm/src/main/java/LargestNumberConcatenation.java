import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 小组中每位都有一张卡片，卡片上是 6 位内的正整数，将卡片连起来可以组成多种数字，
 * 计算组成的最大数字。
 * 输入描述:
 * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多 25 个人
 * 输出描述:
 * 最大的数字字符串
 * 示例 1
 * 输入
 * 22,221
 * 输出
 * 22221
 * 示例 2
 * 输入
 * 4589,101,41425,9999
 * 输出
 * 9999458941425101
 * */
public class LargestNumberConcatenation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(",");
        Arrays.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 比较两种组合哪种更大
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // 降序排序
            }
        });

        // 将排序后的字符串拼接起来
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        // 输出最大组合的数字字符串
        System.out.println(result.toString());
    }
}
