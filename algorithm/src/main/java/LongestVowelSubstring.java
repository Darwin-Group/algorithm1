/**
 * 定义：当一个字符串只有元音字母（aeiouAEIOU）组成，称为元音字符串。
 * 现给定一个字符串，请找出其中最长的元音字符子串，并返回其长度；如果找不到，则返回0。
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 输入描述:
 * 一个字符串，其长度范围：0 < length <= 65535。
 * 字符串仅由字符 a-z 和 A-Z 组成。
 * 输出描述:
 * 一个整数，表示最长的元音字符子串的长度。
 * 示例 1
 * 输入
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明
 * 样例 1 解释：最长元音子串为 “uio” 或 “auu”，其长度都为 3，因此输出 3
 * */
public class LongestVowelSubstring {
    public static int longestVowelSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        String vowels = "aeiouAEIOU"; // 包含所有元音字符的字符串

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                // 当前字符是元音，增加当前长度计数
                currentLength++;
                // 更新最长元音子串长度
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // 当前字符不是元音，重置当前长度
                currentLength = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "asdbuiodevauufgh";
        System.out.println(longestVowelSubstring(input)); // 输出应为3
    }
}
