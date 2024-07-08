import java.util.*;

/**
 * 给定一个字符串 s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序
 * 进行比较）。
 * 变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述:
 * 一串小写字母组成的字符串 s
 * 输出描述:
 * 按照要求进行变换得到的最小字符串
 * 示例 1
 * 输入
 * abcdef
 * 输出
 * abcdef
 * 说明
 * abcdef 已经是最小字符串，不需要交换
 * 示例 2
 * 输入
 * bcdefa
 * 输出
 * acdefb
 * 说明
 * a 和 b 进行位置交换，可以等到最小字符串
 */
public class SmallestStringByOneSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        // 调用方法来获取变换后的最小字符串
        String result = getSmallestStringByOneSwap(s);
        System.out.println(result);
        scanner.close();
    }

    private static String getSmallestStringByOneSwap(String s) {
        int n = s.length();
        if (n < 2) return s;  // 如果字符串长度小于2，无法交换，直接返回

        // 遍历字符串，寻找可以交换的最佳位置
        for (int i = 0; i < n - 1; i++) {
            char currentChar = s.charAt(i);
            char minChar = currentChar;
            int minIndex = -1;

            // 在当前字符右侧寻找最小的字符，以便进行交换
            for (int j = i + 1; j < n; j++) {
                char compareChar = s.charAt(j);
                // 找到更小的字符，并且应该是右侧所有更小字符中最右侧的一个
                if (compareChar < minChar && (minIndex == -1 || compareChar <= s.charAt(minIndex))) {
                    minChar = compareChar;
                    minIndex = j;
                }
            }

            // 如果找到了合适的交换位置，进行交换并返回结果
            if (minIndex != -1 && s.charAt(minIndex) < currentChar) {
                return swapChars(s, i, minIndex);
            }
        }

        // 如果整个遍历过程中没有合适的交换机会，返回原字符串
        return s;
    }

    // 交换字符串中两个指定位置的字符并返回新的字符串
    private static String swapChars(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}