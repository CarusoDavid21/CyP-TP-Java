package model;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private int dni;
	private List<Compra> compras;

	public Cliente(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.compras = new ArrayList<Compra>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setCompra(List<Compra> compras) {
		this.compras = compras;
	}
	
	public List<Compra> getCompra() {
		return compras;
	}

	public void agregarCompra(Compra compra) {
		compras.add(compra);
	}
	
}
