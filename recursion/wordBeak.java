import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
		ArrayList<String> res = new ArrayList<String>();
		String tempS="";
		word(0,s,dictionary,res,tempS);
		return res;
	}
	public static void word(int ind,String s,ArrayList<String> dick,ArrayList<String> res,String tempS){
		if(ind>=s.length()){
			res.add(tempS);
			return;
		}
		
		for(int i=ind;i<s.length();i++){
			if(dick.contains(s.substring(ind,i+1))){
				word(i+1,s,dick,res,tempS+s.substring(ind,i+1)+" ");
			}
		}
		return;
	}
}