package com.amaderas;

import java.util.Date;

public class Datos {
	
	private Date fecha;
	private int remision;
	private String procedencia;
	private String detalle;
	private int entradas;
	private double transformacion;
	private String egresos;
	private double saldos;
	private String nombreComprador;
	private String nombreProveedor;
	
	
	
	public Datos(Date fecha, int remision, String procedencia, String detalle, int entradas, double transformacion,
			String egresos, double saldos, String nombreComprador, String nombreProveedor) {
		this.fecha = fecha;
		this.remision = remision;
		this.procedencia = procedencia;
		this.detalle = detalle;
		this.entradas = entradas;
		this.transformacion = transformacion;
		this.egresos = egresos;
		this.saldos = saldos;
		this.nombreComprador = nombreComprador;
		this.nombreProveedor = nombreProveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	@Override
	public String toString() {
		return "Datos [fecha=" + fecha + ", remision=" + remision + ", procedencia=" + procedencia + ", detalle="
				+ detalle + ", entradas=" + entradas + ", transformacion=" + transformacion + ", egresos=" + egresos
				+ ", saldos=" + saldos + ", nombreComprador=" + nombreComprador + ", nombreProveedor=" + nombreProveedor
				+ "]";
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getRemision() {
		return remision;
	}
	public void setRemision(int remision) {
		this.remision = remision;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	public double getTransformacion() {
		return transformacion;
	}
	public void setTransformacion(double transformacion) {
		this.transformacion = transformacion;
	}
	public String getEgresos() {
		return egresos;
	}
	public void setEgresos(String egresos) {
		this.egresos = egresos;
	}
	public double getSaldos() {
		return saldos;
	}
	public void setSaldos(double saldos) {
		this.saldos = saldos;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}
	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	


	

}

