package com.exam.student;

public class StudentVo {
	//문자열3개 + 정수열1개를 갖고있는 클래스를 생성
	private String Stuno;
	private String Stuname;
	private int Stuscore;
	//우클릭 -> source -> getters & setters ->캡슐화
	public String getStuno() {
		return Stuno;
	}
	public void setStuno(String stuno) {
		Stuno = stuno;
	}
	public String getStuname() {
		return Stuname;
	}
	public void setStuname(String stuname) {
		Stuname = stuname;
	}
	public int getStuscore() {
		return Stuscore;
	}
	public void setStuscore(int stuscore) {
		Stuscore = stuscore;
	}
	
	
//	public void setMemId(String id) {
//		this.memId = id;
//		//캡슐화 : 직접 변수에 값을 입력할 수 없지만, 메서드를 이용하여 변수입력 가능하게 만들어준다.
//		//변수의 이름을 감추고 유효한값인지 확인하고 입력하게 만들수있다.
//	}
//	
//	public String getMemId( ) {
//		return this.memId;
//		//set이 입력을 한다면 get은 입력된 값을 가져와 읽는다.
//	}
	
	
}
//private는 한 클래스 안에서만 사용이 가능하기때문에
//private를 작성한다면 작성되어있는 다른 클래스는 오류가 난다
//기본적으로 private를 작성해 다른클래스에서의 접근을 막고,
//사용할 수 있는 메서드를 따로 제작을 한다.


//여러개의 데이터를 작성하려고할 때 
//클래스를 새로생성하여 하나의 그룹을 만들어준다.