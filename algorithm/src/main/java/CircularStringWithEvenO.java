/**
 * 给你一个字符串 s，字符串 s 首尾相连成一个环形 ，请你在环中找出 'o' 字符出现了偶数次最长子字符串的长度。
 * 输入描述:
 * 输入是一串小写字母组成的字符串
 * 输出描述:
 * 输出是一个整数
 * 示例 1
 * 输入
 * alolobo
 * 输出
 * 6
 * 说明
 * 最长子字符串之一是 "alolob"，它包含'o' 2 个。
 * 示例 2
 * 输入
 * looxdolx
 * 输出
 * 7
 * 说明
 * 最长子字符串是 "oxdolxl"，由于是首尾连接在一起的，所以最后一个 'x' 和开头的 'l'是连接在一起的，此字符串包含 2 个'o' 。
 * 示例 3
 * 输入
 * bcbcbc
 * 输出
 * 6
 * 说明
 * 这个示例中，字符串 "bcbcbc" 本身就是最长的，因为 'o' 都出现了 0 次。
 * 备注:
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * */
public class CircularStringWithEvenO {
    public static int findLongestEvenO(String s) {
        int n = s.length();
        String extended = s + s; // 创建扩展字符串以模拟环形结构
        int maxLen = 0; // 最大长度

        // 用来记录'o'出现的次数是否为偶数的数组，最大长度2*n因为考虑了环形
        int[] countEven = new int[2 * n + 1]; // +1为了处理前缀和技巧
        countEven[0] = 1; // 初始化前缀和基线
        int prefix = 0;

        for (int i = 0; i < 2 * n; i++) {
            // 当字符是'o'时，调整前缀和
            if (extended.charAt(i) == 'o') {
                prefix ^= 1; // XOR操作，1的次数奇偶性切换/ 按位异或运算符(消消乐)
            }
            // 如果之前已经遇到过相同数量的'o'的偶数性（前缀和相同）
            if (countEven[prefix] > 0) {
                // i + 1 - 上一次该前缀和出现的位置，因为前缀和相同表示两处'o'数量增加情况一致
                int windowLen = i + 1 - countEven[prefix];
                // 如果窗口长度不超过原字符串长度，则可能是有效的最长子字符串
                if (windowLen <= n) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            } else {
                // 记录这个前缀和第一次出现的位置
                countEven[prefix] = i + 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLongestEvenO("alolobo")); // 6
        System.out.println(findLongestEvenO("looxdolx")); // 7
        System.out.println(findLongestEvenO("bcbcbc"));   // 6
    }
}