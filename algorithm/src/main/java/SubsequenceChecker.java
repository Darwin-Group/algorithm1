import java.util.Scanner;

/**
 * 输入两个字符串 S 和 L，都只包含英文小写字母。S 长度<=100，L 长度<=500,000。判定
 * S 是否是 L 的有效字串。
 * 判定规则：S 中的每个字符在 L 中都能找到（可以不连续），且 S 在Ｌ中字符的前后顺序与
 * S 中顺序要保持一致。（例如，S="ace"是 L="abcde"的一个子序列且有效字符是 a、c、e，
 * 而"aec"不是有效子序列，且有效字符只有 a、e）
 * 输入描述:
 * 输入两个字符串 S 和 L，都只包含英文小写字母。S 长度<=100，L 长度<=500,000。
 * 先输入 S，再输入 L，每个字符串占一行。
 * 输出描述:
 * S 串最后一个有效字符在 L 中的位置。（首位从 0 开始计算，无有效字符返回-1）
 * 示例 1
 * 输入
 * ace
 * abcde
 * 输出
 * 4
 * 示例 2
 * 输入
 * fgh
 * abcde
 * 输出
 * -1
 * */
public class SubsequenceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        scanner.close();

        System.out.println(findLastValidCharacterIndex(s, l));
    }

    private static int findLastValidCharacterIndex(String s, String l) {
        int indexS = 0; // Pointer for string S
        int lastValidIndex = -1; // Store last valid index from string L

        // Traverse through string L
        for (int indexL = 0; indexL < l.length(); indexL++) {
            if (indexS < s.length() && s.charAt(indexS) == l.charAt(indexL)) {
                // Move S pointer and update last valid index
                lastValidIndex = indexL;
                indexS++;
            }
        }

        // Check if all characters of S were found in L in the correct order
        if (indexS == s.length()) {
            return lastValidIndex;
        }

        // Not all characters were matched
        return -1;
    }
}
