class TrieNode{
        TrieNode[] children;
        boolean isWord=false;
        char c;
        TrieNode(char c){
            this.c=c;
            children=new TrieNode[26];
        }
    }

class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode(' ');
    }
    
    public void insert(String word) {
        int n=word.length();
        TrieNode curr=root;
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode(c);
            }
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        int n=word.length();
        TrieNode curr=root;
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        int n=prefix.length();
        TrieNode curr=root;
        for(int i=0;i<n;i++){
            char c=prefix.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */