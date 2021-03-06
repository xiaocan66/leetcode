
/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int []> list =new ArrayList<>();
        int [] num = new int[(target+1)/2+1];
        for(int i=0;i < num.length;i++) num[i] =i;
        int i =1,j=2,s=3;
        while(i<j){
            if(s==target){
                list.add(Arrays.copyOfRange(num,i,j+1));
            }
            if(s>=target){
                s-=i;
                i++;
            }else{
                j++;
                s+=j;
            }
        }
       

    int [][]arr = new int[list.size()][];
    list.toArray(arr);
    // System.out.println(list);
    return arr;
    }
}