package utez.edu.mx.diagnostico.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.diagnostico.model.dao.ClientesDao;
import utez.edu.mx.diagnostico.model.dto.ClientesDto;
import utez.edu.mx.diagnostico.model.entity.ClientesBean;
import utez.edu.mx.diagnostico.service.ICliente;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientesImpl implements ICliente {
private final ClientesDao clientesDao;
    @Override
    @Transactional
    public ClientesBean save(ClientesDto clientesDto){
        ClientesBean cliente = ClientesBean.builder()
                .id_cliente(clientesDto.getId_cliente())
                .nombre(clientesDto.getNombre())
                .apellidos(clientesDto.getApellidos())
                .curp(clientesDto.getCurp())
                .f_nacimiento(clientesDto.getF_nacimiento())
                .build();
        return clientesDao.save(cliente);
    }
    @Override
    @Transactional(readOnly = true)
    public ClientesBean findById(Integer id){return clientesDao.findById(id).orElse(null);}


    @Override
    @Transactional(readOnly = true)
    public List<ClientesBean> findAll() {
        return (List<ClientesBean>) clientesDao.findAll();
    }


    @Override
    @Transactional
    public void delete(ClientesBean cliente){clientesDao.delete(cliente);}

}
