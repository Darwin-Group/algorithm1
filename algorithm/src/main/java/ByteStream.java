import java.math.BigInteger;

public class ByteStream {
    public static void main(String[] args) {
        // 输入待编码的非负整数字符串
        String input = "1000";

        // 将字符串解析为 BigInteger，以支持大整数的处理
        BigInteger num = new BigInteger(input);

        // 存储编码结果的字符串
        StringBuilder result = new StringBuilder();

        // 依据编码规则，逐字节进行编码
        while (num.compareTo(BigInteger.ZERO) > 0) {
            // 取当前数字的低 7 位作为当前字节的内容
            int currentByte = num.and(BigInteger.valueOf(0x7F)).intValue();
            // 移除当前数字的低 7 位
            num = num.shiftRight(7);

            // 如果还有更多字节，设置当前字节的最高位为 1
            if (num.compareTo(BigInteger.ZERO) > 0) {
                currentByte |= 0x80; // 设置最高位为 1，表示后续还有字节
            }

            // 将当前字节转换成 16 进制的字符串形式并追加到结果中
            result.insert(0, String.format("%02X", currentByte));
        }

        // 输出编码后的结果
        System.out.println(result.toString());
    }
}