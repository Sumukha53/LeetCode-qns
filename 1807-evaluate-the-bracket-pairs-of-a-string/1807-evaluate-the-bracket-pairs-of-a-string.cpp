class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        unordered_map<string,string>m;
        for (auto i:knowledge)m[i[0]]=i[1];
        string ans="";
        int n=s.size();
        
        int i=0;
        string temp="";
        while(i<n){
            if(s[i]=='('){
                
                temp="";
            while(s[i]!=')'){
                i++;
                if(s[i]!=')')temp+=s[i];
            }
            if(m.find(temp)!=m.end())ans+=m[temp];
            else ans+='?';
                i++;
            
            }
            else{
           ans+=s[i];
           i++;}
            
        }return ans;
    }
};