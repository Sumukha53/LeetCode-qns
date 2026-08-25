class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        unordered_map<int,int>m;
        int ans=0;
        for(int i:nums){
            if(i%k==0){
                m[i]++;
            }
        }
        for(int i=k;i<=nums.size()*k;i+=k){
            if(m[i]==0)return i;
        }
        return nums.size()*k+k;
    }
};