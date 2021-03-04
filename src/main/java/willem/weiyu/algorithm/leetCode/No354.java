package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/03/04 15:43
 * @description: 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式(w, h)出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * https://leetcode-cn.com/problems/russian-doll-envelopes
 */
public class No354 {

    /**
     * 时间复杂度：O(n)，n为envelopes的长度
     * 空间复杂度：O(1)
     * @param envelopes
     * @return
     */
    public static int solution(int[][] envelopes){
        if (envelopes == null || envelopes.length < 1) {
            return 0;
        }
        int[] min = new int[2];
        swap(envelopes[0], min);
        int[] max = new int[2];
        swap(envelopes[0], max);
        int result = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int[] temp = envelopes[i];
            if (temp[0] < min[0] && temp[1] < min[1]){
                result++;
                swap(temp, min);
                continue;
            }
            if (temp[0] > max[0] && temp[1] > max[1]) {
                result++;
                swap(temp, max);
                continue;
            }
        }
        return result;
    }

    private static void swap(int[] from, int[] target){
        for (int i = 0; i < from.length; i++) {
            target[i] = from[i];
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(solution(envelopes));
    }
}
