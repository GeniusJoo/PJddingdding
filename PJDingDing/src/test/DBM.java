package test;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DBM {
	private PreparedStatement classroom_search =null;
	private PreparedStatement cl_appointment =null;
	private PreparedStatement student_in=null;
	private PreparedStatement student_out=null;
	private PreparedStatement library_search=null;
	private PreparedStatement library_se=null;
	private PreparedStatement library_user=null;
	private Statement state =null;

	public DBM(Connection connection) {
		try {
			classroom_search = connection.prepareStatement("SELECT classroom_id, classroom_appointment FROM school_information.classroom WHERE classroom_id = ?;"); // 교실찾기 쿼리문
			cl_appointment=connection.prepareStatement("UPDATE school_information.classroom SET classroom_appointment = ? WHERE classroom_id = ?;"); // 교실 예약자 변경 쿼리문
			student_in=connection.prepareStatement("INSERT INTO school_information.student(student_name, student_id, student_password)  VALUES(?, ?, ?);"); // 학생정보등록쿼리문
			student_out=connection.prepareStatement("SELECT student_password FROM school_information.student WHERE student_id=?;"); // 학생정보 확인 쿼리문
			library_search=connection.prepareStatement("SELECT library_id, library_user, Reservation_time FROM school_information.library WHERE library_id = ?;"); // 도서실자리 확인 쿼리문
			library_se=connection.prepareStatement("SELECT library_user FROM school_information.library WHERE library_id = ?;"); // 도서실사람 있는지 쿼리문
			library_user=connection.prepareStatement("UPDATE school_information.library SET library_user = ? , Reservation_time = ? WHERE library_id = ?;"); // 도서실 자리 예약자 변경 쿼리문
			state=connection.createStatement();
		} catch (SQLException sqlException) {
			sqlException.getStackTrace();
			//System.exit(1);
		}
	}
	
	public void sl_search(String a) {// 교실찾기
		try {
			classroom_search.setString(1, a);
			ResultSet resultSet=classroom_search.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString("classroom_id");
				String appointment=resultSet.getString("classroom_appointment");
				System.out.print(name+" ");
				System.out.println(appointment);
			}
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		} 
	}
	
	public int sl_ap(String a, String b) { // 교실 예약자 변경 
		int result =0;
		try {
			cl_appointment.setString(1, a);
			cl_appointment.setString(2, b);
			result = cl_appointment.executeUpdate();
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		}
		return result;
	}
	
	public int newstudent(String a, String b, String c) { // 새로운 학생등록 (그냥 만듬 필요없으면 삭제)
		int result =0;
		try {
			student_in.setString(1, a);
			student_in.setString(2, b);
			student_in.setString(3, c);
			result = student_in.executeUpdate();
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		}
		return result;
	}
	
	public int login(String id, String Password) {// 로그인
		try { 	
			student_out.setString(1, id);
			ResultSet resultSet=student_out.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString(1).contentEquals(Password)) {
					return 1; // 로그인성공
				}else {
					return 0; // 비밀번호 틀림
				}
			}
			return -1; //아이디없음
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		} 
		return -2;// DB 오류
	}
	
	public void lib_search(String a) {// 도서실자리찾기
		try {
			library_search.setString(1, a);
			ResultSet resultSet=library_search.executeQuery();
			
			while(resultSet.next()) {
				String name=resultSet.getString("library_id");
				String appointment=resultSet.getString("library_user");
				String time=resultSet.getString("Reservation_time");
				System.out.print(name+" ");
				System.out.print(appointment+" ");
				System.out.println(time);
			}
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		} 
	}
	
	public int lib_se(int s) {// 도서실사람 있는지
		int num=0;
		try {
			library_se.setInt(1, s);
			ResultSet resultSet = library_se.executeQuery();
			resultSet.next();
			num=resultSet.getInt(1);
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		}
		return num;
	}
	
	public int lib_ap(String a, String b, String c) { // 교실 예약자 변경 
		int result =0;
		try {
			library_user.setString(1, a); // 예약자번호
			library_user.setString(2, b); // 예약시간
			library_user.setString(3, c); // 자리번호
			result = library_user.executeUpdate();
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
		}
		return result;
	}
	
	public void allroom(){// 강의실 전체 출력용 (나중에 수정할 예정)
		String a ="Select * FROM school_information.classroom;";
		try {
			ResultSet rs = state.executeQuery(a);
			while(rs.next()) {
				String name=rs.getString("classroom_id");
				String appointment=rs.getString("classroom_appointment");
				System.out.print(name+" ");
				System.out.println(appointment);
			}
		} catch (SQLException sqlException) {
			sqlException.getStackTrace();
		}
	}
	
	public void allstudent(){// 학생 전체 출력용 (나중에 수정할 예정)
		String a ="Select * FROM school_information.student;";
		try {
			ResultSet rs = state.executeQuery(a);
			while(rs.next()) {
				String name=rs.getString("student_name");
				String id=rs.getString("student_id");
				String pass=rs.getString("student_password");
				System.out.print(name+" ");
				System.out.print(id+" ");
				System.out.println(pass);
			}
		} catch (SQLException sqlException) {
			sqlException.getStackTrace();
		}
	}
	
	public void all_library(){// 도서관 전체 출력용 (나중에 수정할 예정)
		String a ="Select * FROM school_information.library;";
		try {
			ResultSet rs = state.executeQuery(a);
			while(rs.next()) {
				String id=rs.getString("library_id");
				String user=rs.getString("library_user");
				String time=rs.getString("Reservation_time");
				System.out.print(id+" ");
				System.out.print(user+" ");
				System.out.println(time);
			}
		} catch (SQLException sqlException) {
			sqlException.getStackTrace();
		}
	}
	
	
	
}
