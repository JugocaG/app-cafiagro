package com.app.cafiagro.controller;

import com.app.cafiagro.database.Cliente;
import com.app.cafiagro.database.ClienteRepository;
import com.app.cafiagro.dto.ClienteDTO;
import com.app.cafiagro.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteController {

    final int RESTA_ULTIMO_NUMERO_SECUENCIA = 1;

    private ClienteService clienteService;

    private ClienteRepository clienteRepository;


    @GetMapping(path = "ver-clientes")
    public List<Cliente> obtenerCliente() {
        return clienteService.verCliente();
    }

    @PostMapping(path = "crear-cliente")
    public String crearCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.crearCliente(clienteDTO);
        log.info("Se creo el cliente No. " + (clienteRepository.getNextValCliente() - RESTA_ULTIMO_NUMERO_SECUENCIA) + ". Cedula: " + clienteDTO.getCedula() + ". Nombre: " + clienteDTO.getNombre() + ". Telefono: " + clienteDTO.getTelefono() + ". Municipio: " + clienteDTO.getMunicipio() + ". Direccion: " + clienteDTO.getDireccion() + ".");
        return null;
    }

    @PostMapping(path = "eliminar-cliente")
    public String eliminarCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.eliminarCliente(clienteDTO);
        log.info("Se elimino el cliente No. " + clienteDTO.getId() + ". Cedula: " + clienteDTO.getCedula());
        return null;
    }

    @PostMapping(path = "editar-cliente")
    public String editarCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.editarCliente(clienteDTO);
        log.info("Se edito el cliente No. " + clienteDTO.getId() + ". Cedula: " + clienteDTO.getCedula() + ". Nombre: " + clienteDTO.getNombre() + ". Telefono: " + clienteDTO.getTelefono() + ". Municipio: " + clienteDTO.getMunicipio() + ". Direccion: " + clienteDTO.getDireccion() + ".");
        return null;
    }


}
