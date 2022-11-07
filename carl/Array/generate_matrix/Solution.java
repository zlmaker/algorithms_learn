package generate_matrix;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class Solution {// 左闭右开

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0;// 初始X位置
        int startY = 0;// 初始Y位置
        int loop = n / 2;// 循环次数
        int mid = n / 2;// 中间的位置
        int count = 1;// 填充的数字
        int offset = 1;// 每行每列偏移量，即每次循环边界收缩一位
        int i;
        int j;
        while (loop-- > 0) {
            // 模拟填充上行从左到右(左闭右开)
            for (j = startY; j < n - offset; j++) {
                result[startX][j] = count++;
            }
            // 模拟填充右列从上到下(左闭右开)
            for (i = startX; i < n - offset; i++) {
                result[i][j] = count++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (; j > startY; j--) {
                result[i][j] = count++;
            }
            // 模拟填充左列从下到上(左闭右开)
            for (; i > startX; i--) {
                result[i][j] = count++;
            }
            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startX++;
            startY++;
            // offset 控制每一圈里每一条边遍历的长度
            offset++;
        }
        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            result[mid][mid] = count;
        }
        return result;
    }
}
