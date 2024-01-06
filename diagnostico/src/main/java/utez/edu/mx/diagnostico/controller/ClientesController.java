package utez.edu.mx.diagnostico.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.diagnostico.model.dto.ClientesDto;
import utez.edu.mx.diagnostico.model.entity.ClientesBean;
import utez.edu.mx.diagnostico.service.ICliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class ClientesController {
    private final ICliente clienteService;
    @PostMapping("cliente")
    public ClientesDto create(@RequestBody ClientesDto clientesDto){
        ClientesBean clienteSave =clienteService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clienteSave.getId_cliente())
                .nombre(clienteSave.getNombre())
                .apellidos(clientesDto.getApellidos())
                .curp(clienteSave.getCurp())
                .f_nacimiento(clienteSave.getF_nacimiento())
                .build();
    }
    @PutMapping("cliente")
    public ClientesDto update(@RequestBody ClientesDto clientesDto){
        ClientesBean clienteUpdate =clienteService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clienteUpdate.getId_cliente())
                .nombre(clienteUpdate.getNombre())
                .apellidos(clienteUpdate.getApellidos())
                .curp(clienteUpdate.getCurp())
                .f_nacimiento(clienteUpdate.getF_nacimiento())
                .build();
    }
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            ClientesBean cliente =clienteService.findById(id);
            clienteService.delete(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
        }catch (DataAccessException ex){
            response.put("msg",ex.getMessage());
            response.put("cliente",null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("cliente/{id}")
    public ClientesBean showById(@PathVariable Integer id){return clienteService.findById(id);}

    @GetMapping("clientes")
    public List<ClientesBean> showAll(){return clienteService.findAll();}
}
