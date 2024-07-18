package yangsenxi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yangsenxi.dao.CURE_Mysql;

/**
 * 找回密码的 Servlet
 *
 * @author 杨森喜
 * @学号： 0411200429
 */
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FindPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getPassword = null;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String find_user = request.getParameter("find_user");
		String option_value_find = request.getParameter("option_value_find");
		//System.out.println(find_user);
		session.setAttribute("find_user", find_user);
		session.setAttribute("option_value_find", option_value_find);
		System.out.println(find_user.length());

		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		Boolean isNumber = pattern.matcher(find_user).matches();
		System.out.println(find_user + "" + option_value_find);
		if(find_user == "" && option_value_find.equals("1")){
			out.print("<script>alert('请输入查询的学号！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		} else if (find_user == "" && option_value_find.equals("2")) {
			out.print("<script>alert('请输入查询的姓名！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		} else if(!isNumber && option_value_find.equals("1")) {
			out.print("<script>alert('请输入学号，汉字请选择姓名查询！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		}else if (find_user.length() >= 15 && option_value_find.equals("1")) {
			out.print("<script>alert('学号过长！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		} else if (option_value_find.equals("2") && find_user.length() >= 15) {
			out.print("<script>alert('用户不存在！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		} else if (option_value_find.equals("1")) {
			//用户是整形，需要转换
			int user_find_int = Integer.parseInt(find_user);
			getPassword = CURE_Mysql.findPassword(user_find_int);
		} else {
			getPassword = CURE_Mysql.findNamePassword(find_user);
		}
		if (getPassword == null) {
			out.print("<script>alert('没有找到该用户！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/findpassword.jsp';</script>");
		} else {
			//System.out.println(getPassword);
			session.setAttribute("getPassword", getPassword);//将获得的密码存入到 session 中
			session.setAttribute("find_user", find_user);//再次将输入框中的内容存入到 session 中
			request.getRequestDispatcher("/change/findpasswordshow.jsp").forward(request, response);//再次跳转到当前界面，将数据显示到 JSP 页面上面
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
