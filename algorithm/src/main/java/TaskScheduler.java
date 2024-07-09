import java.util.Scanner;

/**
 * 为了充分发挥 GPU 算力，需要尽可能多的将任务交给 GPU 执行，现在有一个任务数组，
 * 数组元素表示在这 1 秒内新增的任务个数且每秒都有新增任务，
 * 假设 GPU 最多一次执行 n个任务，一次执行耗时 1 秒，在保证 GPU 不空闲情况下，最少需要多长时间执行完成
 * 输入描述:
 * 第一个参数为 GPU 一次最多执行的任务个数，取值范围[1, 10000]
 * 第二个参数为任务数组长度，取值范围[1, 10000]
 * 第三个参数为任务数组，数字范围[1, 10000]
 * 输出描述:
 * 执行完所有任务最少需要多少秒
 * 示例 1
 * 输入
 * 3
 * 5
 * 1 2 3 4 5
 * 输出
 * 6
 * 说明
 * 一次最多执行 3 个任务，最少耗时 6s
 * 示例 2
 * 输入
 * 4
 * 5
 * 5 4 1 1 1
 * 输出
 * 5
 * 说明
 * 一次最多执行 4 个任务，最少耗时 5s
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // GPU一次最多执行的任务个数
        int length = scanner.nextInt();  // 任务数组长度
        int[] tasks = new int[length];
        for (int i = 0; i < length; i++) {
            tasks[i] = scanner.nextInt();  // 填充任务数组
        }
        System.out.println(minTimeToCompleteTasks(n, tasks));
    }

    private static int minTimeToCompleteTasks(int n, int[] tasks) {
        int time = 0;
        int remainingTasks = 0;

        for (int task : tasks) {
            remainingTasks += task;  // 新增任务加入到待处理任务中
            if (remainingTasks > n) {
                remainingTasks -= n;  // 处理n个任务
                time++;  // 增加一秒
            } else {
                remainingTasks = 0;  // 如果少于或等于n个任务，全部处理完
                time++;  // 增加一秒
            }
        }

        // 处理剩余的任务
        while (remainingTasks > 0) {
            remainingTasks -= n;
            time++;
        }

        return time;
    }
}