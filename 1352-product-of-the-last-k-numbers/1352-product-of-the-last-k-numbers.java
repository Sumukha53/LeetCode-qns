class ProductOfNumbers {
    List<Integer>temp;
    public ProductOfNumbers() {
        temp=new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0){temp.clear();return;}
        if(temp.size()==0)temp.add(1);
        temp.add(temp.get(temp.size()-1)*num);
    }
    
    public int getProduct(int k) {
        if(temp.size()-k<=0)return 0;
        return temp.get(temp.size()-1)/temp.get(temp.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */