package com.cug.trueTest.kuaishou;


import java.util.*;

public class Main3 {
    static  class PhoneNum implements Comparable<PhoneNum> {
        String num;
        boolean baoOrShun;
        int bao;
        int shun;
        PhoneNum(boolean baoOrShun,int bao, int shun,String num){
            this.baoOrShun=baoOrShun;
            this.bao=bao;
            this.shun=shun;
            this.num=num;
        }

        @Override
        public int compareTo(PhoneNum o2) {
            if(this.baoOrShun&&o2.baoOrShun)
                return this.bao-o2.bao;
            else if(!this.baoOrShun&&!o2.baoOrShun)
                return this.shun-o2.shun;
            else if(this.baoOrShun&&!o2.baoOrShun)
                return 1;
            else
                return -1;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String[] sp = s.split(",");
        List<PhoneNum> phoneNums = find(sp);
        for (int i = 0; i < phoneNums.size(); i++) {
            System.out.print(phoneNums.get(i).num+",");
            
        }

    }
    public static List<PhoneNum> find(String[] sp){
        ArrayList<PhoneNum> ret = new ArrayList<>();

        for (int i = 0; i < sp.length; i++) {
            int bao=1;
            int shun=1;
            int Bshun=0;
            for (int j = 4; j <sp[i].length() ; j++) {
                char c=sp[i].charAt(j);
                char pre=sp[i].charAt(j-1);
                if(c==pre){
                    bao++;
                    shun=1;
                }else  {
                    if(bao<3)
                        bao=1;
                    int cha=c-pre;
                    if(cha==1||cha==-1){
                        if(Bshun==cha)
                            shun++;
                        else {
                            Bshun=cha;
                            shun=1;}
                    }
                }
            }
            if(bao>2){
                ret.add(new PhoneNum(true,bao,0,sp[i]));
            }else if(shun>2){
                ret.add(new PhoneNum(false,0,shun,sp[i]));
            }
        }
        for (int i = 1; i <ret.size() ; i++) {
            for (int j = 0; j <ret.size()-i ; j++) {
                if(ret.get(j).compareTo(ret.get(j+1))<0)
                {
                    PhoneNum temp=ret.get(j);
                    ret.set(j,ret.get(j+1));
                    ret.set(j+1,temp);
                }
            }
        }

        
        return ret;
    }
}
