package test;

import model.Cliente;
import model.Articulo;
import model.Empresa;
import model.Compra;
import java.time.LocalDate;
import java.util.Map;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Empresa empresa = new Empresa();

        // Agregar artículos
        Articulo articulo1 = new Articulo(1, "Mayonesa");
        Articulo articulo2 = new Articulo(2, "Gaseosa");
        Articulo articulo3 = new Articulo(3, "Helado");
        empresa.agregarArticulo(articulo1);
        empresa.agregarArticulo(articulo2);
        empresa.agregarArticulo(articulo3);

        // Agregar clientes y compras de muestra
        Cliente cliente1 = new Cliente("Cliente 1", 44444444);
        cliente1.agregarCompra(new Compra(articulo1, 3, LocalDate.of(2023, 6, 11)));  // Artículo 1, cantidad: 3
        cliente1.agregarCompra(new Compra(articulo2, 2, LocalDate.of(2023, 6, 8)));  // Artículo 2, cantidad: 2
        cliente1.agregarCompra(new Compra(articulo3, 1, LocalDate.of(2023, 6, 2)));  // Artículo 3, cantidad: 1
        empresa.agregarCliente(cliente1);

        Cliente cliente2 = new Cliente("Cliente 2", 11111111);
        cliente2.agregarCompra(new Compra(articulo1, 5, LocalDate.of(2023, 6, 3)));  // Artículo 1, cantidad: 5
        cliente2.agregarCompra(new Compra(articulo3, 2, LocalDate.of(2023, 6, 12)));  // Artículo 3, cantidad: 2
        empresa.agregarCliente(cliente2);

        // Obtener listado de artículos vendidos con sus cantidades
        Map<Articulo, Integer> articulosVendidos = empresa.obtenerArticulosVendidos();
        System.out.println("Listado de artículos vendidos:");
        for (Map.Entry<Articulo, Integer> entry : articulosVendidos.entrySet()) {
            Articulo articulo = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println(articulo.getNombre() + ": " + cantidad);
        }

        // Obtener artículo más vendido
        Articulo articuloMasVendido = empresa.obtenerArticuloMasVendido();
        System.out.println("\nArtículo más vendido: " + articuloMasVendido.getNombre());

        // Obtener artículo menos vendido
        Articulo articuloMenosVendido = empresa.obtenerArticuloMenosVendido();
        System.out.println("\nArtículo menos vendido: " + articuloMenosVendido.getNombre());

        // Obtener ventas realizadas antes de una fecha específica
        LocalDate fechaEspecifica = LocalDate.of(2023, 6, 8); // Se puede utilizar una fecha específica aquí
        List<Compra> ventasAntesDeFecha = empresa.obtenerVentasAntesDeFecha(fechaEspecifica);
        System.out.println("\nVentas realizadas antes de la fecha " + fechaEspecifica + ":");
        for (Compra compra : ventasAntesDeFecha) {
            System.out.println(compra.getArticulo().getNombre() + " - Cantidad: " + compra.getCantidad() + " - Fecha: " + compra.getFecha());
        }

        // Obtener compras de un cliente específico
        Cliente clienteEspecifico = cliente1; // Puedes elegir un cliente específico aquí
        List<Compra> comprasClienteEspecifico = empresa.obtenerComprasDeCliente(clienteEspecifico);
        System.out.println("\nCompras del cliente " + clienteEspecifico.getNombre() + ":");
        for (Compra compra : comprasClienteEspecifico) {
            System.out.println(compra.getArticulo().getNombre() + " - Cantidad: " + compra.getCantidad() + " - Fecha: " + compra.getFecha());
        }
	}

}
