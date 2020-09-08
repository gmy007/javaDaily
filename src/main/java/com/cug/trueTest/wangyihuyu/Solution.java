package com.cug.trueTest.wangyihuyu;

public class Solution {
    /**
     * 接收两个表示9进制数的字符串，返回表示它们相加后的9进制数的字符串
     *  num1 string字符串 第一个加数
     *  num2 string字符串 第二个加数
     *  string字符串
     */
    public static void main(String[] args) {
        String num1="7725";
        String num2="7777.258";
        char[] char1 = num1.toCharArray();char[] char2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int point1=num1.length()-1;
        int point2=num2.length()-1;
        String add = new Solution().add(num1, num2);
        System.out.println(add);
    }
    public String add (String num1, String num2) {
        if(num1.length()==0)
            return num2;
        if(num2.length()==0)
            return num1;
        StringBuilder sb = new StringBuilder();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int point1 = num1.indexOf(".");
        int point2 = num2.indexOf(".");

        if(point1==-1||point2==-1){
            if(point1==-1&&point2==-1){
                point1=num1.length()-1;point2=num2.length()-1;
                int pre=0;
                while(point1>=0&&point2>=0){
                    int cur =Integer.valueOf(String.valueOf(char1[point1]))+Integer.valueOf(String.valueOf(char2[point2]));
                    sb.append((cur+pre)%9);
                    if(cur+pre>=9){
                        pre=1;
                    }else pre=0;
                    point1--;point2--;
                }
                while(point1>=0){
                    int cur =Integer.valueOf(String.valueOf(char1[point1]));
                    sb.append((cur+pre)%9);
                    if(cur+pre>=9){
                        pre=1;
                    }else pre=0;
                    point1--;
                }
                while(point2>=0){
                    int cur =Integer.valueOf(String.valueOf(char2[point2]));
                    sb.append((cur+pre)%9);
                    if(cur+pre>=9){
                        pre=1;
                    }else pre=0;
                    point2--;
                }
                if(pre==1)
                    sb.append("1");
                return sb.reverse().toString();
            }
            if(point1!=-1){
                sb.append(num1.substring(point1+1,num1.length())).reverse();
                point1--;
                point2=num2.length()-1;

            }else if(point2!=-1){
                sb.append(num2.substring(point2+1,num2.length())).reverse();
                point2--;
                point1=num1.length()-1;
            }
            int pre=0;
            sb.append(".");
            while(point1>=0&&point2>=0){
                int cur =Integer.valueOf(String.valueOf(char1[point1]))+Integer.valueOf(String.valueOf(char2[point2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point1--;point2--;
            }
            while(point1>=0){
                int cur =Integer.valueOf(String.valueOf(char1[point1]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point1--;
            }
            while(point2>=0){
                int cur =Integer.valueOf(String.valueOf(char2[point2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point2--;
            }
            if(pre==1)
                sb.append("1");
            return sb.reverse().toString();

        }else{
            int pre=0;
            int len1=num1.length()-1-point1;
            int len2=num2.length()-1-point2;
            int fpoint1=num1.length()-1;
            int fpoint2=num2.length()-1;
            if(len1>len2){
                while(len1>len2){
                    sb.append(String.valueOf(char1[fpoint1]));
                    len1--;
                    fpoint1--;
                }

            }else if(len2>len1){
                while(len2>len1){
                    sb.append(String.valueOf(char2[fpoint2]));
                    len2--;
                    fpoint2--;
                }
            }
            while(fpoint1>point1&&fpoint2>point2){
                int cur =Integer.valueOf(String.valueOf(char1[fpoint1]))+Integer.valueOf(String.valueOf(char2[fpoint2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                fpoint1--;fpoint2--;
            }
            while(fpoint1>point1){
                int cur =Integer.valueOf(String.valueOf(char1[fpoint1]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                fpoint1--;
            }
            while(fpoint2>point2){
                int cur =Integer.valueOf(String.valueOf(char2[fpoint2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                fpoint2--;
            }

            sb.append(".");
            point1 = num1.indexOf(".")-1;
            point2 = num2.indexOf(".")-1;

            while(point1>=0&&point2>=0){
                int cur =Integer.valueOf(String.valueOf(char1[point1]))+Integer.valueOf(String.valueOf(char2[point2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point1--;point2--;
            }
            while(point1>=0){
                int cur =Integer.valueOf(String.valueOf(char1[point1]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point1--;
            }
            while(point2>=0){
                int cur =Integer.valueOf(String.valueOf(char2[point2]));
                sb.append((cur+pre)%9);
                if(cur+pre>=9){
                    pre=1;
                }else pre=0;
                point2--;
            }
            if(pre==1)
                sb.append("1");
            return sb.reverse().toString();
        }

    }


}
