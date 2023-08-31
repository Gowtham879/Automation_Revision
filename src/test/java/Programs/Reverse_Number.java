package Programs;

import java.util.Scanner;

public class Reverse_Number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num= scanner.nextInt();
        System.out.println("Enter the Number is "+num);
        //logic-1
     /*   int rev=0;
        while (num!=0){
            int rem=num%10;
            rev=rev*10+rem;
            num=num/10;
        }*/
        //Logic-2 StringBuffer
       /*StringBuffer stringBuffer=new StringBuffer(String.valueOf(num));
        StringBuffer rev=stringBuffer.reverse();
        System.out.println("Reverse Number is "+rev);*/
        //logic-3 StringBuilder
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(num);
        StringBuilder rev=stringBuilder.reverse();
        System.out.println("Reverse Number is "+rev);

    }
}
