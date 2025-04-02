package my.day07.a.twodimension.array;

import java.util.Scanner;
public class TwoDimensionMain2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentServiceLogic logic = new StudentServiceLogic();
		logic.start(sc);
		System.out.println("\n프로그램 종료 합니다\n");
	}
}
