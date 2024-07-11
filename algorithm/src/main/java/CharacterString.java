import java.util.*;

/**
 * 给定两个字符串，从字符串 2 中找出字符串 1 中的所有字符，去重并按照 ASCII 值从小到
 * 大排序
 * 输入字符串 1：长度不超过 1024
 * 输入字符串 2：长度不超过 1000000
 * 字符范围满足 ASCII 编码要求，按照 ASCII 的值由小到大排序
 * 输入描述:
 * bach
 * bbaaccedfg
 * 输出描述:
 * abc
 * 示例 1
 * 输入
 * fach
 * bbaaccedfg
 * 输出
 * acf
 * 说明
 * 备注:
 * 输入字符串 1 为给定字符串 bach，输入字符串 2 bbaaccedfg
 * 从字符串 2 中找出字符串 1 的字符，去除重复的字符，并且按照 ASCII 值从小到大排序，
 * 得到输出的结果为 abc。
 * 字符串 1 中的字符 h 在字符串 2 中找不到不输出
 */
public class CharacterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // 统计字符串1中字符的出现次数
        int[] count = new int[128]; // ASCII码范围
        for (char c : str1.toCharArray()) {
            count[c]++;
        }

        // 使用集合保存符合条件的字符，并按照ASCII值排序
        TreeSet<Character> set = new TreeSet<>();
        for (char c : str2.toCharArray()) {
            if (count[c] > 0) {
                set.add(c);
            }
        }

        // 构造输出结果
        StringBuilder result = new StringBuilder();
        for (char c : set) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}