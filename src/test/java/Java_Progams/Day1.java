package Java_Progams;

public class Day1 {
    static   String s="10";


    public static void main(String[] args) {
        int a;
        a=4;
        System.out.println(a);
        int b = 1 + 1;
        System.out.println(b);
        boolean d = a == b;
        System.out.println(d);
        int c = ++a;
        System.out.println(c);
        String r="1", t="2";
        String q="1";
         s=r+q;
        Day1 day=new Day1();
        System.out.println(s);
//        Day2 d2=new Day2();
        Day2.day2();
        //s="hf";

//        System.out.println(a); //1  1
    }
     public static class Day2 {
      static String h="30";
      String y="23";
      public static void day2(){
       System.out.println("Static Method");
      }
      public  void day2NS(){
          System.out.println("Non-Static Method");
      }
     }

}
  class Day3 {
    static String h = "30";
    String y = "23";

    public static void day2() {
        System.out.println("Static Method");
    }

    public void day2NS() {
        System.out.println("Non-Static Method");
    }
}
 class Day2 {
    static String s="30";

    String y="23";

    public static void day2(){
        s="2";
        System.out.println("Static Method");
    }
    public  void day2NS(){
        s="3";
        System.out.println("Non-Static Method");
    }
}
