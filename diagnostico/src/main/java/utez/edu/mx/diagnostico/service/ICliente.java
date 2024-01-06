package utez.edu.mx.diagnostico.service;

import utez.edu.mx.diagnostico.model.dto.ClientesDto;
import utez.edu.mx.diagnostico.model.entity.ClientesBean;

import java.util.List;

public interface ICliente {
    ClientesBean save(ClientesDto cliente);
    ClientesBean findById(Integer id);
    void delete(ClientesBean cliente);
    List<ClientesBean> findAll();
}
