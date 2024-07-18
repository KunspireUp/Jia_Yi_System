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
 * Servlet implementation class FindStudent
 */
public class FindStudentShowChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindStudentShowChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String sh_sno = request.getParameter("sh_sno");

		HttpSession session = request.getSession();
		session.setAttribute("sh_sno", sh_sno);
		//System.out.println(sh_sno);
		// 执行查询的 SQL 语句
		List<String> list = new ArrayList<>();
		list = CURE_Mysql.findStudent(sh_sno);
		if(list.isEmpty()) {
			request.getRequestDispatcher("/user/findstudent.jsp").forward(request, response);//再次跳转到当前界面，将数据显示到 JSP 页面上面
		}
		//System.out.println(list);
		
		sno = list.get(0);
		name = list.get(1);
		classz = list.get(2);
		chinese = list.get(3);
		math = list.get(4);
		english = list.get(5);
		physics = list.get(6);
		chemistry = list.get(7);
		
		/*System.out.println(sno);
		System.out.println(name);
		System.out.println(classz);
		System.out.println(chinese);
		System.out.println(math);
		System.out.println(english);
		System.out.println(physics);
		System.out.println(chemistry);*/
		
		session.setAttribute("st_sno", sno);
		session.setAttribute("st_name", name);
		session.setAttribute("st_classz", classz);
		session.setAttribute("st_chinese", chinese);
		session.setAttribute("st_math", math);
		session.setAttribute("st_english", english);
		session.setAttribute("st_physics", physics);
		session.setAttribute("st_chemistry", chemistry);

		
		request.getRequestDispatcher("/user/studentshow_change.jsp").forward(request, response);//再次跳转到当前界面，将数据显示到 JSP 页面上面

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
