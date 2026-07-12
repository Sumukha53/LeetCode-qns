class Solution {
    public int secondsBetweenTimes(String s, String e) {
        return ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0')) * (-3600) +
                ((s.charAt(3) - '0') * 10 + (s.charAt(4) - '0')) * (-60) +
                ((s.charAt(6) - '0') * 10 + (s.charAt(7) - '0')) * (-1) +
                ((e.charAt(0) - '0') * 10 + (e.charAt(1) - '0')) * 3600 +
                ((e.charAt(3) - '0') * 10 + (e.charAt(4) - '0')) * 60 +
                (e.charAt(6) - '0') * 10 + (e.charAt(7) - '0');
    }
}