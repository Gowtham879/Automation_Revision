package hooks;

import java.io.*;

public class Hooks  {
    public  String getURL(){
        String url = "";
            try {
                FileReader filereader = new FileReader(new File("C:\\Users\\gowtham.n\\Documents\\tricentis.txt"));
                BufferedReader bufferedreader = new BufferedReader(filereader);
                url=bufferedreader.readLine();
                System.out.println(url);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return url;
    }
    public void delayScript(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
        }
    }
    }

