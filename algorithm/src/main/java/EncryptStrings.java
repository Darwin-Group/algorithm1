import java.util.Scanner;

/**
 * 一串未加密的字符串 str，通过对字符串的每一个字母进行改变来实现加密，加密方式
 * 是 在 每 一 个 字 母 str[i] 偏 移 特 定 数 组 元 素 a[i] 的 量 ， 数 组 a 前 三 位 已 经 赋 值 ：
 * a[0]=1,a[1]=2,a[2]=4。当 i>=3 时，数组元素 a[i]=a[i-1]+a[i-2]+a[i-3]，
 * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是 1,2,4,7,13。
 * 输入描述:
 * 第一行为一个整数 n（1<=n<=1000），表示有 n 组测试数据，每组数据包含一行，原文 str
 * （只含有小写字母，0<长度<=50）。
 * 输出描述:
 * 每组测试数据输出一行，表示字符串的密文
 * 示例 1
 * 输入
 * 1
 * xy
 * 输出
 * ya
 * 说明
 * 第一个字符 x 偏移量是 1，即为 y，第二个字符 y 偏移量是 2，即为 a
 * 示例 2
 * 输入
 * 2
 * xy
 * abcde
 * 输出
 * ya
 * bdgkr
 * 说明
 * 第二行输出字符偏移量分别为 1、2、4、7、13
 */
public class EncryptStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());  // 读取测试数据组数
        int[] a = new int[50];  // 创建数组，长度至少为字符串的最大长度
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;

        // 计算 a 数组的所有必要值
        for (int i = 3; i < 50; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        StringBuilder output = new StringBuilder();
        while (n-- > 0) {
            String str = scanner.nextLine();  // 读取字符串
            StringBuilder encryptedString = new StringBuilder();

            // 对字符串中的每个字符进行加密
            for (int i = 0; i < str.length(); i++) {
                char originalChar = str.charAt(i);
                int newCharPosition = (originalChar - 'a' + a[i]) % 26;  // 计算新位置
                char newChar = (char) ('a' + newCharPosition);
                encryptedString.append(newChar);
            }

            // 将加密后的字符串添加到输出
            output.append(encryptedString).append("\n");
        }

        System.out.print(output.toString());
        scanner.close();
    }
}