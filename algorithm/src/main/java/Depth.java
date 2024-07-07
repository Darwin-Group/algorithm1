import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 现有一字符串仅由 '('，')'，'{'，'}'，'['，']'六种括号组成。
 * 若字符串满足以下条件之一，则为无效字符串：
 * ①任一类型的左右括号数量不相等；
 * ②存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效则输出 0。
 * 0≤字符串长度≤100000
 * 输入描述:
 * 一个只包括 '('，')'，'{'，'}'，'['，']'的字符串
 * 输出描述:
 * 一个整数，最大的括号深度
 * 示例 1
 * 输入
 * []
 * 输出
 * 1
 * 说明
 * 有效字符串，最大嵌套深度为 1
 * 示例 2
 * 输入
 * ([]{()})
 * 输出
 * 3
 * 说明
 * 有效字符串，最大嵌套深度为 3
 * 示例 3
 * 输入
 * (]
 * 输出
 * 0
 * 说明
 * 无效字符串，有两种类型的左右括号数量不相等
 * 示例 4
 * 输入
 * ([)]
 * 输出
 * 0
 * 说明
 * 无效字符串，存在未按正确顺序闭合的括号
 * 示例 5
 * 输入
 * )(
 * 输出
 * 0
 * 说明
 * 无效字符串，存在未按正确顺序闭合的括号
 * */
public class Depth {
    public int maxDepth(String s) {
        // 匹配左右括号
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 使用栈来处理括号匹配
        Deque<Character> stack = new ArrayDeque<>();
        int currentDepth = 0;
        int maxDepth = 0;

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                // 如果是左括号
                stack.push(c);
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (map.containsKey(c)) {
                // 如果是右括号
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    // 栈为空或不匹配，直接返回 0
                    return 0;
                }
                stack.pop();
                currentDepth--;
            }
        }

        // 如果栈非空，表示有未匹配的左括号
        if (!stack.isEmpty()) return 0;

        // 返回最大深度
        return maxDepth;
    }
}
