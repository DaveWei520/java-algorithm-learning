package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/09 21:00
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水
 *
 */
public class No11 {

    /**
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     * 空间复杂度：O(1)，只需要额外的常数级别的空间
     * @param arr
     * @return
     */
    public static int solution(int[] arr){
        if (arr.length<2){
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        int area = 0;
        while (start < end){
            int height = Math.min(arr[start],arr[end]);
            int weight = end - start;
            int temp = height * weight;
            area = area < temp? temp:area;
            if (height == arr[start]){
                start++;
            } else {
                end--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution(arr));
    }
}
