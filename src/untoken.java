

import java.util.*;

/**
 * Created by lizhuo on 17/5/23.
 */
public class untoken {
    public String authentication(Map<String , Object > srcData){

        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){
            //升序排序
            public int compare(Map.Entry<String,Object> o1, Map.Entry<String,Object> o2){
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuffer srcSb = new StringBuffer();
        for(Map.Entry<String , Object>srcAtom : list){
            srcSb.append(String.valueOf(srcAtom.getValue()));
        }
        System.out.println("身份验证加密前字符串："+srcSb.toString());
        //计算token
        String token1 = token.md5(srcSb.toString());
//      System.out.println(cToken);//for test
        return token1;
    }
}
