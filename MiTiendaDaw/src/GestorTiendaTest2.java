import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GestorTiendaTest {
    static GestorTienda tienda;

    @BeforeAll
    static void setUpBeforeClass() {
        tienda = new GestorTienda();
    }

    // Tests adicionales para calcularDescuento
    @Test
    void testCalcularDescuento_PrecioCero() {
        assertEquals(0.0, tienda.calcularDescuento(0, 10));
    }

    @Test
    void testCalcularDescuento_PrecioNegativo() {
        assertEquals(-1.0, tienda.calcularDescuento(-10, 10)); 

    @Test
    void testCalcularDescuento_JustoEnElLimite5() {
        assertEquals(5.0, tienda.calcularDescuento(100, 5)); 
    }

    @Test
    void testCalcularDescuento_JustoEnElLimite10() {
        assertEquals(10.0, tienda.calcularDescuento(100, 10)); 
    }

    
    @Test
    void testCategorizarProducto_Exactamente10() {
        assertEquals("Estándar", tienda.categorizarProducto(10.00));
    }

    @Test
    void testCategorizarProducto_Exactamente50() {
        assertEquals("Premium", tienda.categorizarProducto(50.00));
    }

    @Test
    void testCategorizarProducto_ValorExtremo() {
        assertEquals("Premium", tienda.categorizarProducto(100000));
    }

    @Test
    void testCategorizarProducto_Negativo() {
        assertEquals("Económico", tienda.categorizarProducto(-5)); 
    }

    
    @Test
    void testBuscarProducto_InventarioVacio() {
        String[] inventario = {};
        assertNull(tienda.buscarProducto(inventario, "Manzana"));
    }

    @Test
    void testBuscarProducto_InventarioUnElemento() {
        String[] inventario = {"Manzana"};
        assertEquals("Manzana", tienda.buscarProducto(inventario, "Manzana"));
        assertNull(tienda.buscarProducto(inventario, "Banana"));
    }

    @Test
    void testBuscarProducto_ProductoConEspacios() {
        String[] inventario = {"  Manzana  ", "Banana", "Uva"};
        assertNull(tienda.buscarProducto(inventario, "Manzana")); 
    }
}

