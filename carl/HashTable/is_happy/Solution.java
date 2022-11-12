package is_happy;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * 1^2 + 9^2 = 82
 * <p>
 * 8^2 + 2^2 = 68
 * <p>
 * 6^2 + 8^2 = 100
 * <p>
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {
    /**
     * 取数值各个位上的单数之和
     *
     * @param n
     * @return
     */
    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        // 使用HashSet来记录出现的数值
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);// 说明set中不包含n的值，将其添加
            n = getSum(n);// 更新n的值
        }
        return n == 1;
    }
}
