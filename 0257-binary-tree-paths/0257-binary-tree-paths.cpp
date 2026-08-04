/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    
private:
    void rtl(TreeNode* root,string s){
        if(root==nullptr)return;
        if(root->left==nullptr && root->right==nullptr){
            s+=to_string(root->val);
            ans.push_back(s);
            return;
        }
        rtl(root->left,s+to_string(root->val)+"->");
        rtl(root->right,s+to_string(root->val)+"->");
        return;
    }
    
    vector<string>ans;
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        rtl(root,"");
        return ans;
    }
};