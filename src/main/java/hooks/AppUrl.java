package hooks;

import java.util.HashMap;

public class AppUrl {
    public static String urls(String urls){
        HashMap<String,String> url=new HashMap<String ,String>();
        url.put("Tosca","https://demowebshop.tricentis.com/");
        url.put("Flipkart","https://www.flipkart.com/");
        url.put("Amazon","https://www.amazon.com/");
        String val= url.get(urls);
        System.out.println(val);
        return val;
    }

    public static void main(String[] args) {
       // AppUrl.urls("Flipkart");
    }

}
