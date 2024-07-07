import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，
 * 所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金，现在请你设计一个程序
 * 帮助小明计算尽可能花费的最大资金数额。
 * 输入描述:
 * 输入第一行为一维整型数组 M，数组长度小于 100，数组元素记录单个商品的价格，单个商
 * 品价格小于 1000。
 * 输入第二行为购买资金的额度 R，R 小于 100000。
 * 输出描述:
 * 输出为满足上述条件的最大花费额度。
 * 注意：如果不存在满足上述条件的商品，请返回-1。
 * 示例 1
 * 输入
 * 23,26,36,27
 * 78
 * 输出
 * 76
 * 说明
 * 金额 23、26 和 27 相加得到 76，而且最接近且小于输入金额 78
 * 示例 2
 * 输入
 * 23,30,40
 * 26
 * 输出
 * -1
 * 说明
 * 因为输入的商品，无法组合出来满足三件之和小于 26.故返回-1
 * 备注:
 * 输入格式是正确的，无需考虑格式错误的情况
 * */
public class BacktrackingAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int R = scanner.nextInt();
        scanner.close();

        String[] parts = line1.split(",");
        int[] prices = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            prices[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(maximizeSpending(prices, R));
    }

    private static int maximizeSpending(int[] prices, int budget) {
        int n = prices.length;
        int closestSum = -1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = prices[i] + prices[j] + prices[k];
                    if (sum <= budget && sum > closestSum) {
                        closestSum = sum;
                    }
                }
            }
        }

        return closestSum;
    }
}
