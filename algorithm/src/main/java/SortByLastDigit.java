import java.util.Arrays;
import java.util.Comparator;

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
public class SortByLastDigit {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 5, -21, 22, 11, 55, -101, 42, 8, 7, 32};

        // 使用Comparator根据元素十进制最低位排序
        // Comparator.comparingInt(i -> Math.abs(i % 10)) 创建了一个基于数字的比较器
        // 避免了自动装箱，因为它直接处理原始类型 int
        Arrays.sort(array, Comparator.comparingInt(i -> Math.abs(i % 10)));

        // 打印排序后的数组
        System.out.println(Arrays.toString(array));
    }
}