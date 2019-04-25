package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Long>{
    List<ProductoEntity> findByName(String name, Sort sort);
}
