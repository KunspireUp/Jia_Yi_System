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
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePwdServlet() {
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
		String change_user = request.getParameter("change_user");
		String new_password = request.getParameter("new_userpassword");
		String re_password = request.getParameter("re_password");
		String option_value_change = request.getParameter("option_value_change");
		HttpSession session = request.getSession();//获取Session值
		session.setAttribute("change_user", change_user);
		session.setAttribute("new_password", new_password);
		//这里切记一定要记得创建session，不然获取不到session的数据
		//System.out.println(change_user);
		//System.out.println(new_password);
		if (change_user == "" || new_password == "" || re_password == "") {
			out.print("<script>alert('有部分选项为空，请填写');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/changepassword.jsp';</script>");
		}  else if (change_user.length() >= 15 && option_value_change.equals("1")) {
			out.print("<script>alert('学号过长！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/changepassword.jsp';</script>");
		} else if (change_user.length() >= 6 && option_value_change.equals("2")) {
			out.print("<script>alert('姓名过长！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/changepassword.jsp';</script>");
		}else if (!new_password.equals(re_password)) {
			out.print("<script>alert('两次密码不一致');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/changepassword.jsp';</script>");
			//out.print("<script>window.location.href = '" + request.getContextPath() + "/change/changepassword.jsp';</script>");
		} else {
			session.setAttribute("option_value_change", option_value_change);
			//System.out.println(option_value);


			if (option_value_change.equals("1")) {
				int change_users = Integer.parseInt(change_user);
				//System.out.println(change_users);
				boolean subimt = CURE_Mysql.changeUserPassword(new_password, change_users);
				//System.out.println(subimt);
				if (subimt == true) {
					request.getRequestDispatcher("/change/changepwdsucess.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/change/changepassworderror.jsp").forward(request, response);
				}
			} else {
				boolean subimt1 = CURE_Mysql.changeNamePassword(new_password, change_user);
				//System.out.println(subimt1);
				if (subimt1 == true) {
					request.getRequestDispatcher("/change/changepwdsucess.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/change/changepassworderror.jsp").forward(request, response);
				}
			}
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
