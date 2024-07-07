import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定两个字符集合，一个为全量字符集，一个为已占用字符集。已占用的字符集中的字符不
 * 能再使用，要求输出剩余可用字符集。
 * 输入描述:
 * 1、输入为一个字符串，一定包含@符号。@前的为全量字符集，@后的字为已占用字符集。
 * 2、已占用字符集中的字符一定是全量字符集中的字符。字符集中的字符跟字符之间使用英
 * 文逗号分隔。
 * 3、每个字符都表示为字符加数字的形式，用英文冒号分隔，比如 a:1，表示 1 个 a 字符。
 * 4、字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过 100。
 * 5、如果一个字符都没被占用，@标识仍然存在，例如 a:3,b:5,c:2@
 * 输出描述:
 * 输出可用字符集，不同的输出字符集之间回车换行。
 * 注意，输出的字符顺序要跟输入一致。不能输出 b:3,a:2,c:2
 * 如果某个字符已全被占用，不需要再输出。
 * 示例 1
 * 输入
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * a:2,b:3,c:2
 * 说明
 * 全量字符集为 3 个 a，5 个 b，2 个 c。
 * 已占用字符集为 1 个 a，2 个 b。
 * 由于已占用字符不能再使用，因此，剩余可用字符为 2 个 a，3 个 b，2 个 c。
 * 因此输出 a:2,b:3,c:2
 * */
public class AvailableCharacterSet {
    public static void main(String[] args) {
        String input = "a:3,b:5,c:2@a:1,b:2";  // 示例输入
        String result = calculateAvailableCharacters(input);
        System.out.println(result);
    }

    public static String calculateAvailableCharacters(String input) {
        String[] parts = input.split("@");
        Map<String, Integer> totalCharacters = parseCharacterMap(parts[0]);
        Map<String, Integer> usedCharacters = parseCharacterMap(parts.length > 1 ? parts[1] : "");

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : totalCharacters.entrySet()) {
            String key = entry.getKey();
            int total = entry.getValue();
            int used = usedCharacters.getOrDefault(key, 0);
            int available = total - used;

            if (available > 0) {
                if (output.length() > 0) {
                    output.append(",");
                }
                output.append(key).append(":").append(available);
            }
        }

        return output.toString();
    }

    private static Map<String, Integer> parseCharacterMap(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (!s.isEmpty()) {
            String[] tokens = s.split(",");
            for (String token : tokens) {
                String[] parts = token.split(":");
                map.put(parts[0], Integer.parseInt(parts[1]));
            }
        }
        return map;
    }
}
