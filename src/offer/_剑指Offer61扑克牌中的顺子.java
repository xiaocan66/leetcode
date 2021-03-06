import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
示例 1:

输入: [1,2,3,4,5]
输出: True
 

示例 2:

输入: [0,0,1,2,5]
输出: True
 

限制：

数组长度为 5 

数组的数取值为 [0, 13] .

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _剑指Offer61扑克牌中的顺子 {

  public boolean isStraight(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count++;
        continue;
      } else if (i + 1 < nums.length) {
        if (nums[i + 1] - nums[i] != 1 
        &&(nums[i + 1] - nums[i] - 1 > count || nums[i] == nums[i + 1])) {
          return false;
        } else {
          count -= nums[i + 1] - nums[i] - 1;
        }
      }
    }
    return true;
  }
}
