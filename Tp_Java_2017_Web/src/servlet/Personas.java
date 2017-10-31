/*package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controlers.*;
import entity.*;
import util.*;
/**
 * Servlet implementation class Personas
 */
/*@WebServlet({ "/persona/*", "/Persona/*", "/PERSONA/*"  })
public class Personas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet() 
     */
/*    public Personas() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getPathInfo()).append(" through post");
		switch (request.getPathInfo()) {
		case "/alta":
			this.alta(request,response);
			break;
			
		case "/baja":
			this.baja(request,response);
			break;
			
		case "/modificacion":
			this.modificacion(request,response);
			break;
			
		case "/consulta":
			this.consulta(request,response);
			break;

		default:
			this.error(request,response);
			break;
		}
	}

	private void error(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(404);
		//redirigir a página de error
	}

	private void consulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 try {
				String dni=request.getParameter("dni");
				Persona per=new Persona();
				per.setDni(dni);
				CtrlABMCPersona ctrl= new CtrlABMCPersona();
				Persona pers=ctrl.getByDni(per);
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		response.getWriter().append("Consulta, requested action: ").append(request.getPathInfo()).append(" through post");
		//crear el controlador y ejecutar el getOne o getById
	}

	private void modificacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Modificación, requested action: ").append(request.getPathInfo()).append(" through post");
		//crear el controlador y ejecutar el modificar/update
	}

	private void baja(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("baja, requested action: ").append(request.getPathInfo()).append(" through post");
		//crear el controlador y ejecutar el delete/remove
	}

	private void alta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CtrlABMCPersona ctrl = (CtrlABMCPersona)request.getSession().getAttribute("ctrl");
		  try {
			  Persona per=new Persona();
				per.setDni(request.getParameter("dni"));
				per.setNombre(request.getParameter("nombre"));
				per.setApellido(request.getParameter("apellido"));
				per.setEmail(request.getParameter("mail"));
				//select
				//checkbox
				//user,pass
				//categoria
				//CtrlABMCPersona ctrl= new CtrlABMCPersona();
				ctrl.add(per);
				//tratar de poner cartel
				
		  }
	      catch (Exception e) {
			e.printStackTrace();
		   }
		response.getWriter().append("Alta, requested action: ").append(request.getPathInfo()).append(" through post");
		//crear el controlador y ejecutar el new/add
	}

}

		//agregar
		/*try {
			/*String dni=request.getParameter("dni");
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			String email=request.getParameter("email");*/
	        //Boolean habilitado=request.getParameter("habilitado");
			//Categoria
			
		/*	Persona per=new Persona();
			per.setDni(request.getParameter("dni"));
			per.setNombre(request.getParameter("nombre"));
			per.setApellido(request.getParameter("apellido"));
			per.setEmail(request.getParameter("mail"));
			
			CtrlABMCPersona ctrl= new CtrlABMCPersona();
			ctrl.add(per);
			request.getSession().setAttribute("PER", per);
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			//tratar de poner cartel
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}
		
		/*buscar
		try {
			String dni=request.getParameter("dni");
			Persona per=new Persona();
			per.setDni(dni);
			CtrlABMCPersona ctrl= new CtrlABMCPersona();
			Persona pers=ctrl.getByDni(per);
			request.getSession().setAttribute("user", pers);
			request.getRequestDispatcher("WEB-INF/persona.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}*/
	
	

//}