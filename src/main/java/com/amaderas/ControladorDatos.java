package com.amaderas;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorDatos
 */
public class ControladorDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloDatos modeloD;
	
	@Resource (name="jdbc/Datos")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			modeloD=new ModeloDatos(miPool);
			
		}catch(Exception e) {
			throw new ServletException();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Leer el parametro que llega del formulario
		
		String orden=request.getParameter("registra");
		System.out.println(orden);
		if(orden==null) orden="listar";
		
		switch (orden) {
		
		case("listar"):
			ConsultarRegistros(request, response);
			break;
		
		case("insertarEnBBDD"):
			IngresarRegistro(request, response);
			break;
			
		case("cargar"):
			try {
				CargaRegistro(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case("actualizarBBDD"):
			try {
				ActualizarRegistro(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		
		}
		
		
	}

	private void CargaRegistro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int Nremision=Integer.parseInt(request.getParameter("NRemision"));
		
		Datos elDato=modeloD.ObtenerDatos(Nremision);
		
		request.setAttribute("RegistroActualizar", elDato);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/ActualizarRegistro.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void ActualizarRegistro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat formatoF=new SimpleDateFormat("YYYY-MM-dd");
		Date fecha=null;
		try {
			fecha=formatoF.parse(request.getParameter("textFecha"));
		}catch(Exception e) {
			System.out.println("Fecha nula");
		}
		int numeroIca;
		if(request.getParameter("textRemi")!=null && request.getParameter("textRemi").length()>0) {
			numeroIca=Integer.parseInt(request.getParameter("textRemi"));
		}else {
			numeroIca=0000;
		}
		
		String procedencia=request.getParameter("textProce");
		String detalle=request.getParameter("textDetalle");
		int ingresosEntrada;
		if(request.getParameter("textEntrada")!=null && request.getParameter("textEntrada").length()>0) {
			ingresosEntrada=Integer.parseInt(request.getParameter("textEntrada"));
		}else {
			ingresosEntrada=0;
		}
		double transformacion;
		if(request.getParameter("textTransfo")!=null && request.getParameter("textTransfo").length()>0) {
			transformacion=Double.parseDouble(request.getParameter("textTransfo"));
		}else {
			transformacion=0;
		}
		String egresoSalidas=request.getParameter("textEgresos");
		double saldos;
		if(request.getParameter("textSaldos")!=null && request.getParameter("textSaldos").length()>0) {
			saldos=Double.parseDouble(request.getParameter("textSaldos"));
		}else {
			saldos=0;
		}
		String nombreComprador =request.getParameter("textComprador");
		String nombreProveedor=request.getParameter("textProveedor");
		
		Datos datoActualizado= new Datos(fecha, numeroIca, procedencia, detalle, ingresosEntrada, transformacion, egresoSalidas, saldos,nombreComprador, nombreProveedor);
		
		modeloD.ActualizarRegistro(datoActualizado);
		
		ConsultarRegistros(request, response);
		
		
	}

	private void IngresarRegistro(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//Leer informacion recibida por formulario
		System.out.println("ingreso a resgistro");
		
		Date fecha=null;
		
		SimpleDateFormat formatoF=new SimpleDateFormat("YYYY-MM-dd");
		
		try {
			fecha=formatoF.parse(request.getParameter("textFecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problema en fecha");
		}
		int numeroRemision=Integer.parseInt(request.getParameter("textRemi"));
		String procedencia=request.getParameter("textProce");
		String detalle=request.getParameter("textDetalle");
		int ingresos=Integer.parseInt(request.getParameter("textEntrada"));
		double transformacion=Double.parseDouble(request.getParameter("textTransfo"));
		String egresos=request.getParameter("textEgresos");
		double saldos=Double.parseDouble(request.getParameter("textSaldos"));
		String nombreComp=request.getParameter("textComprador");
		String nombreProveedor=request.getParameter("textProveedor");
		
		
		Datos nuevoRegistro=new Datos(fecha,numeroRemision,procedencia,detalle,ingresos,transformacion,egresos,saldos,nombreComp,nombreProveedor);
		
		modeloD.AgregarNuevoRegistro(nuevoRegistro);
		
		ConsultarRegistros(request, response);
		
	}

	private void ConsultarRegistros(HttpServletRequest request, HttpServletResponse response) {
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
