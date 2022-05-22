package com.amaderas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloDatos {

		private DataSource origenDatos;
		
		public ModeloDatos(DataSource origenDatos) {
			this.origenDatos=origenDatos;
		}
		
		public List<Datos> getDatos() throws Exception{
			
			Connection miConexion=null;
			
			Statement miSentencia=null;
			
			ResultSet mRs=null;
			
			List <Datos> listaRecibidos=new ArrayList<>();
			
			try {
				
				miConexion=origenDatos.getConnection();
				
				String consulta="SELECT *FROM LIBRODEOPERACIONES";
				
				miSentencia=miConexion.createStatement();
				
				mRs=miSentencia.executeQuery(consulta);
				
				while(mRs.next()) {
					

					Date Fecha=mRs.getDate(1);
					int nRemision=mRs.getInt(2);
					String procedencia=mRs.getString(3);
					String detalle=mRs.getString(4);
					int entradas=mRs.getInt(5);
					double transformacion=mRs.getDouble(6);
					String egresos=mRs.getString(7);
					double saldos=mRs.getDouble(8);
					String nComprador=mRs.getString(9);
					String nProveedor=mRs.getString(10);
					
				
					
					Datos datosRecibidos=new Datos(Fecha,nRemision,procedencia,detalle,entradas,transformacion,egresos,saldos,nComprador,nProveedor);
					
					System.out.println(datosRecibidos.toString());
					
					listaRecibidos.add(datosRecibidos);
					
					
				}
				
				
				
			}catch(Exception e) {
				System.out.println("No se pudo conectar");
			}
			return listaRecibidos;
		}

		public void AgregarNuevoRegistro(Datos nuevoRegistro) {
			// TODO Auto-generated method stub
			Connection conexionRegistro=null;
			
			PreparedStatement sentenciaPreparada =null;
			
			try {
				conexionRegistro=origenDatos.getConnection();
				
				String sql="INSERT INTO LIBRODEOPERACIONES(FECHA,NREMISIONICA,PROCEDENCIA,DETALLE,INGRESOSENTRADAS,TRANSFORMACION,EGRESOSSALIDAS,SALDOS,NOMBRECOMPRADOR,NOMBREDELPROVEEDOR) VALUES(?,?,?,?,?,?,?,?,?,? )";
				
				sentenciaPreparada=conexionRegistro.prepareStatement(sql);
				
				java.util.Date utilDate=nuevoRegistro.getFecha();
				java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
				sentenciaPreparada.setDate(1, fechaConvertida);
				sentenciaPreparada.setInt(2, nuevoRegistro.getRemision());
				sentenciaPreparada.setString(3, nuevoRegistro.getProcedencia() );
				sentenciaPreparada.setString(4, nuevoRegistro.getDetalle());
				sentenciaPreparada.setInt(5, nuevoRegistro.getEntradas());
				sentenciaPreparada.setDouble(6, nuevoRegistro.getTransformacion());
				sentenciaPreparada.setString(7, nuevoRegistro.getEgresos());
				sentenciaPreparada.setDouble(8, nuevoRegistro.getSaldos());
				sentenciaPreparada.setString(9, nuevoRegistro.getNombreComprador());
				sentenciaPreparada.setString(10, nuevoRegistro.getNombreProveedor());
				
				sentenciaPreparada.execute();
						
				
			}catch(Exception e) {
				System.out.println("Error al ingresar registro");
			}
			
			
		}

		public Datos ObtenerDatos(int nremision) {
			// TODO Auto-generated method stub
			
			Datos registroConsultado=null;
			
			Connection miConexion=null;
			
			PreparedStatement statement=null;
			
			ResultSet mRs=null;
			
			try {
			miConexion=origenDatos.getConnection();
			
			String sql="SELECT *FROM LIBRODEOPERACIONES WHERE NREMISIONICA=?";
			
			statement=miConexion.prepareStatement(sql);
			
			statement.setInt(1, nremision);
			
			mRs=statement.executeQuery();
			
			if(mRs.next()) {
				
				Date fecha=mRs.getDate(1);
				int Nremision=mRs.getInt(2);
				String procedencia=mRs.getString(3);
				String detalle=mRs.getString(4);
				int ingreso=mRs.getInt(5);
				double transformacion=mRs.getDouble(6);
				String egresosSalida=mRs.getString(7);
				double saldos=mRs.getDouble(8);
				String nombreComp=mRs.getString(9);
				String nombreProvee=mRs.getString(10);
				
				registroConsultado=new Datos(fecha,Nremision,procedencia,detalle,ingreso,transformacion,egresosSalida,saldos,nombreComp,nombreProvee);
			}else {
				
				throw new Exception("No se ha encontrado el registro con numero de ICA"+ nremision);
			}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return registroConsultado;
		}

		public void ActualizarRegistro(Datos datoActualizado) throws Exception{
			// TODO Auto-generated method stub
			
			Connection miConexion=null;
			
			PreparedStatement miConsulta=null;
			
			miConexion=origenDatos.getConnection();
			
			String sql="UPDATE LIBRODEOPERACIONES SET FECHA=?,PROCEDENCIA=?,DETALLE=?, INGRESOSENTRADAS=?,TRANSFORMACION=?,EGRESOSSALIDAS=?,"
					+ "SALDOS=?, NOMBRECOMPRADOR=?, NOMBREDELPROVEEDOR=? WHERE NREMISIONICA=?";
			
			miConsulta=miConexion.prepareStatement(sql);
			
			java.util.Date utilDate=datoActualizado.getFecha();
			java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
			miConsulta.setDate(1, fechaConvertida);
			miConsulta.setString(2, datoActualizado.getProcedencia());
			
			miConsulta.setString(3, datoActualizado.getDetalle());
			miConsulta.setInt(4, datoActualizado.getEntradas());
			miConsulta.setDouble(5,datoActualizado.getTransformacion());
			miConsulta.setString(6, datoActualizado.getEgresos());
			miConsulta.setDouble(7,datoActualizado.getSaldos());
			miConsulta.setString(8, datoActualizado.getNombreComprador());
			miConsulta.setString(9, datoActualizado.getNombreProveedor());
			
			miConsulta.setInt(10, datoActualizado.getRemision());
			
			miConsulta.execute();
			
			System.out.println("Actualizado correctamente");
			
			
		}

		public Datos BorrarDato(int nremision) throws Exception{
			// TODO Auto-generated method stub
			
			Connection miConexion=null;
			PreparedStatement consulta=null;
			
			miConexion=origenDatos.getConnection();
			
			String sql="DELETE FROM LIBRODEOPERACIONES WHERE NREMISIONICA=? ";
			
			consulta=miConexion.prepareStatement(sql);
			
			consulta.setInt(1, nremision);
			
			consulta.execute();
		
			return null;
		}
}
