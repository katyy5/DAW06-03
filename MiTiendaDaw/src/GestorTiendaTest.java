import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GestorTiendaTest {
    static GestorTienda tienda;

    @BeforeAll
    static void setUpBeforeClass() {
        tienda = new GestorTienda();
    }

    @Test
    void testCalcularDescuento() {
        assertEquals(10.0, tienda.calcularDescuento(100, 10)); 
        assertEquals(5.0, tienda.calcularDescuento(100, 5)); 
        assertEquals(0.0, tienda.calcularDescuento(100, 4)); 
    }

    @Test
    void testCategorizarProducto() {
        assertEquals("Económico", tienda.categorizarProducto(9.99));
        assertEquals("Estándar", tienda.categorizarProducto(25));
        assertEquals("Premium", tienda.categorizarProducto(50));
    }

    @Test
    void testBuscarProducto() {
        String[] inventario = {"Manzana", "Banana", "Uva"};

        assertEquals("Banana", tienda.buscarProducto(inventario, "Banana"));
        assertNull(tienda.buscarProducto(inventario, "Mango"));
        assertEquals("Banana", tienda.buscarProducto(inventario, "banana")); 
    }
}
