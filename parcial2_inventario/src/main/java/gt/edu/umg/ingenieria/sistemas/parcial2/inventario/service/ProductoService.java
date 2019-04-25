package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public List<ProductoEntity> buscarTodos() {
        return (List<ProductoEntity>) this.productoRepository.findAll();
    }

    public List<ProductoEntity> findByName() {
        return (List<ProductoEntity>) this.productoRepository.findByName("name",Sort.by(Sort.Direction.DESC,"name"));
    }

    public ProductoEntity add(ProductoEntity productoEntity){
        productoEntity.setName(String.valueOf(productoEntity.getName().charAt(0)).toUpperCase()+productoEntity.getName().substring(1).toLowerCase());
        return this.productoRepository.save(productoEntity);
    }

    public ProductoEntity update(Long id,String action,int cantidad){
        ProductoEntity productoEntity=this.productoRepository.findById(id).get();

        if(action.equals("incrementar")){
            int currentAmount=productoEntity.getStock();
            productoEntity.setStock(currentAmount+cantidad);
            this.productoRepository.save(productoEntity);
        }else{
            int currentAmount=productoEntity.getStock();
            productoEntity.setStock(cantidad>currentAmount?0:currentAmount-cantidad);
            this.productoRepository.save(productoEntity);
        }
        return productoEntity;
    }
}
