package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class maint{// mysql �����ϱ� ���� Ŭ����
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school_information?chracterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root"; // mysql���̵�
	static final String PASSWORD = "dhsmf"; // mysql���
	private Connection connection;
	private DBM dbm;
		
	public static Connection makeConnection() { //db Ŀ�ؼ� ��ü ����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
			System.exit(1);
		}
		return conn;
	}
		
	public maint() {// �׽�Ʈ�� ������
		connection = makeConnection(); //Ŀ�ؼ� ����
		dbm=new DBM(connection);//db Ŀ�ؼ� ��ü ����, ��� �������� DBM���� �۵��ϰ� ��
		
		// ����
		//dbm.sl_search("5700"); //���ǽ� ��ġ�Ͽ� ��� �Է³��� : ���ǽǹ�ȣ // ��ġ ���� �ٲܼ�����
		//int a = dbm.sl_ap("60000005", "5700");// ���ǽ� ������ ��� �Է³��� : �л���ȣ, ���ǽǹ�ȣ
		//System.out.println(a); // �Է¼����ϸ� 1// �Է¼����׽�Ʈ
		//dbm.sl_search("5700"); // �Է¼���Ȯ�� ���
		
		//int c = dbm.newstudent("������", "60142342", "1234");// �л��������
		//System.out.println(c);
		//int b=dbm.login("60142342", "1234");// �α���
		//System.out.println(b);// ����� 1�̸� ����, 0�̸� ���Ʋ��, -1�̸� ���̵� ����, -2�� db����
		
		//dbm.lib_search("1"); // 1���ڸ� Ȯ��
		//int d = dbm.lib_ap("60142342", "010000", "3");// �л���ȣ, �ð�(�ú���), �ڸ���ȣ
		//System.out.println(d);// �����ϸ� 1
		
		//dbm.allroom();//���ǽ� ��ü���
		//dbm.all_library();// ������ ��ü���
		//dbm.allstudent();// �л����� ��ü���
	}
		
	
	public static void main(String[] args) {
		new maint(); 
	}
}
