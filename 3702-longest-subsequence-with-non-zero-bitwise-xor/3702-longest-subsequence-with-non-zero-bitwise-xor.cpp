class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int ans=0;
        bool nz=0;
        for(int i:nums){
            if(i)nz=1;
            ans^=i;
        }
        if(ans)return nums.size();
        if(!nz)return 0;
        return nums.size()-1;
    }
};