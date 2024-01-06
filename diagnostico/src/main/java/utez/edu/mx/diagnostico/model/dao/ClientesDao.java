package utez.edu.mx.diagnostico.model.dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.diagnostico.model.entity.ClientesBean;

public interface ClientesDao extends CrudRepository<ClientesBean,Integer> {
}
