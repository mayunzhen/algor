package com.example.algorithm.swordoffer;

//大数相加
public class BigNumUtil {
    public static void main(String[] args) {
        System.out.println(add("-123","-56789"));
    }
    /**
     * 大数相加
     * @param a
     * @param b
     * @return
     */
    public static String add(String a, String b){

        //1.判断相加之后的符号
        char signA = a.charAt(0);
        char signB = b.charAt(0);

        if(signA == '-' && signB == '-'){//A B 都是负的
            if(a.substring(1).length() > b.substring(1).length())
                return "-" + add(a.substring(1),b.substring(1));
            else
                return "-" + add(b.substring(1),a.substring(1));

        }else if((signA == '-' && signB != '-')){//A 是负的 B是正的

            return sub(b.substring(1),a.substring(1));

        }else if(signA != '-' && signB == '-'){//A是正的 B是负的

            return sub(a.substring(1),b.substring(1));
        }

        if(signA == '-' || signA == '+'){

            a = a.substring(1);
        }
        if(signB == '-' || signB == '+'){

            b = b.substring(1);
        }

        char[] numA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] numB = new StringBuilder(b).reverse().toString().toCharArray();

        //2.开始计算
        int[] result = new int[numA.length + 1];

        for(int i = 0 ; i < result.length;i++){

            int intA = i < numA.length ? numA[i] - '0' : 0;
            int intB = i < numB.length ? numB[i] - '0' : 0;
            result[i] = intA + intB;
        }
        //3.进位转换
        for(int i = 0 ; i < result.length ; i++){
            if(result[i] > 10){
                result[i+1] += result[i] /10;
                result[i] = result[i] % 10 ;
            }
        }
        //4.输出结果
        StringBuilder re = new StringBuilder();
        boolean bool = true;
        for(int i = result.length -1 ; i >=0  ; i--){
            if(result[i] == 0 && bool){
                continue;
            }else{
                bool = false;
            }
            re.append(result[i]);
        }
        return re.toString();
    }
    /**
     * 大数相减
     */
    public static String sub(String a ,String b){

        char[] numA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] numB = new StringBuilder(b).reverse().toString().toCharArray();

        //2.判断符号位
        boolean isPositive = true;
        if(numA.length < numB.length){
            isPositive = false;
        }else if(numA.length == numB.length){
            int i = numA.length - 1 ;
            while (i > 0 && numA[i] == numB[i]){
                i--;
            }
            if(numA[i] < numB[i]){
                isPositive = false;
            }
        }

        //3.开始计算
        int maxLen = numA.length > numB.length ? numA.length : numB.length;
        int result[] = new int[maxLen];
        for(int i = 0 ; i < maxLen ; i++){
            int intA = i < numA.length ?(numA[i] - '0') : 0;
            int intB = i < numB.length ?(numB[i] - '0') : 0;
            if(isPositive){
                result[i] = intA - intB;
            }else{
                result[i] = intB - intA;
            }
        }

        //4.进位装换
        for(int i = 0 ; i < result.length ; i++){
            if(result[i] < 0){
                result[i+1] -=1;
                result[i] += 10;
            }
        }

        //5.输出结果
        StringBuilder re = isPositive ? new StringBuilder() : new StringBuilder("-");
        boolean bool = true;
        for(int i = result.length - 1 ; i >= 0 ; i--){
            if(result[i] == 0 && bool){
                continue;
            }else{
                bool = false;
            }
            re.append(result[i]);
        }


        return re.toString();
    }

    /**
     * 大数相乘
     * @param a
     * @param b
     * @return
     */
    public static String multi(String a,String b){

        //1.判断相乘之后的符号
        char signA = a.charAt(0);
        char signB = b.charAt(0);
        boolean isPositive = true;
        if(signA == '+' || signA == '-'){
            if(signA == '+'){
                isPositive = true;
            }else{
                isPositive = false;
            }
            a = a.substring(1);
        }

        if(signB == '+' || signB == '-'){
            if(signB == '+' && isPositive){
                isPositive = true;
            }else if(signB == '-' && !isPositive){
                isPositive = true;
            }else{
                isPositive = false;
            }
            b = b.substring(1);
        }
        //2.反转数字，使用倒序
        StringBuilder sb = new StringBuilder(a);
        char[] numA = sb.reverse().toString().toCharArray();
        sb = new StringBuilder(b);
        char[] numB = sb.reverse().toString().toCharArray();

        //3.乘法规律:
        // 对 a * b 而言，a 的第 i 位和 b 的第 j 位相乘的结果会放在 result[i+j]中
        // 两个数（a,b）相乘最后的结果位数一定小于或等于 a.len + b.len ;
        int[] result = new int[numA.length + numB.length];
        for(int i = 0 ; i < numA.length ; i++){
            for(int j = 0 ; j < numB.length ; j++){
                result[i+j] += (numA[i] - '0') * (numB[j] - '0');
            }
        }

        //4.实现进位运算
        for(int i = 0 ; i < result.length ; i++){
            if(result[i] > 10){
                result[i+1] += result[i] / 10;
                result[i] = result[i] % 10 ;
            }
        }
        //5.输出结果
        StringBuilder re = isPositive ? new StringBuilder() : new StringBuilder("-");
        boolean bool = true;
        for(int i = result.length-1 ; i >=0  ; i--){
            if(result[i] == 0 && bool){
                continue;
            }else{
                bool = false;
            }
            re.append(result[i]);
        }

        return re.toString();
    }


}
