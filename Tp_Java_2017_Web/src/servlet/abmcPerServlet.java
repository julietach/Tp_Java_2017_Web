package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCPersona;
import entity.Persona;

/**
 * Servlet implementation class abmcPerServlet
 */
@WebServlet({ "/persona/*", "/Persona/*", "/PERSONA/*" })
public class abmcPerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public abmcPerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			request.setAttribute("persona", pers);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Consulta, requested action: ").append(request.getPathInfo()).append(" through post");
		//en lugar del response.getWriter usar el forward del ejemplo de start / welcome
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
		//CtrlABMCPersona ctrl = (CtrlABMCPersona)request.getSession().getAttribute("ctrl");
		  try {
			    CtrlABMCPersona ctrl= new CtrlABMCPersona();
			    Persona per=new Persona();
				per.setDni(request.getParameter("dni"));
				per.setNombre(request.getParameter("nombre"));
				per.setApellido(request.getParameter("apellido"));
				per.setEmail(request.getParameter("email"));
				int id_cat=Integer.parseInt(request.getParameter("categoria"));
				per.setCategoria(ctrl.getById(id_cat));
				per.setHabilitado(request.getParameter("habilitado").equals("on"));
				per.setUsuario(request.getParameter("usuario"));
				per.setContraseña(request.getParameter("contraseña"));
				/*
				 * 1- guardar la categoria id en una variabe
				 * 2- buscar la categoria de ese id mediante un controlador getById
				 * 3- guardar el objeto categoria recuperado en per con setCategoria 
				 */
				//select
				//checkbox
				//user,pass
				//categoria
				ctrl.add(per);
				//tratar de poner cartel
				response.getWriter().append("Alta, requested action: ").append(request.getPathInfo()).append(" through post");
		  }
	      catch (Exception e) {
			e.printStackTrace();
		   }
		
		//crear el controlador y ejecutar el new/add
	}


}