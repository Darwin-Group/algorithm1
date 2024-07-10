import java.util.*;

/**
 * 给定一个非空数组（列表），其元素数据类型为整型，请按照数组元素十进制最低位从小到
 * 大进行排序，十进制最低位相同的元素，相对位置保持不变。
 * 当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
 * 输入描述:
 * 给定一个非空数组，其元素数据类型为 32 位有符号整数，数组长度[1, 1000]
 * 输出描述:
 * 输出排序后的数组
 * 示例 1
 * 输入
 * 1,2,5,-21,22,11,55,-101,42,8,7,32
 * 输出
 * 1,-21,11,-101,2,22,42,32,5,55,7,8
 */
public class DecimalPosition {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, -21, 22, 11, 55, -101, 42, 8, 7, 32};

        // 使用自定义的比较器对数组进行排序
//        Arrays.sort(array, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer num1, Integer num2) {
//                // 获取元素去除符号位后的十进制最低位
//                int lastDigit1 = Math.abs(num1) % 10;
//                int lastDigit2 = Math.abs(num2) % 10;
//
//                // 按照十进制最低位从小到大排序
//                if (lastDigit1 != lastDigit2) {
//                    return Integer.compare(lastDigit1, lastDigit2);
//                } else {
//                    return 0; // 相同最低位，保持相对位置不变
//                }
//            }
//        });

        // 输出排序后的数组
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
