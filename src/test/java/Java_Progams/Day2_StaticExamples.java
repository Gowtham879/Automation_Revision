package Java_Progams;

public class Day2_StaticExamples {
    static  String Company="ExxonMobil";
    String Name="Gowtham";
    static void s1(){
        System.out.println("Static Method");
        System.out.println(Company);
    }
    public  void ns1(){
        System.out.println("Non-Static Method");
        System.out.println(Name);
    }
    public static void main(String[] args) {
        Day2_StaticExamples se=new Day2_StaticExamples();
        System.out.println(se.Name);
        System.out.println(Company);

    }
}
