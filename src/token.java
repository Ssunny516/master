import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import com.sun.tools.javac.util.Convert;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/**
 * Created by lizhuo on 17/5/23.
 */
public class token {

    private static final String encryModel = "MD5";

    public static String md5(String str){

        return encrypt(encryModel,str+System.currentTimeMillis());
    }

    public static String encrypt(String algorithm,String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length;i++){
                int b = bytes[i] & 0xFF;
                if (b < 0x10){
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
