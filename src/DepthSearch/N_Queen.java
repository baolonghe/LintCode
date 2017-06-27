/**
 * 
 */
package DepthSearch;
import java.util.*;
/**
 * 
 *
 */
public class N_Queen {
	ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        if (n==0) return results;
        //用来存储前面每一行的皇后的列信息
        ArrayList<Integer> cols=new ArrayList<Integer>();
        helper（
}
private void helper(int n,ArrayList<ArrayList<String>> results,
		ArrayList<Integer> cols)
{
	if(cols.size()==n)
		{
		results.add(dressChessBoard(cols));
	    return ;
		}
	for(int i=0;i<n;i++)
	{
		if (!isValid(cols,i)) continue;
		cols.add(i);
		helper(n,results,cols);
		cols.remove(cols.size()-1);
		
	}
	
}
private ArrayList<String> dressChessBoard(ArrayList<Integer> cols){
	ArrayList<String> chessboard = new ArrayList<>();
    for (int i = 0; i < cols.size(); i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols.size(); j++) {
            sb.append(j == cols.get(i) ? 'Q' : '.');
        }
        chessboard.add(sb.toString());
    }
    return chessboard;
		
}
		
private boolean isValid(ArrayList<Integer> cols,int col){
	int row=cols.size();//表示当前行
	for(int rowIndex=0;rowIndex<cols.size();rowIndex++){
		if(col-cols.get(rowIndex)==row-rowIndex) return false;
		if(col+row==cols.get(rowIndex)+rowIndex) return false;
		if(col==cols.get(rowIndex)) return false;
	    return true;
	}
	return true;
}
}