class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] seqn = seq();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(seqn);
        for (int i : seqn)
            if (i >= low && i <= high)
                ans.add(i);
        return ans;
    }

    private int[] seq() {
        int[] ans = new int[81];
        int temp = 0;
        int k = 0;
        for (int i = 1; i <= 9; i++) {
            temp = 0;
            for (int j = i; j <= 9; j++) {
                temp = temp * 10 + j;
                ans[k++] = temp;
            }
        }
        return ans;
    }
}