import java.util.*;

/**
 * 输入一个由 n 个大小写字母组成的字符串，按照 Ascii 码值从小到大的排序规则，查找字符
 * 串中第 k 个最小 ascii 码值的字母（k>=1），输出该字母所在字符串的位置索引(字符串的第
 * 一个字符位置索引为 0）。
 * k 如果大于字符串长度，则输出最大 ascii 值的字母所在字符串的位置索引，如果有重复的
 * 字母，则输出字母的最小位置索引。
 * 输入描述:
 * 第一行输入一个由大小写字母组成的字符串
 * 第二行输入 k，k 必须大于 0，k 可以大于输入字符串的长度
 * 输出描述:
 * 输出字符串中第 k 个最小 ascii 码值的字母所在字符串的位置索引。k 如果大于字符串长度，
 * 则输出最大 ascii 值的字母所在字符串的位置索引，如果第 k 个最小 ascii 码值的字母存在重
 * 复，则输出该字母的最小位置索引。
 * 示例 1
 * 输入
 * AbCdeFG
 * 3
 * 输出
 * 5
 * 说明
 * 根据 ascii 码值排序，第 3 个最小 ascii 码值的字母为 F，F 在字符串中的位置索引为 5（0
 * 为字符串的第一个字母位置索引）
 * 示例 2
 * 输入
 * fAdDAkBbBq
 * 4
 * 输出
 * 6
 * 说明
 * 根据 ascii 码值排序，前 4 个字母为 AABB ，由于 B 重复，则只取 B 的（第一个）最小位
 * 置索引 6 ，而不是第二个 B 的位置索引 8
 */
public class AsciiSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();

        List<Pair> characters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            characters.add(new Pair(input.charAt(i), i));
        }

        // 按字符排序
        Collections.sort(characters, (a, b) -> a.character - b.character);

        // 如果k大于字符数，找到最大Ascii码值的最小索引
        if (k > input.length()) {
            char maxChar = characters.get(input.length() - 1).character;
            int minIndex = Integer.MAX_VALUE;
            for (Pair pair : characters) {
                if (pair.character == maxChar && pair.index < minIndex) {
                    minIndex = pair.index;
                }
            }
            System.out.println(minIndex);
        } else {
            // 找到第k小的字符的最小索引
            char targetChar = characters.get(k - 1).character;
            int minIndex = Integer.MAX_VALUE;
            for (Pair pair : characters) {
                if (pair.character == targetChar && pair.index < minIndex) {
                    minIndex = pair.index;
                }
            }
            System.out.println(minIndex);
        }
    }

    static class Pair {
        char character;
        int index;

        Pair(char character, int index) {
            this.character = character;
            this.index = index;
        }
    }
}
