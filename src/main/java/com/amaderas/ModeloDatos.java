package com.amaderas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
			
			List <Datos> listaRecibidos=null;
			
			try {
				
				miConexion=origenDatos.getConnection();
				
				String consulta="SELECT *FROM LIBRO DE OPERACIONES";
				
				miSentencia=miConexion.createStatement();
				
				mRs=miSentencia.executeQuery(consulta);
				
				while(mRs.next()) {
					
					Date Fecha=mRs.getDate("FECHA");
					int nRemision=mRs.getInt("N REMISION ICA");
					String procedencia=mRs.getString("PROCEDENCIA");
					String detalle=mRs.getString("DETALLE");
					int entradas=mRs.getInt("INGRESOS/ENTRADAS");
					double transformacion=mRs.getDouble("TRANSFORMACION");
					String egresos=mRs.getString("EGRESOS/SALIDAS");
					double saldos=mRs.getDouble("SALDOS");
					String nComprador=mRs.getString("NOMBRE COMPRADOR");
					String nProveedor=mRs.getString("NOMBRE DEL PROVEEDOR");
					
					Datos datosRecibidos=new Datos(Fecha,nRemision,procedencia,detalle,entradas,transformacion,egresos,saldos,nComprador,nProveedor);
					
					listaRecibidos.add(datosRecibidos);
					
					
				}
				
				
				
			}catch(Exception e) {
				
			}
			return listaRecibidos;
		}
}
