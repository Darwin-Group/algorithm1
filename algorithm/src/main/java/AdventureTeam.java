import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不
 * 定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后，探险队需
 * 要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 1. 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中 0<x<1000，0<y<1000。
 * 同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 2. 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：x*x+y*y。
 * 3. 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 4. 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
 * 备注：不需要考虑双层括号嵌套的情况，比如 sfsdfsd((1,2))。
 * 输入描述:
 * 字符串，表示记录仪中的数据。
 * 如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述:
 * 字符串，表示最远足迹到达的坐标。
 * 如： (300,400)
 * 示例 1
 * 输入
 * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 输出
 * (5,10)
 * 说明
 * 记录仪中的合法坐标有 3 个： (3,10)， (3,4)， (5,10)，其中(5,10)是相距总部最远的坐标，
 * 输出(5,10)。
 * 示例 2
 * 输入
 * asfefaweawfaw(0,1)fe
 * 输出
 * (0,0)
 * 说明
 * 记录仪中的坐标都不合法，输出总部坐标（0,0）
 * */
public class AdventureTeam {
    public static void main(String[] args) {
        String input = "ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)";
        System.out.println(findFurthestCoordinate(input));
    }

    public static String findFurthestCoordinate(String data) {
        // 正则表达式匹配坐标格式
        String regex = "\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        int maxDistance = 0;
        String furthestCoordinate = "(0,0)";

        while (matcher.find()) {
            String coordinate = matcher.group();
            if (isValidCoordinate(coordinate)) {
                int distance = calculateDistance(coordinate);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    furthestCoordinate = coordinate;
                }
            }
        }

        return furthestCoordinate;
    }

    // 验证坐标的合法性
    private static boolean isValidCoordinate(String coordinate) {
        // 去掉括号
        String trimmed = coordinate.substring(1, coordinate.length() - 1);
        String[] parts = trimmed.split(",");

        // 验证 x 和 y 是否合法
        return isValidNumber(parts[0]) && isValidNumber(parts[1]);
    }

    // 检查数字是否合法：不以0开头（除非单独的0），并且在1-999的范围内
    private static boolean isValidNumber(String num) {
        if (num.startsWith("0") && num.length() > 1) return false;
        try {
            int value = Integer.parseInt(num);
            return value > 0 && value < 1000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 计算距离总部的距离平方
    private static int calculateDistance(String coordinate) {
        String trimmed = coordinate.substring(1, coordinate.length() - 1);
        String[] parts = trimmed.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return x * x + y * y;
    }
}
