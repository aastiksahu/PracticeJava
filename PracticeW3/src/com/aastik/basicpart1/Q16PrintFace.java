package com.aastik.basicpart1;

public class Q16PrintFace {
	
	public static void main(String[] args) {
		 
		//Print Face Using Array
		String[] arra = new String[5];
			arra[0] ="   +\"\"\"\"\"\"+ " ; 
			arra[1] ="  [| o   o|]  " ;
			arra[2] ="   |   ^  |    ";
			arra[3] ="   |  '_' |    ";
			arra[4] ="   +------+    ";
			
			for (int i = 0; i < arra.length; i++) {
				System.out.println(arra[i]);
			}
	}

}
