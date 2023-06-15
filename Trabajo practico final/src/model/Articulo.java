package model;

public class Articulo {

	private int tipoArticulo;
	private String nombre;

	public Articulo(int tipoArticulo, String nombre) {
		this.tipoArticulo = tipoArticulo;
		this.nombre = nombre;

	}

	public int getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipoArticulo(int tipoArticulo) {
			this.tipoArticulo = tipoArticulo;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String toString() {
		return ("[Tipo: " + tipoArticulo + ", nombre: " + nombre + "]");
	}
}
