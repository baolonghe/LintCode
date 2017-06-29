/**
 * 
 */
package DepthSearch;
import java.util.*;
/**
 *���ظ�Ԫ�ص�ȫ����
 *
 */
public class PermuteUnique {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
	    
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    
        if (nums == null) {
            return results;
        }
    
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
     
        helper(results, list, visited, nums);    
        return results;
    }
    
    
    public static void helper(ArrayList<ArrayList<Integer>> results, 
                   ArrayList<Integer> list, int[] visited, int[] nums) {
        
        if(list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
            && visited[i-1] == 0)){
                continue;
            }
            /*
            ������ж���Ҫ��Ϊ��ȥ���ظ�Ԫ��Ӱ�졣
            ���磬����һ���ź�������飬[1,2,2]����ô��һ��2�͵ڶ�2����ڽ���л���λ�ã�
            ����Ҳ��Ϊ��ͬһ�ַ�������������ǿ��Ҫ����ͬ�����֣�ԭ������ǰ��ģ��ڽ��
            ����ҲӦ������ǰ�棬�����ͱ�֤��Ψһ�ԡ����Ե�ǰ���2��û��ʹ�õ�ʱ�򣬾�
            ��Ӧ���ú����2ʹ�á�
            */
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
     } 

	public static void main(String [] args){
		int [] nums=new int[]{1,2,2,3,4};
		ArrayList<ArrayList<Integer>> show=new ArrayList<ArrayList<Integer>>();
		show=permuteUnique(nums);
		for(int i=0;i<show.size();i++)
		{
			for(int in:show.get(i))
			{
				System.out.print(in+" ");
			}
			System.out.println();
		}
	}

}
