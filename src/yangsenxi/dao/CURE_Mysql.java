package yangsenxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

import yangsenxi.util.JDBCDurid;
import yangsenxi.util.JDBCUtils;

/**
 * @name 数据库基本操作
 * @author 杨森喜
 * @学号 0411200429
 */
public class CURE_Mysql {

    /**
     * @name 利用用户名查找用户身份
     * @param value 用户名
     * @return role 用户身份
     */
    public static String searchRole(String value) {
    	Connection conn = null;
    	Statement stmt = null;
		String role = null;
		int sno_id = Integer.parseInt(value);
		//连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			stmt = conn.createStatement();
			//创建查询用户的 sql 语句
			String sql = "select role from tb_users where sno = " + sno_id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				role = rs.getString("role");
			}
			JDBCUtils.close(conn, stmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return role;	
	}
    
    /**
     * @name 利用用户名查找姓名
     * @param value 用户名
     * @return name 姓名
     */
    public static String searchName(String value) {
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
		String name = null;
		int sno_id = Integer.parseInt(value);
		//连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			stmt = conn.createStatement();
			//创建查询用户的 sql 语句
			String sql = "select name from tb_users where sno = " + sno_id + ";";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				name = rs.getString("name");
			}
			JDBCUtils.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
		//返回
		
	}
    
    /**
     * @name 创建新的学生用户
     * @param value1 学号
     * @param value2 学生密码
     * @param value3 学生姓名
     * @param value4 学生身份
     * @return list 对象List
     */
    public static List<Object> insertUser(int value1, String value2, String value3, String value4) {
		Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();
		//将传入的字符串转换为整形，菜呢在 SQL 语句中操作
		//int sno_id = Integer.parseInt(value1);
		//连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			//创建插入新用户的 sql 语句
			String sql = "insert into tb_users (sno,password,name,role) values (?,?,?,?);";
			pr = conn.prepareStatement(sql);//调用 prepareStatement 对象
			pr.setInt(1, value1);
			pr.setString(2, value2);
			pr.setString(3, value3);
			pr.setString(4, value4);
			int i = pr.executeUpdate();
			if(i > 0) {
				System.out.println("数据插入数据库成功");
			}else {
				System.out.println("数据插入数据库失败");
			}
			list.add(value1);
			list.add(value2);
			list.add(value3);
			list.add(value4);
			JDBCUtils.close(conn, pr, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		//返回
		
	}
    
    /**
     * @name 教师页面添加学生信息
     * @param sno 学号
     * @param name 姓名
     * @param classz 班级
     * @param chinese 语文成绩
     * @param math 数学成绩
     * @param english 英语成绩
     * @param physics 物理成绩
     * @param chemistry 化学成绩
     * @return list 对象List
     */
    public static List<Object> insertStudent(String sno, String name, String classz, int chinese, int math, int english, int physics, int chemistry) {
		Connection conn = null;
		PreparedStatement pr = null;
		PreparedStatement pr1 = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		// 将传入的字符串转换为整形，菜呢在 SQL 语句中操作
		// int sno_id = Integer.parseInt(value1);
		// 连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			// 创建插入新用户的 sql 语句
			String sql = "insert into tb_source (sno,name,classz,chinese,math,english,physics,chemistry) values (?,?,?,?,?,?,?,?);";
			pr = conn.prepareStatement(sql);// 调用 prepareStatement 对象
			int sno_int = Integer.parseInt(sno);
			pr.setInt(1, sno_int);
			pr.setString(2, name);
			pr.setString(3, classz);
			pr.setInt(4, chinese);
			pr.setInt(5, math);
			pr.setInt(6, english);
			pr.setInt(7, physics);
			pr.setInt(8, chemistry);
			int i = pr.executeUpdate();
			if (i > 0) {
				System.out.println("添加学生成绩成功");
			} else {
				System.out.println("添加学生成绩失败");
			}
			String sql1 = "insert into tb_users (sno,password,name,role) values (?,?,?,?);";
			pr1 = conn.prepareStatement(sql1);
			int sno_int1 = Integer.parseInt(sno);
			pr1.setInt(1,sno_int1);
			pr1.setString(2, sno);
			pr1.setString(3,name);
			pr1.setString(4,"学生");
			int m = pr1.executeUpdate();
			if (m > 0) {
				System.out.println("添加学生账号成功");
			} else {
				System.out.println("添加学生账号失败");
			}
			list.add(sno);
			list.add(name);
			list.add(classz);
			list.add(chinese);
			list.add(math);
			list.add(english);
			list.add(physics);
			list.add(chemistry);
			JDBCUtils.close(conn, pr);
			JDBCUtils.close(conn, pr1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		// 返回

	}
    
    /**
     * @name 利用用户找回密码
     * @param value1 用户号
     * @return password 密码
     */
    public static String findPassword(int value1) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String password = null;//用于存取获得密码
		try {
			conn = JDBCUtils.getConn();
			// 创建查询密码的 sql 语句
			String sql = "select password from tb_users where sno = " + value1 + ";";
			stmt = conn.createStatement();//查询第一步
			rs =stmt.executeQuery(sql);//查询第二步
			while(rs.next()) {
				password = rs.getString("password");
			}
			JDBCUtils.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
		// 返回

	}
    
    /**
     * @name 利用姓名找回密码
     * @param value1 用户姓名
     * @return password
     */
    public static String findNamePassword(String value1) {
		Connection conn = null;
		PreparedStatement pr_stmt = null;
		ResultSet rs = null;
		String password = null;//用于存取获得密码
		try {
			conn = JDBCUtils.getConn();
			// 创建查询密码的 sql 语句
			String sql = "SELECT password from tb_users where name = ?;";//
			pr_stmt = conn.prepareStatement(sql);
			pr_stmt.setString(1, value1);
			rs = pr_stmt.executeQuery();
			while(rs.next()) {
				password = rs.getString("password");
			}
			JDBCUtils.close(conn, pr_stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
		// 返回

	}
    
    /**
     * @name 查找学生信息
     * @param value1 学号
     * @return list 字符List
     */
    public static List<String> findStudent(String value1) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int value_int = Integer.parseInt(value1);
		List<String> list = new ArrayList<>();
		try {
			conn = JDBCUtils.getConn();
			// 创建查询密码的 sql 语句
			String sql = "select * from tb_source where sno = " + value1 + ";";
			stmt = conn.createStatement();//查询第一步
			rs =stmt.executeQuery(sql);//查询第二步
			while(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				
			}
			System.out.println(list);
			JDBCUtils.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		// 返回

	}
    
    /**
     * @name 删除学生信息
     * @param value1 学号
     * @return flag 布尔类型
     */
    public static boolean deleteStudent(int value1) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pr,pr1 = null;
		String password = null;//用于存取获得密码
		try {
			conn = JDBCUtils.getConn();
			// 创建查询密码的 sql 语句
			String sql = "delete from tb_source where sno = ?;";//
			String sql1 = "delete from tb_users where sno = ?;";//"
			pr = conn.prepareStatement(sql);
			pr1 = conn.prepareStatement(sql1);
			pr.setInt(1, value1);
			pr1.setInt(1,value1);
			int i = pr.executeUpdate();
			int m = pr1.executeUpdate();
			if(i > 0 && m >0) {
				System.out.println("删除成功");
				flag = true;
			}else {
				System.out.println("删除失败");
			}
			JDBCUtils.close(conn, pr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		// 返回

	}
    
    /**
     * @name 使用用户号修改密码
     * @param value1 密码
     * @param value2 用户号
     * @return flag 布尔类型
     */
    public static boolean changeUserPassword(String value1, int value2) {
		//注意 value1 代表的是修改的密码，value2 代表的是修改的用户名
		//这里的位置相反，因此传入值的时候需要注意是相反传值
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		// 将传入的字符串转换为整形，菜呢在 SQL 语句中操作
		// int sno_id = Integer.parseInt(value1);
		// 连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			// 创建插入新用户的 sql 语句
			String sql = "update tb_users set password = ? where sno = ?;";//使用用户名修改密码
			pr = conn.prepareStatement(sql);// 调用 prepareStatement 对象
			pr.setString(1, value1);
			pr.setInt(2, value2);
			int i = pr.executeUpdate();
			if (i > 0) {
				System.out.println("数据修改数据库成功");
				flag = true;
			} else {
				System.out.println("数据修改数据库失败");
			}
			JDBCUtils.close(conn, pr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		// 返回

	}
    
    /**
     * @name 利姓名修改密码
     * @param value1 密码
     * @param value2 姓名
     * @return flag 布尔类型
     */
    public static boolean changeNamePassword(String value1, String value2) {
		//注意 value1 代表的是修改的密码，value2 代表的是修改的名字
		//这里的位置相反，因此传入值的时候需要注意是相反传值
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		// 将传入的字符串转换为整形，菜呢在 SQL 语句中操作
		// int sno_id = Integer.parseInt(value1);
		// 连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			// 创建插入新用户的 sql 语句
			String sql = "update tb_users set password = ? where `name` = ?;";//使用用户名修改密码
			pr = conn.prepareStatement(sql);// 调用 prepareStatement 对象
			pr.setString(1, value1);
			pr.setString(2, value2);
			int i = pr.executeUpdate();
			if (i > 0) {
				System.out.println("数据修改数据库成功");
				flag = true;
			} else {
				System.out.println("数据修改数据库失败");
			}
			JDBCUtils.close(conn, pr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		// 返回

	}
    
    /**
     * @name 修改学生信息
     * @param value 学号
     * @param value1 姓名
     * @param value2 班级
     * @param value3 语文
     * @param value4 数学
     * @param value5 英语
     * @param value6 物理
     * @param value7 化学
     * @return flag 布尔类型
     */
    public static boolean changeUserPassword(String value, String value1, int value2, int value3, int value4, int value5, int value6, int value7) {
		//注意 value1 代表的是修改的密码，value2 代表的是修改的用户名
		//这里的位置相反，因此传入值的时候需要注意是相反传值
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		// 将传入的字符串转换为整形，菜呢在 SQL 语句中操作
		// int sno_id = Integer.parseInt(value1);
		// 连接数据库驱动
		try {
			conn = JDBCUtils.getConn();
			// 创建插入新用户的 sql 语句
			String sql = "update tb_source set name = ?, classz = ?, chinese = ?, math = ?, english = ?, physics = ?, chemistry = ?  where sno = ?;";//使用用户名修改密码
			pr = conn.prepareStatement(sql);// 调用 prepareStatement 对象
			pr.setString(1, value);
			pr.setString(2, value1);
			pr.setInt(3, value2);
			pr.setInt(4, value3);
			pr.setInt(5, value4);
			pr.setInt(6, value5);
			pr.setInt(7, value6);
			pr.setInt(8, value7);
			int i = pr.executeUpdate();
			if (i > 0) {
				System.out.println("数据修改数据库成功");
				flag = true;
			} else {
				System.out.println("数据修改数据库失败");
			}
			JDBCUtils.close(conn, pr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		// 返回

	}
    
    
    
    
}
