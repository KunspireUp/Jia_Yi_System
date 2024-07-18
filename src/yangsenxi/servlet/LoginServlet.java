package yangsenxi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import yangsenxi.dao.CURE_Mysql;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String sno = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
    	session.setAttribute("sno", sno);
    	session.setAttribute("password", password);
        String sql = "select * from tb_users where sno=? and password=?";
        //查询 sno 对应的 role 用户然后跳转到对应的界面
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8", "root", "root");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sno);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                String role = CURE_Mysql.searchRole(sno);
                String name = CURE_Mysql.searchName(sno);
                session.setAttribute("name", name);
				// System.out.println(role);
                if(role.equals("学生")) {
                	request.getRequestDispatcher("/login/loginsucessStudent.jsp").forward(request, response);
                }else {
                	request.getRequestDispatcher("/login/loginsucessTeacher.jsp").forward(request, response);
				}   
            }else {
				out.print("<script>alert('登陆失败，用户名或密码有误！');</script>");
				out.print("<script>window.location.href = '" + request.getContextPath() + "/login.jsp';</script>");
			}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
