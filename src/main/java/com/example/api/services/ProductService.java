package com.example.api.services;

import com.example.api.Repositories.ProductoRepository;
import com.example.api.model.DTO.Producto_Request_Update;
import com.example.api.model.Empresa;
import com.example.api.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> obtenerTodosLosProductosPorIdEmpresa(int id) {return productoRepository.getByCompany(id);}

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerProductoPorNombre(String nombre) {
        return productoRepository.getByName(nombre);
    }

    public List<Producto> obtenerProductoPorTipo(String tipo) {
        return productoRepository.getByType(tipo);
    }

    public List<Producto> getProductsByNombreAndEmpresaId(String nombre, int id) {
        return productoRepository.findByNombreAndEmpresaId(nombre, id);
    }

    public Producto guardarProducto(Producto producto) {
        System.out.println("ADDING");
        System.out.println(producto);
        return productoRepository.save(producto);
    }

    //Metodo para actualizar un producto
    public void actualizarProducto(Producto_Request_Update producto) {
        System.out.println(producto);
        productoRepository.actualizarProducto(producto.getNombre(), producto.getPrecio(), producto.getProductoId());
    }
    public void eliminarProducto(Integer id) {
        productoRepository.deleteProductById(id);
        System.out.println("Eliminado ps");
    }
}

