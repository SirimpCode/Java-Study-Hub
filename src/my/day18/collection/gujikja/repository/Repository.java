//package my.day18.collection.gujikja.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import my.day18.collection.gujikja.controller.CommonController;
//
//public class Repository {
//
//	private List<CommonMember> mbrList = new ArrayList<>();
//	private List<Recruit> rcList = new ArrayList<>();
//	private List<RecruitApply> rcApplyList = new ArrayList<>();
//	
//	public List<CommonMember> getMbrList() {
//		return mbrList;
//	}
//	public List<Recruit> getRcList() {
//		return rcList;
//	}
//	public List<RecruitApply> getRcApplyList() {
//		return rcApplyList;
//	}
//	
//
//	public void createDummyData(CommonController ctrl) {
//		// ================================= //
//
//		Gujikja gu1 = new Gujikja();
//		gu1.setId("eomjh");
//		gu1.setPasswd("Qwer1234$");
//		gu1.setName("엄정화");
//		gu1.setJubun("8610202");
//		this.mbrList.add(gu1);
//
//		Gujikja gu2 = new Gujikja();
//		gu2.setId("leess");
//		gu2.setPasswd("Abcd12345$");
//		gu2.setName("이순신");
//		gu2.setJubun("8604011");
//		this.mbrList.add(gu2);
//
//		Gujikja gu3 = new Gujikja();
//		gu3.setId("chaew");
//		gu3.setPasswd("Wxyz1234$");
//		gu3.setName("차은우");
//		gu3.setJubun("0106053");
//		this.mbrList.add(gu3);
//		// ================================= //
//
//		Company cp1 = new Company();
//		cp1.setId("samsung");
//		cp1.setPasswd("Abcd1234$");
//		cp1.setName("삼성");
//		cp1.setBusiness_number("8123456789");
//		cp1.setJob_type("제조업");
//		cp1.setSeed_money(80000000000L);
//		CommonController.addMember(cp1);
//
//		Company cp2 = new Company();
//		cp2.setId("lg");
//		cp2.setPasswd("Abcd0070$");
//		cp2.setName("엘지");
//		cp2.setBusiness_number("7123456789");
//		cp2.setJob_type("IT");
//		cp2.setSeed_money(70000000000L);
//		CommonController.addMember(cp2);
//
//		// ================================= //
//
//		Recruit rc1 = new Recruit();
//		rc1.setCp(cp1);
//		rc1.setSubject("성실한 사무직원을 채용합니다.");
//		rc1.setWork_type("정규사무직");
//		rc1.setCnt(2);
//		rc1.setYearpay(4000);
//		rc1.setFinish_day("20250508");
//		rcList.add(rc1);
//
//		Recruit rc2 = new Recruit();
//		rc2.setCp(cp2);
//		rc2.setSubject("우수한 기술직원을 채용합니다.");
//		rc2.setWork_type("계약직(2년)");
//		rc2.setCnt(5);
//		rc2.setYearpay(4500);
//		rc2.setFinish_day("20250608");
//		rcList.add(rc2);
//
//		Recruit rc3 = new Recruit();
//		rc3.setCp(cp2);
//		rc3.setSubject("참신한 영업직원을 채용합니다.");
//		rc3.setWork_type("정규직");
//		rc3.setCnt(10);
//		rc3.setYearpay(5000);
//		rc3.setFinish_day("20250708");
//		rcList.add(rc3);
//
//		// ================================= //
//
//		RecruitApply rcapply1 = new RecruitApply();
//		rcapply1.setRc(rc1);
//		rcapply1.setGu(gu1);
//		rcapply1.setApply_motive("엄정화는 사무에 최선을 다합니다.");
//		rcApplyList.add(rcapply1);
//
//		RecruitApply rcapply2 = new RecruitApply();
//		rcapply2.setRc(rc1);
//		rcapply2.setGu(gu2);
//		rcapply2.setApply_motive("이순신은 최고의 사무직 인재입니다.");
//		rcApplyList.add(rcapply2);
//
//		RecruitApply rcapply3 = new RecruitApply();
//		rcapply3.setRc(rc2);
//		rcapply3.setGu(gu3);
//		rcapply3.setApply_motive("차은우는 최고의 기술을 가진 엔지니어 입니다.");
//		rcApplyList.add(rcapply3);
//
//		RecruitApply rcapply4 = new RecruitApply();
//		rcapply4.setRc(rc3);
//		rcapply4.setGu(gu1);
//		rcapply4.setApply_motive("엄정화는 영업의 달인 입니다.");
//		rcApplyList.add(rcapply4);
//
//		RecruitApply rcapply5 = new RecruitApply();
//		rcapply5.setRc(rc3);
//		rcapply5.setGu(gu2);
//		rcapply5.setApply_motive("이순신은 판매왕 입니다.");
//		rcApplyList.add(rcapply5);
//
//		// ================================= //
//	}
//}
