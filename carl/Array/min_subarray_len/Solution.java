package min_subarray_len;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和≥s的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 */
class Solution1 {// 暴力解法

    public int minSubArrayLen(int s, int[] nums) {
        int result = Byte.MAX_VALUE;// 最终的结果
        int sum = 0;// 子序列的数值之和
        for (int i = 0; i < nums.length; i++) {// 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) {// 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) {// 一旦发现子序列和超过了s，更新result
                    result = Math.min(result, j - i + 1);
                    break;// 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Byte.MAX_VALUE ? 0 : result;
    }

}

class Solution2 {// 滑动窗口

    public int minSubArrayLen(int s, int[] nums) {
        int result = Byte.MAX_VALUE;
        int sum = 0;// 滑动窗口数值之和
        int left = 0;// 滑动窗口起始位置
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s) {
                result = Math.min(right - left + 1, result);
                sum -= nums[left++];// 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Byte.MAX_VALUE ? 0 : result;
    }
}
