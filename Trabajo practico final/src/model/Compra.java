package model;

import java.time.LocalDate;

public class Compra {

	private Articulo articulo;
	private int cantidad;
	private LocalDate Fecha;
	
	public Compra(Articulo articulo, int cantidad, LocalDate fecha) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
		Fecha = fecha;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
	
	
}