package my.day14.overloading;

public class Main {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Member mbr = new Member();
		mbr.id = "leess";
		mbr.name = "이순산";
		mbr.age = 25;
		mbr.height = 185.7;
		
		System.out.println(mbr.info()); //메서드의 오버로딩으로 같은이름의 메서드를 두개작성햇음
		System.out.println(mbr.info("emojh","엄정화",55,156.3d));
		
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int[] reverseArr = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			reverseArr[arr.length-1-i] = arr[i];
		}
		System.out.println(arr);
		System.out.println(reverseArr.toString());
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if (arr.length-i==1)
				System.out.println();
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(reverseArr[i]);
			if (arr.length-i==1)
				System.out.println();
		}

	}

}
