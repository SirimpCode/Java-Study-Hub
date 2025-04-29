package my.day17.a.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
=== Map 계열 ===
1. HashMap 과 Hashtable 이 있다.
2. Map 계열은 List 계열(Vector, ArrayList, LinkedList)처럼 index 가 사용되어 저장되는 것이 아니라, 
   Map 계열은 key값과 value값을 쌍으로 사용하여 저장하는데  
   데이터 저장시 사용되는 메소드는 put(String key, Object value)메소드를 사용한다.
   이때 key값은 반드시 고유한 값을 가져야 하고, value값은 중복된 값이 와도 괜찮다.
3. Map 계열에 저장된 key값들은 순서와는 상관없이 저장된다.  
4. Map 계열에 저장된 value값을 추출하려면 key를 이용해서 가져오는데 
   value 값의 추출은 get(String key) 메소드를 사용한다. 
*/
public class HashMapMain5 {
	
	public static void main(String[] args) {
		List<Member> mbrList = new ArrayList<>();
		mbrList.addAll(List.of(
				 Member.startBuilder().id("youjs").passwd("Qwer1234$").name("유재석").jubun("7209101").build(), 
				 Member.startBuilder().id("eom").passwd("Qwer1234$").name("엄정화").jubun("6808152").build(), 
				 Member.startBuilder().id("kanghd").passwd("Qwer1234$").name("강호동").jubun("7006151").build(), 
				 Member.startBuilder().id("leess").passwd("Qwer1234$").name("이순신").jubun("0010203").build(),
				 Member.startBuilder().id("kimth").passwd("Qwer1234$").name("김태희").jubun("0105064").build(), 
				 Member.startBuilder().id("kangkc").passwd("Qwer1234$").name("강감찬").jubun("9812301").build(),
				 Member.startBuilder().id("kimss").passwd("Qwer1234$").name("김순신").jubun("0203203").build()));
		Map<String, Member> mbrMap = new HashMap<>();
//		HashMap<String, Member> oldMbrMap = new HashMap<>();//jdk 8 이전방식
		// Member 클래스의 객체 7개를 생성하여 mbrMap 에 저장한다.
		mbrList.forEach(m -> mbrMap.put(m.getId(), m));
		
		mbrList.forEach(mbr->mbr.printInfo());//순서 확인해보기 Map<String, Member> mbrMap = new LinkedHashMap<>();//이건 순서 보장됨.
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		mbrMap.forEach((k, v) -> System.out.println(k + " : " + v.getInfo()));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println(mbrMap.get("kangkc").getInfo());
		mbrMap.put("kangkc", Member.startBuilder().id("kangkc").passwd("Qwer1234$").name("강기춘").jubun("9812301").build());		
		System.out.println(mbrMap.get("kangkc").getInfo());// 강기춘으로 바뀜 key값 중복되면 덮어 씌워진다.
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		mbrMap.putIfAbsent("seolh", Member.startBuilder().id("seolh").passwd("Qwer1234$").name("설현").jubun("0212304").build());
		mbrMap.get("seolh").printInfo();
		mbrMap.putIfAbsent("seolh", Member.startBuilder().id("seolh").passwd("Qwer1234$").name("서리혜").jubun("0212304").build());
		mbrMap.get("seolh").printInfo();
		/*
		default V putIfAbsent(K key, V value) { putIfAbsent 의 메서드 내용 해당 키값의 value가 null 일때만 put을 시도하고 아닐땐 그냥 그 키값의 value를 리턴한다. 교체 되지않음!! 
        V v = get(key);
        if (v == null) {
            v = put(key, value);
        }

        return v;
    	}*/
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		//맵은 중복 되더라도 키값만 다르면 저장이 가능하다.
		Member mem1 = Member.startBuilder().id("seolh").passwd("Qwer1234$").name("서리혜").jubun("0212304").build();
		mbrMap.put(mem1.getId(), mem1);
		mbrMap.put("test", mem1);
		mbrMap.put("test2", mem1);
		mbrMap.forEach((k, v) ->{
			if(k.equals("test")|| k.equals("test2")|| k.equals("seolh")) {
				System.out.println(k + " : " + v.getInfo());
			}
		});//키값이 다르기때문에 다들어감
		mbrMap.get("test").setName("개명햇져");
		mbrMap.forEach((k, v) ->{
			if(k.equals("test")|| k.equals("test2")|| k.equals("seolh")) {
				System.out.println(k + " : " + v.getInfo());
			}
		});//키값이 다르지만 value는 같기때문에 위에서 setName으로 바뀐게 3개 다바뀜
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (String key : mbrMap.keySet()) {// keySet() 메서드는 Map 에 저장된 모든 key 값들을 Set 으로 리턴한다.
			System.out.println(key + " : " + mbrMap.get(key).getInfo());
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Set<String> keySet = mbrMap.keySet();
		
		System.out.println("\n== [퀴즈] mbr_map 에 아래와 같이 새로운 회원을 가입하시는데 아이디가 중복이라면 '아이디가 이미 사용중입니다.' 라는 메시지를 출력해주고 아이디가 중복이 아니라면 mbr_map 에 저장하도록 하세요..");
		
		Member m1 = Member.startBuilder().id("seolh2").passwd("Qwer1234$").name("서리혜").jubun("0212304").build();
		
		Member addMem = mbrMap.putIfAbsent(m1.getId(), m1);
		
		if(addMem != null) 
			System.out.println(">> "+m1.getId()+" 아이디가 \""+addMem.getName()+"\" 이 사람이 이미 사용중입니다.<<");
		else {
			System.out.println(">> "+m1.getId()+" 가 가입 되었습니다.");
			System.out.println(mbrMap.get(m1.getId()).getInfo());
		}
		
//		HashMapMain5 에 저장되어진 모든 keySet 들을 읽어오는 세번째방법
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		Set<String> keySet3 =  mbrMap.keySet();
		Iterator<String> iterator = keySet3.iterator();
		System.out.println(keySet.size() + " 개의 keySet 이 있습니다.");
		while(iterator.hasNext()) {//다음값이 존재하면 true 없으면 false
			/*현재 키의 개수만큼 반복을 할거다.
			 iterator.hasNext() 메서드는 Iterator 에 저장된 요소가 있는지 없는지를 판단하는 메서드이다.
			 iterator.next() 메서드는 Iterator 에 저장된 요소를 하나씩 읽어오는 메서드이다.
			 iterator.remove() 메서드는 Iterator 에 저장된 요소를 삭제하는 메서드이다.
			 */
			// 꺼내진 키 값은 iterator에 남아있지 않고, iterator.next() 메서드로 꺼내진 키 값은 iterator 에서 삭제된다.
			System.out.println(iterator.next());
		}
		System.out.println("\n또한번더!!!!!\n");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());			// 안나옴
		}
		System.out.println("\n다시처음부터\n");
		iterator = keySet3.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		System.out.println("\n mbrMap 에서 key값이 leess 인 회원을 삭제하세요.\n");
		Member mem = mbrMap.remove("leess");//remove() 메서드는 key값을 이용하여 Map 에서 해당 key값과 value 값을 삭제하는 메서드이다.
		if(mem != null) 
			System.out.println(">> "+mem.getId()+" 회원이 삭제 되었습니다.");
		mbrMap.clear();//clear() 메서드는 Map 에 저장된 모든 key 값과 value 값을 삭제하는 메서드이다.
		System.out.println(mbrMap.isEmpty() ? ">> mbrMap 이 비어있습니다." : ">> mbrMap 이 비어있지 않습니다.");
	}
}
