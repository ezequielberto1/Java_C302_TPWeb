package servlets;

import java.io.IOException;
import java.util.Random;

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
		Random rn = new Random();
		int cod1=Integer.parseInt(request.getParameter("Personaje1"));
		int cod2=Integer.parseInt(request.getParameter("Personaje2"));
		
		Personaje p1=ctrl.getPersonaje(cod1);
		if(p1!=null){
			System.out.println("entra 1");
			p1.setEnergiaPartida(p1.getEnergia());
			p1.setVidaPartida(p1.getVida());
		}
		else
			System.out.println("null");
			//notificar que no se encontró personaje. No seguir ejecutando el codigo que sigue debajo.
		Personaje p2=ctrl.getPersonaje(cod2);
		if(p2!=null){
			p2.setEnergiaPartida(p2.getEnergia());
			p2.setVidaPartida(p2.getVida());
		}
		else
			System.out.println("null");
			//notificar que no se encontró personaje. No seguir ejecutando el codigo que sigue debajo.



		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		request.getSession().setAttribute("gano", false);
		request.getSession().setAttribute("errorEnergia", false);
		request.getSession().setAttribute("turno", rn.nextInt(2) + 1);
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
		
	}

}
