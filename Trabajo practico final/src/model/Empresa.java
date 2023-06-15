package model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class Empresa {
	private List<Cliente> lstClientes;	
	private List<Articulo> lstArticulos;
	
	public Empresa() {
		super();
		this.lstClientes = new ArrayList<Cliente>();
		this.lstArticulos = new ArrayList<Articulo>();
	}
	public List<Cliente> getLstClientes() {
		return lstClientes;
	}
	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	public List<Articulo> getLstArticulos() {
		return lstArticulos;
	}
	public void setLstArticulos(List<Articulo> lstArticulos) {
		this.lstArticulos = lstArticulos;
	}

	public void agregarArticulo(Articulo articulo) {
		lstArticulos.add(articulo);
	}
	
	public void agregarCliente(Cliente cliente) {
		lstClientes.add(cliente);
	}
	
	// Obtener el listado de artículos vendidos con sus cantidades
    public Map<Articulo, Integer> obtenerArticulosVendidos() {
        Map<Articulo, Integer> articulosVendidos = new HashMap<>();

        for (Cliente cliente : lstClientes) {
            List<Compra> compras = cliente.getCompra();

            for (Compra compra : compras) {
                Articulo articulo = compra.getArticulo();
                int cantidad = compra.getCantidad();

                articulosVendidos.put(articulo, articulosVendidos.getOrDefault(articulo, 0) + cantidad);
            }
        }

        return articulosVendidos;
    }
	
 // Obtener el artículo más vendido
    public Articulo obtenerArticuloMasVendido() {
        Map<Articulo, Integer> articulosVendidos = obtenerArticulosVendidos();
        int maxCantidad = 0;
        Articulo articuloMasVendido = null;

        for (Map.Entry<Articulo, Integer> entry : articulosVendidos.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                maxCantidad = entry.getValue();
                articuloMasVendido = entry.getKey();
            }
        }

        return articuloMasVendido;
    }

    // Obtener el artículo menos vendido
    public Articulo obtenerArticuloMenosVendido() {
        Map<Articulo, Integer> articulosVendidos = obtenerArticulosVendidos();
        int minCantidad = Integer.MAX_VALUE;
        Articulo articuloMenosVendido = null;

        for (Map.Entry<Articulo, Integer> entry : articulosVendidos.entrySet()) {
            if (entry.getValue() < minCantidad) {
                minCantidad = entry.getValue();
                articuloMenosVendido = entry.getKey();
            }
        }

        return articuloMenosVendido;
    }

    // Obtener ventas realizadas antes de una fecha específica
    public List<Compra> obtenerVentasAntesDeFecha(LocalDate fecha) {
        List<Compra> ventasAntesDeFecha = new ArrayList<>();

        for (Cliente cliente : lstClientes) {
            List<Compra> compras = cliente.getCompra();

            for (Compra compra : compras) {
                if (compra.getFecha().isBefore(fecha)) {
                    ventasAntesDeFecha.add(compra);
                }
            }
        }

        return ventasAntesDeFecha;
    }

    // Obtener compras de un cliente específico
    public List<Compra> obtenerComprasDeCliente(Cliente cliente) {
        return cliente.getCompra();
    }
}
