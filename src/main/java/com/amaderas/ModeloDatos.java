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
			
			try {
				conexionRegistro=origenDatos.getConnection();
				
				CallableStatement sentenciaPreparada =conexionRegistro.prepareCall("{call nuevo_registro(?,?,?,?,?,?,?,?,?,?)}");
				
				sentenciaPreparada.setDate(1, (java.sql.Date) nuevoRegistro.getFecha());
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
}
