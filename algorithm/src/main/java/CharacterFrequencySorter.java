import java.util.*;

/**
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的
 * 次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。如果次数相同，按
 * 照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述:
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述:
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的
 * 分号；字母和次数间用英文冒号分隔。
 * 示例 1
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 * 说明
 * 每个字符出现的个数都是 2，故 x 排在 y 之前，而小写字母 x 在 X 之前
 * 示例 2
 * 输入
 * abababb
 * 输出
 * b:4;a:3;
 * 说明
 * b 的出现个数比 a 多，故 b 排在 a 之前
 * 升序排序 users.sort((u1, u2) -> Integer.compare(u1.age, u2.age));
 * 降序排序 users.sort((u1, u2) -> Integer.compare(u2.age, u1.age));
 * a : 97
 * A : 65
 * */
public class CharacterFrequencySorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // 统计每个字符的出现次数
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // 对字符进行排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
//        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                if (o1.getValue().equals(o2.getValue())) {
//                    return o1.getKey() - o2.getKey();
//                }
//                return o2.getValue() - o1.getValue();
//            }
//        });
        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();  // descend，保证小写在大写之前(ascend)
            }
            return b.getValue() - a.getValue(); // 出现次数降序
        });

        // 构建输出字符串
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            output.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }

        // 输出结果
        System.out.println(output.toString());
    }
}
