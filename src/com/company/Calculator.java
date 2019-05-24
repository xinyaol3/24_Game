package com.company;

class Calculator {
    public int FPE(String s) {
        int open = 0;
        int close = 0;
        int ans=0;
        while (s.contains("(")==true) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open = i;
                }
                if (s.charAt(i) == ')') {
                    close = i;
                    ans = BasicCalculator(s, open, close);
                    String tmp = s.substring(open, close + 1);
                    s = s.replace(tmp, "" + ans);
                    System.out.println(s);
                    i=0;
                    FPE(s);
                }
            }
        }
        return BasicCalculator(s, 0, s.length() - 1);
    }
    public int BasicCalculator(String s,int open,int close)
    {
        int md = -1;
        int prev = 0;
        int sign = 1;
        int ans = 0;
        for (int j = open; j <= close; j++) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (++j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                }
                j--; // back to last digit of number

                if (md == 0) {
                    prev = prev * num;
                    md = -1;
                } else if (md == 1) {
                    prev = prev / num;
                    md = -1;
                } else {
                    prev = num;
                }
            } else if (c == '/') {
                md = 1;
            } else if (c == '*') {
                md = 0;
            } else if (c == '+') {
                ans = ans + sign * prev;
                sign = 1;
            } else if (c == '-') {
                ans = ans + sign * prev;
                sign = -1;
            }
        }
        ans = ans + sign * prev;
        return ans;
    }
}
