package my.day17.a.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
== HashSet == 
1. 출력시 저장된 순서가 유지되지 않는다.
2. 중복된 데이터를 저장할 수 없다.
   그러므로 Collection 내의 중복된 요소들을 저장하지 않고자 할때 많이 사용된다.
          
== LinkedHashSet ==
1. 출력시 저장된 순서가 유지된다.
2. 중복된 데이터를 저장할 수 없다.
   그러므로 Collection 내의 중복된 요소들을 저장하지 않고자 할때 많이 사용된다.        
*/
public class SetMain6 {
	public static void main(String[] args) {
		System.out.println("\n === HashSet === \n");

		// Member 클래스의 객체만을 저장할 수 있는 HashSet 객체 mbr_set 을 생성한다.
		Set<Member> mbrSet = new HashSet<>();

		// Member 클래스의 객체를 mbr_set 에 저장한다.
		mbrSet.add(new Member("youjs", "Qwer1234$", "유재석", "7209101"));
		mbrSet.add(new Member("eom", "Qwer1234$", "엄정화", "6808152"));
		mbrSet.add(new Member("kanghd", "Qwer1234$", "강호동", "7006151"));
		mbrSet.add(new Member("leess", "Qwer1234$", "이순신", "0010203"));
		mbrSet.add(new Member("kimth", "Qwer1234$", "김태희", "0105064"));
		mbrSet.add(new Member("kimth", "Qwer1234$", "김태희", "0105064"));

		Member mbr1 = new Member("sammj", "Qwer1234$", "삼미자", "0101013");
		Member mbr2 = mbr1;
		mbr2.setName("미자삼");// mbr1과 mbr2는 같은 객체를 참조하고 있다. 둘이 같이 바뀜
		mbrSet.add(mbr1);
		mbrSet.add(mbr2); // 중복된 데이터를 저장할 수 없다.

		Iterator<Member> itr = mbrSet.iterator();
		while (itr.hasNext()) {
			// itr.hasNext() 은
			// itr 에서 현재 itr가 가지고 있는 여러 Member 데이터중
			// 하나를 끄집어내서 존재하는지를 알아보는 것이다.
			// 존재하면 true, 존재하지 않으면 false.
			Member mbr = itr.next();
			System.out.println(mbr.getInfo());
		}

		System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		// mbrSet 에 저장된 Member 객체들 중에서 id가 "kimth" 인 객체만 정보를 출력해본다.
		mbrSet.forEach(mbr -> {
			if (mbr.getId().equals("kimth"))
				System.out.println(mbr.getInfo());
		});
		System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~스트림~~~~~~~~~~~~~~~~~~~~~~~ \n");
		mbrSet.stream().filter(mbr -> mbr.getId().equals("kimth")).forEach(mbr -> mbr.printInfo());

//	      mbrSet 에 저장되어진 Member 객체들 중에서 id 값이 "kimth" 인 객체를 삭제해본다.
		mbrSet.removeIf(mbr -> mbr.getId().equals("kimth"));
		System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		
		itr = mbrSet.iterator();
		while (itr.hasNext()) {
			Member mbr = itr.next();
			if("kimth".equals(mbr.getId())) {
				itr.remove();
			}
		}

	}
}
