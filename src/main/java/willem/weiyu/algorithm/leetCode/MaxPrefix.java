package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/07 11:58
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 */
public class MaxPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder pre = new StringBuilder();
        if (strs.length == 0){
            return pre.toString();
        }
        if (strs.length==1){
            return pre.append(strs[0]).toString();
        }
        for(int i=0; i< strs.length;i++){
            for(int j = i+1; j< strs.length;j++){
                char[] arr = strs[i].toCharArray();
                char[] arr2 = strs[j].toCharArray();
                StringBuilder tempStr = new StringBuilder();
                int size = arr.length >= arr2.length? arr2.length:arr.length;
                for(int k= 0; k< size; k++){
                    char temp = arr[k];
                    char temp2 = arr2[k];
                    if(temp != temp2){
                        break;
                    }
                    tempStr.append(temp);
                }
                if(pre.length()< tempStr.length()){
                    pre = tempStr;
                }
            }
        }
        return pre.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc","b","ab"};
        System.out.println(longestCommonPrefix(strings));
    }
}
