/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _剑指Offer13_机器人的运动范围 {

  public int movingCount(int m, int n, int k) {
    if (k == 0) return 1;
    int[][] arr = new int[m][n];
    return dfs(arr, 0, 0, k, 0);
  }
  public int dfs(int[][] arr, int i, int j, int k, int n) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == -1) return n;
    int res = 0;
    int num = i;
    while (num != 0) {
      res += num % 10;
      num /= 10;
    }
    num = j;
    while (num != 0) {
      res += num % 10;
      num /= 10;
    }
    if (res > k) return n;
    arr[i][j] = -1;
    int path1 = dfs(arr, i + 1, j, k, n + 1);
    int path2 = dfs(arr, i - 1, j, k, path1);
    int path3 = dfs(arr, i, j + 1, k, path2);
    int path4 = dfs(arr, i, j - 1, k, path3);
    return path4;
  }
}
