package yangsenxi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yangsenxi.dao.CURE_Mysql;

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String st_del_sno = request.getParameter("st_del_sno");

		HttpSession session = request.getSession();
		// 执行查询的 SQL 语句
		int sts_sno = Integer.parseInt(st_del_sno);
		boolean flag = CURE_Mysql.deleteStudent(sts_sno);
		if(flag) {
			request.setAttribute("st_del_sno", sts_sno);
			out.print("<script>alert('删除成功！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/deletesucess.jsp';</script>");
		}else {
			request.setAttribute("st_del_sno", sts_sno);
			out.print("<script>alert('删除失败！');</script>");
			out.print("<script>window.location.href = '" + request.getContextPath() + "/change/deleteerror.jsp';</script>");
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
