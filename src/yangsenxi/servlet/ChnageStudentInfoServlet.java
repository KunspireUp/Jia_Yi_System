package yangsenxi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yangsenxi.dao.CURE_Mysql;

/**
 * Servlet implementation class ChnageStudentInfoServlet
 */
public class ChnageStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChnageStudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String st_sno = request.getParameter("st_sno");
		String st_name = request.getParameter("st_name");
		String st_classz =request.getParameter("st_classz");
		String  st_chinese = request.getParameter("st_chinese");
		String st_math =request.getParameter("st_math");
		String st_english =request.getParameter("st_english");
		String st_physics =request.getParameter("st_physics");
		String st_chemistry =request.getParameter("st_chemistry");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("st_sno",st_sno);
		session.setAttribute("st_name",st_name);
		session.setAttribute("st_classz",st_classz);
		session.setAttribute("st_chinese",st_chinese);
		session.setAttribute("st_math",st_math);
		session.setAttribute("st_english",st_english);
		session.setAttribute("st_physics",st_physics);
		session.setAttribute("st_chemistry",st_chemistry);
		//System.out.println(st_sno);
		int snos = Integer.parseInt(st_sno);
		int sts_chinese = Integer.parseInt(st_chinese);
		int sts_math = Integer.parseInt(st_math);
		int sts_english = Integer.parseInt(st_english);
		int sts_physics = Integer.parseInt(st_physics);
		int sts_chemistry = Integer.parseInt(st_chemistry);
		
		//修改操作
		boolean flag = CURE_Mysql.changeUserPassword(st_name, st_classz, sts_chinese, sts_math, sts_english, sts_physics, sts_chemistry,snos);
		//System.out.println(flag);
		if(flag == true) {
			System.out.println("修改成功");
			request.getRequestDispatcher("/user/showchangestudent.jsp").forward(request, response);//再次跳转到当前界面，将数据显示到 JSP 页面上面
		}else {
			System.out.println("修改失败");
			request.getRequestDispatcher("/user/findstudent.jsp").forward(request, response);//再次跳转到当前界面，将数据显示到 JSP 页面上面
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
