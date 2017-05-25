import sun.plugin.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    int flag = 0;

    private String ip;

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip;}

    public static String loadJson (String url){
        StringBuilder json = new StringBuilder();

        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null){
                json.append(inputLine);
            }
            in.close();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return json.toString();
    }

    public boolean getTotal() {

        String url = "http://100.90.207.13:8000/master/state";
        String json = loadJson(url);
        String toDeal = json.substring(json.indexOf("[{\""),json.indexOf("\"}]"));
        String[] JSON = toDeal.split("},\\{");
        int i = 0;
        for (;i < JSON.length;i++){
            if (JSON[i].contains(ip)){
                System.out.println(JSON[i]);
                System.out.println(ip);
                int index = JSON[i].indexOf("used_resources");
                if (JSON[i].charAt(index+34) == '0' && JSON[i].charAt(index+36) == '0'){
                    break;
                }
                else {
                    flag = 1; //说明被使用
                    break;
                }
            }
        }
        if (flag == 1){
            return false;
        }
        else {
            return true;    //此offer所在物理机未被使用过
        }
    }
}
