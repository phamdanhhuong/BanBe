package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BanBe;
import dao.BanBeDao;

/**
 * Servlet implementation class Sua
 */
@WebServlet("/sua")
public class Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BanBe item = BanBeDao.getBanBe(id); 
		request.setAttribute("item", item);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hoVaTen = request.getParameter("hoVaTen");
		int sdt = Integer.parseInt(request.getParameter("sdt"));
		String email = request.getParameter("email");
		String linkSocial = request.getParameter("linkSocial");
		String diaChi = request.getParameter("diaChi");
		int id = Integer.parseInt(request.getParameter("id"));
		BanBeDao.suaBan(hoVaTen, sdt, email, linkSocial, diaChi, id);
		response.sendRedirect("/BanBe/ds");
	}

}
