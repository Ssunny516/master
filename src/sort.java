import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lizhuo on 17/5/22.
 */
public class sort {
    public static void sort(double[][] ob, List<Integer> order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                double[] one = (double[]) o1;
                double[] two = (double[]) o2;
                for (int i = 0; i < order.size(); i++) {
                    int k = order.get(i);
                    if (one[k] > two[k]) {
                        return -1;
                    } else if (one[k] < two[k]) {
                        return 1;
                    } else {
                        continue;  //如果按一条件比较结果相等，就使用第二个条件进行比较。
                    }
                }
                return 0;
            }
        });
    }
    public static void main(String[] args){
        List<Integer> order = new ArrayList<>();
        order.add(1);
        double[][] a = {{0.0,0.0}, {2.0, 0.37},{3.0,0.37}};
        sort(a,order);
        System.out.print(a[0][0]);
    }
}
