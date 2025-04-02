package my.day07.a.twodimension.array;

import java.util.Objects;

public class TwoDemensionArrayMain3 {

	public static void main(String[] args) {
		int[][] num_arr = new int[4][];  // 4행 null열
		
		num_arr[0][0] = 10;
	    num_arr[0][1] = 20;
	    num_arr[0][2] = 30;
	      
	    num_arr[1][0] = 40;
	    num_arr[1][1] = 50;
	    num_arr[1][2] = 60;
	    //널포인트익셉션 터짐
	    
	    num_arr[0] = new int[3];  // 0행은 3열로 설정함.
	      num_arr[1] = new int[2];  // 1행은 2열로 설정함.
	      num_arr[2] = new int[4];  // 2행은 4열로 설정함.
	      num_arr[3] = new int[3];  // 3행은 3열로 설정함.
	      //빈공간들은 기본값으로 초기화된다. ex ) int = 0
	      
	      num_arr[0][0] = 10;
	      num_arr[0][1] = 20;
	      num_arr[0][2] = 30;
	      

	      num_arr[0][0] = 10;
	      num_arr[0][1] = 20;
	      num_arr[0][2] = 30;
	      num_arr[1][0] = 10;
	      num_arr[1][1] = 20;
	      num_arr[1][2] = 30;
	      //어레이 아웃오브바운드 익셉션 터짐
	      
	      for(int i=0; i<num_arr.length; i++) {
	    	  for(int j=0; j<num_arr[i].length; j++) {
	    		  String add = j<num_arr[i].length-1 ? "," : "\n";
	    		  System.out.printf("%2d%s",num_arr[i][j], add);
	    	  }
	      }
	      
	      System.out.println("\n------------------------------------------------------------------------------------------------------------------\n");
	      int[][] numArr = {{10,20,30},
	    		  {40,50},
	    		  {60,70,80,90},
	    		  {0,}};// 열 개수가 똑같을 필요는 없다.
	      
	      for(int i=0; i<numArr.length; i++) {
	    	  for(int j=0; j<numArr[i].length; j++) {
	    		  String add = j<numArr[i].length-1 ? "," : "\n";
	    		  System.out.printf("%2d%s",numArr[i][j], add);
	    	  }
	      }
	      
	}

}
