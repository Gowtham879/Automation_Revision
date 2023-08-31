package Programs;

public class Swaping_Number {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println("Befour Swapping "+a + " " +b);
       //logic-1
        /*int c=a;
        a=b;
        b=c;*/
        //logic-2
     /*   a=a+b;
        b=a-b;
        a=a-b; */
     //logic-3
        a=a*b;
        b=a/b;
        a=a/b;
        System.out.println("After Swapping "+a +" " +b);
    }
}
