package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Personaje;
import negocio.CtrlABMPersonaje;

/**
 * Servlet implementation class ElegirPersonaje
 */
@WebServlet("/ElegirPersonaje")
public class ElegirPersonaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ElegirPersonaje() {
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
		CtrlABMPersonaje ctrl = new CtrlABMPersonaje();
		int cod1;
		cod1=Integer.parseInt(request.getParameter("Personaje1"));
		int cod2;
		cod2=Integer.parseInt(request.getParameter("Personaje2"));
		//Personaje p1=ctrl.getPersonaje(cod1);
		//Personaje p2=ctrl.getPersonaje(cod2);
		Personaje p1=new Personaje();
		Personaje p2=new Personaje();
		p1.setCodigo(cod1);
		p1.setNombre("P1");

		p2.setCodigo(cod2);
		p2.setNombre("P2");

		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		request.getSession().setAttribute("Turno", 1);
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
		
	}

}
