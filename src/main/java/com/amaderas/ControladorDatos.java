package com.amaderas;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorDatos
 */
public class ControladorDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloDatos modeloD;
	
	@Resource (name="jdbc/Productos")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			modeloD=new ModeloDatos(miPool);
			
		}catch(Exception e) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//listando productos
		
		List<Datos> listaQueRecibe;
		
		try {
			listaQueRecibe=modeloD.getDatos();
			
			request.setAttribute("lista_datos", listaQueRecibe);
			
			RequestDispatcher miDespachador=request.getRequestDispatcher("/ListaDatos.jsp");
			
			miDespachador.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}

}
