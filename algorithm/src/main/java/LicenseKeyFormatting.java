import java.util.*;

/**
 * 给定一个非空字符串 S，其被 N 个‘-’分隔成 N+1 的子串，给定正整数 K，要求除第一个子
 * 串外，其余的子串每 K 个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果
 * 它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如
 * 果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写
 * 字母的数量相等时，不做转换。
 * 输入描述:
 * 输入为两行，第一行为参数 K，第二行为字符串 S。
 * 输出描述:
 * 输出转换后的字符串。
 * 示例 1
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * 说明
 * 子串为 12abc、abCABc、4aB@，第一个子串保留，后面的子串每 3 个字符一组为 abC、
 * ABc、4aB、@，abC 中小写字母较多，转换为 abc，ABc 中大写字母较多，转换为 ABC，
 * 4aB 中大小写字母都为 1 个，不做转换，@中没有字母，连起来即 12abc-abc-ABC-4aB-@
 * 示例 2
 * 输入
 * 12
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abCABc4aB@
 * 说明
 * 子串为 12abc 、abCABc、 4aB@，第一个子串保留， 后面的子串每 12 个字符一组为
 * abCABc4aB@，这个子串中大小写字母都为 4 个，不做转换，连起来即 12abc-abCABc4aB@
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine().trim());  // 读取 K 值
        String S = scanner.nextLine().trim();  // 读取字符串 S

        // 将字符串按照 '-' 分割
        String[] parts = S.split("-");
        StringBuilder result = new StringBuilder(parts[0]);  // 第一个部分直接添加到结果中

        // 遍历除第一个外的所有部分
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            for (int j = 0; j < part.length(); j += K) {
                if (j > 0) {
                    result.append('-');  // 添加分隔符
                }
                // 截取 K 长度的子串或最后一部分的子串
                String subpart = part.substring(j, Math.min(j + K, part.length()));
                result.append(transform(subpart));  // 转换并添加子串
            }
        }

        System.out.println(result.toString());
        scanner.close();
    }

    // 转换函数，根据大小写字母的多少进行转换
    private static String transform(String subpart) {
        int lowerCount = 0;
        int upperCount = 0;

        // 计算大小写字母数量
        for (char c : subpart.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }

        // 转换逻辑
        if (lowerCount > upperCount) {
            return subpart.toLowerCase();
        } else if (upperCount > lowerCount) {
            return subpart.toUpperCase();
        }
        return subpart;  // 大小写数量相等时不做转换
    }
}