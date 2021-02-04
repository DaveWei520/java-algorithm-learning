package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/02/04 10:34
 * @description:
 */
public class MN {

    class Point{
        int x;
        int y;
    }
    public static void solution(List<Point> allList, List<Point> KList){
        for(int i=0; i< allList.size();i++){
            Point cur = allList.get(i);
            for(int j=0;j<KList.size();j++){
                Point p = KList.get(j);
                int a = Math.abs(p.x - cur.x)+Math.abs(p.y-cur.y);
                System.out.println(a);
            }
        }
    }
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        System.out.println("Hello World!");
    }
}
