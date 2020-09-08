package com.cug.jzOffer.jianzhiOffer2;

public class Question44 {
    /*
    得到一段数字序列的第N位数
    分别减去0-9所有的位数
          10-99
          100-999
          这样分段的减去每段包含位数，定位到某一段，如定位到3位数，则再让这个index除以3（多少位）算出是第几个3位数再取余就知道是某个数的某位
     */
    public static void main(String[] args) {
        Question44 q = new Question44();

        System.out.println(q.getDigitAtIndex(1001));
    }
    public int getDigitAtIndex(int index){
        if(index<0)
            return -1;
        int place=1;
        while(true){
            int amount=getAmount(place);
            int totalAmount=amount*place;
            if(index<totalAmount)
                return getDigitAtIndex(index,place);
            index-=totalAmount;
            place++;
        }
    }
    public int getAmount(int place){
        if(place==1)
            return 10;
        return (int) Math.pow(10,place-1)*9;
    }
    public int getBeginNum(int place){
        if (place==1)
            return 0;
        return (int)Math.pow(10,place-1);
    }
    public int getDigitAtIndex(int index,int place){
        int begin=getBeginNum(place);
        int shift=index/place;
        StringBuffer sb=new StringBuffer();
        sb.append(begin+shift);
        int count=index%place;
        return sb.toString().toCharArray()[count]-'0';



    }
}
