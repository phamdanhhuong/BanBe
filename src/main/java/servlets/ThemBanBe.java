package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BanBeDao;

/**
 * Servlet implementation class ThemBanBe
 */
@WebServlet("/them")
public class ThemBanBe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemBanBe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		BanBeDao.themBan(hoVaTen, sdt, email, linkSocial, diaChi);
		response.sendRedirect("/BanBe/ds");
	}

}
