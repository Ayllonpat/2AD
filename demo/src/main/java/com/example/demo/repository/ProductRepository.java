package com.example.demo.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Repositorio en memoria para la gestión de productos.
 * Actúa como una simulación de base de datos.
 */
@Repository // Marca esta clase como un componente gestionado por Spring.
public class ProductRepository {

    // Almacena los productos usando un HashMap donde la clave es el ID.
    private final HashMap<Long, Product> products = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(0); // Generador de IDs únicos.

    /**
     * Inicializa el repositorio con datos de ejemplo.
     */
    @PostConstruct // Ejecuta este método después de crear la instancia del repositorio.
    public void init() {
        add(Product.builder().name("Laptop").price(1200.0).build());
        add(Product.builder().name("Smartphone").price(800.0).build());
        add(Product.builder().name("Headphones").price(150.0).build());
        add(Product.builder().name("Monitor").price(300.0).build());
        add(Product.builder().name("Keyboard").price(50.0).build());
    }

    /**
     * Agrega un producto al repositorio.
     * @param product Producto a agregar.
     * @return El producto con su ID asignado.
     */
    public Product add(Product product) {
        long id = counter.incrementAndGet(); // Genera un nuevo ID.
        product.setId(id); // Asigna el ID al producto.
        products.put(id, product); // Lo guarda en el HashMap.
        return product;
    }

    /**
     * Obtiene un producto por su ID.
     * @param id ID del producto.
     * @return Un Optional con el producto si existe.
     */
    public Optional<Product> get(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    /**
     * Obtiene todos los productos almacenados.
     * @return Una lista inmutable de productos.
     */
    public List<Product> getAll() {
        return List.copyOf(products.values());
    }

    /**
     * Edita un producto existente.
     * @param id ID del producto a editar.
     * @param newValue Valores actualizados del producto.
     * @return Un Optional con el producto editado si existe.
     */
    public Optional<Product> edit(Long id, Product newValue) {
        return Optional.ofNullable(products.computeIfPresent(id, (k, v) -> {
            v.setName(newValue.getName());
            v.setPrice(newValue.getPrice());
            return v;
        }));
    }

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     */
    public void delete(Long id) {
        products.remove(id);
    }

    /**
     * Consulta productos según precio máximo y dirección de ordenación.
     * @param maxPrice Precio máximo permitido.
     * @param sortDirection Dirección de ordenación ("asc" o "desc").
     * @return Lista inmutable de productos que cumplen los criterios.
     */
    public List<Product> query(double maxPrice, String sortDirection) {
        List<Product> data = new ArrayList<>(products.values());
        List<Product> result;

        // Filtra por precio si se proporciona un máximo.
        if (maxPrice < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(p -> p.getPrice() <= maxPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        // Ordena según la dirección indicada.
        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Product::getName));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Product::getName).reversed());
        }

        return Collections.unmodifiableList(result); // Devuelve una lista inmutable.
    }
}
