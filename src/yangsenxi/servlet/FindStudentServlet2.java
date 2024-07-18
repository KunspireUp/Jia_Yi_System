package yangsenxi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import yangsenxi.dao.CURE_Mysql;

/**
 * Servlet implementation class FindStudentServlet2
 */
public class FindStudentServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindStudentServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno;
		String name;
		String classz;
		String chinese;
		String math;
		String english;
		String physics;
		String chemistry;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String st_del_sno = request.getParameter("st_del_sno");

		HttpSession session = request.getSession();
		if(st_del_sno.length() >= 15){
			out.print("<script>alert('学号过长！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/user/findstudent_del.jsp';</script>");
		}else {
			session.setAttribute("st_del_sno", st_del_sno);
			// 执行查询的 SQL 语句
			List<String> list = CURE_Mysql.findStudent(st_del_sno);
			if(list == null || list.size() < 8) { // 添加对列表大小的检查
				out.print("<script>alert('没有找到这个学生！');</script>");
				out.print("<script>window.location.href = '" + request.getContextPath() + "/user/findstudent_del.jsp';</script>");
			} else {
				sno = list.get(0);
				name = list.get(1);
				classz = list.get(2);
				chinese = list.get(3);
				math = list.get(4);
				english = list.get(5);
				physics = list.get(6);
				chemistry = list.get(7);

				session.setAttribute("st_sno", sno);
				session.setAttribute("st_name", name);
				session.setAttribute("st_classz", classz);
				session.setAttribute("st_chinese", chinese);
				session.setAttribute("st_math", math);
				session.setAttribute("st_english", english);
				session.setAttribute("st_physics", physics);
				session.setAttribute("st_chemistry", chemistry);

				request.getRequestDispatcher("/user/showdeletestudent.jsp").forward(request, response); // 再次跳转到当前界面，将数据显示到 JSP 页面上面
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
