package binary_search;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
class Solution1 { // 左闭右闭型
    // 默认是升序
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;// 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + (right - left) >> 2;// 防止溢出 等同于(left + right)/2
            if (target > nums[middle]) {
                left = middle + 1;// target 在右区间，所以[middle + 1, right]
            } else if (target < nums[middle]) {
                right = middle - 1;// target 在左区间，所以[left, middle - 1]
            } else {
                return middle;
            }
        }
        return -1;
    }
}

class Solution2 {// 左闭右开型
    // 默认是升序
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length;// 定义target在左闭右闭的区间里，[left, right)
        while (left < right) {// 当left==right，区间[left, right]无效，所以用 <
            int middle = left + (right - left) >> 2;// 防止溢出 等同于(left + right)/2
            if (target > nums[middle]) {
                left = middle + 1;// target 在右区间，所以[middle + 1, right)
            } else if (target < nums[middle]) {
                right = middle;// target 在左区间，所以[left, middle)
            } else {
                return middle;
            }
        }
        return -1;
    }
}
