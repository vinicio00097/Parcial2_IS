package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/buscarTodos")
    public List<ProductoEntity> buscarTodos() {
        return this.productoService.buscarTodos();
    }

    @PostMapping("/registrarProducto")
    public ProductoEntity crear(@RequestBody ProductoEntity productoEntity){return this.productoService.add(productoEntity);}



}
