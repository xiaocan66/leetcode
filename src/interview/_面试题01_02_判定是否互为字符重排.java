/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例 1：

输入: s1 = "abc", s2 = "bca"
输出: true 
示例 2：

输入: s1 = "abc", s2 = "bad"
输出: false
说明：

0 <= len(s1) <= 100
0 <= len(s2) <= 100


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-permutation-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1= s1.length();
        int len2 = s2.length();
        if(len1!=len2) return false;
        int [] hash = new int[26];
        for(char ch : s1.toCharArray()){
            hash[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            hash[ch-'a']--;
        }
        for(int val : hash){
            if(val!=0) return false;
        }
        return true;
    }
}