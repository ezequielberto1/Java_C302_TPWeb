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
 * Servlet implementation class Ataque
 */
@WebServlet("/Ataque")
public class Ataque extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public Ataque() {
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
		int personajeActivo, ptosAtaque;
		Personaje p1= (Personaje)request.getSession().getAttribute("P1");
		Personaje p2= (Personaje)request.getSession().getAttribute("P2");
		Random rn = new Random();
		personajeActivo=Integer.parseInt(request.getParameter("personajeActivo"));

		ptosAtaque=Integer.parseInt(request.getParameter("ptosAtaque"));

		if (personajeActivo==1) {
			if (p1.getEnergiaPartida() >= ptosAtaque) {
				request.getSession().setAttribute("errorEnergia", false);
				p1.setEnergiaPartida(p1.getEnergiaPartida()-ptosAtaque);

				if (p2.getEvasion()<=(rn.nextInt(100) + 1))
				{
					if (p2.getVidaPartida() < ptosAtaque || p2.getVidaPartida() == 0)
					{
						request.getSession().setAttribute("gano", true);
						//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);

					}
					else
					{					
						p2.setVidaPartida(p2.getVidaPartida()-ptosAtaque);
						request.getSession().setAttribute("P1", p1);
						request.getSession().setAttribute("P2", p2);
						
						//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
					}

				}
				request.getSession().setAttribute("turno", 2);
			}
			else
			{
				request.getSession().setAttribute("errorEnergia", true);
				//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
			}
			request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
		}

		else
		{
			if (p2.getEnergiaPartida() >= ptosAtaque) {
				request.getSession().setAttribute("errorEnergia", false);
				p2.setEnergiaPartida(p2.getEnergiaPartida()-ptosAtaque);

				if (p1.getEvasion()<=(rn.nextInt(100) + 1))
				{
					if (p1.getVidaPartida() < ptosAtaque || p1.getVidaPartida() == 0)
					{
						request.getSession().setAttribute("gano", true);
						//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);

					}
					else
					{
						p1.setVidaPartida(p1.getVidaPartida()-ptosAtaque);	
						request.getSession().setAttribute("P1", p1);
						request.getSession().setAttribute("P2", p2);
						//request.getSession().setAttribute("turno", 1);
						//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
					}

				}
				request.getSession().setAttribute("turno", 1);
			}
			else
			{
				request.getSession().setAttribute("errorEnergia", true);
				//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
			}
			request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
		}


		//request.getSession().setAttribute("P1", p1);
		//request.getSession().setAttribute("P2", p2);
		//response.sendRedirect("WEB-INF/war.jsp");
		//request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
		//response.sendRedirect("Java_C302_TPWeb/Ataque");

	}

}
