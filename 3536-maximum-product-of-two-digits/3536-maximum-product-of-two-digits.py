class Solution:
    def maxProduct(self, n: int) -> int:
        if (n//10)==0:  return n
        max1=0
        max2=0
        while n!=0:
            if n%10>max1:
                max2=max1
                max1=n%10
            else:
                max2=max(max2,n%10)
            n//=10
        return max1*max2
        