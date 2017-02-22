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
 * Servlet implementation class Defensa
 */
@WebServlet("/Defensa")
public class Defensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Defensa() {
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
		
		
		
		
		int personajeActivo=Integer.parseInt(request.getParameter("personajeActivo"));
		int energiaRecuperada;
		int vidaRecuperada;

		
		if (personajeActivo==1)
		{
			Personaje p1= (Personaje)request.getSession().getAttribute("P1");
			
			energiaRecuperada = p1.getEnergia()*p1.getDefensa()/100;
			vidaRecuperada = p1.getVida()*p1.getDefensa()/250;
			
			if((p1.getEnergiaPartida()+energiaRecuperada)<=p1.getEnergia())
				p1.setEnergiaPartida(p1.getEnergiaPartida()+energiaRecuperada);
			else
				p1.setEnergiaPartida(p1.getEnergia());
			if((p1.getVidaPartida()+vidaRecuperada)<=p1.getVida())
				p1.setVidaPartida(p1.getVidaPartida()+vidaRecuperada);
			else
				p1.setVidaPartida(p1.getVida());
			
			request.getSession().setAttribute("turno", 2);
		}
		else
		{
			Personaje p2= (Personaje)request.getSession().getAttribute("P2");	
			
			energiaRecuperada = p2.getEnergia()*p2.getDefensa()/100;
			vidaRecuperada = p2.getVida()*p2.getDefensa()/250;
			
			if((p2.getEnergiaPartida()+energiaRecuperada)<=p2.getEnergia())
				p2.setEnergiaPartida(p2.getEnergiaPartida()+energiaRecuperada);
			else
				p2.setEnergiaPartida(p2.getEnergia());
			if((p2.getVidaPartida()+vidaRecuperada)<=p2.getVida())
				p2.setVidaPartida(p2.getVidaPartida()+vidaRecuperada);
			else	
				p2.setVidaPartida(p2.getVida());
			
			request.getSession().setAttribute("turno", 1);
			
		}	
		request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
	}
	
	
}
