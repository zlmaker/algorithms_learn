package remove_item;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
class Solution1 {//暴力解法，双循环遍历

    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (val == nums[i]) {// 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;// 此时数组的大小-1
                i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位，如果不移动的话，马上就会有i++。
            }
        }
        return size;
    }
}

class Solution2 {// 双指针法（快慢指针法）

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;// 定义两个快慢指针
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                // 如果不相等，在快慢指针还没有分开之前，相当于什么也没有做，只是都加1，
                // 但如果出现速度不同的时候，就相当于快指针的数据覆盖慢指针的数据。
                // 建议学这个方法的时候，用相等来判断条件，之后再优化成不等的条件。
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;// 快指针和慢指针的差值就相当于删除了几个元素，而快指针到最后就是数组的长度，因此直接返回慢指针就是数组删除元素之后的长度了。
    }
}

class Solution3 {// 相向双指针方法

    public int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            // 找左边等于val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val) {
                leftIndex++;
            }
            // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] != val) {
                rightIndex++;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex;// leftIndex一定指向了最终数组末尾的下一个元素，
        // 因为介素循环的条件是<=，最后leftIndex的值会比删除后的数组最大索引大1.
    }
}
