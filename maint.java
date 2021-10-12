package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class maint{// mysql 연결하기 위한 클래스
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school_information?chracterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root"; // mysql아이디
	static final String PASSWORD = "dhsmf"; // mysql비번
	private Connection connection;
	private DBM dbm;
		
	public static Connection makeConnection() { //db 커넥션 객체 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
			System.exit(1);
		}
		return conn;
	}
		
	public maint() {// 테스트용 생성자
		connection = makeConnection(); //커넥션 생성
		dbm=new DBM(connection);//db 커넥션 객체 전달, 모든 쿼리문은 DBM에서 작동하게 함
		
		// 예시
		//dbm.sl_search("5700"); //강의실 서치하여 출력 입력내용 : 강의실번호 // 서치 내용 바꿀수있음
		//int a = dbm.sl_ap("60000005", "5700");// 강의실 예약자 등록 입력내용 : 학생번호, 강의실번호
		//System.out.println(a); // 입력성공하면 1// 입력성공테스트
		//dbm.sl_search("5700"); // 입력성공확인 출력
		
		//int c = dbm.newstudent("차요한", "60142342", "1234");// 학생정보등록
		//System.out.println(c);
		//int b=dbm.login("60142342", "1234");// 로그인
		//System.out.println(b);// 출력이 1이면 성공, 0이면 비번틀림, -1이면 아이디 없음, -2면 db오류
		
		//dbm.lib_search("1"); // 1번자리 확인
		//int d = dbm.lib_ap("60142342", "010000", "3");// 학생번호, 시간(시분초), 자리번호
		//System.out.println(d);// 성공하면 1
		
		//dbm.allroom();//강의실 전체출력
		//dbm.all_library();// 도서관 전체출력
		//dbm.allstudent();// 학생정보 전체출력
	}
		
	
	public static void main(String[] args) {
		new maint(); 
	}
}
