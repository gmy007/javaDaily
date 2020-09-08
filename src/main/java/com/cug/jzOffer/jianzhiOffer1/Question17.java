package com.cug.jzOffer.jianzhiOffer1;

public class Question17 {
    //打印从1到最大的N位数
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static  void printN(int n){
        long max=0;
        for (int i = 0; i <n ; i++) {
            max= (long) (max*10+9);

        }
        for (int i = 1; i <= max; i++) {
            System.out.println(i);

        }
    }
    public static void main(String[] args) {
        new Question17().print1ToMaxOfNDigits(3);

    }
}
