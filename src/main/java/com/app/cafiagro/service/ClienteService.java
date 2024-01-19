package com.app.cafiagro.service;

import com.app.cafiagro.database.ClienteRepository;
import com.app.cafiagro.database.Cliente;
import com.app.cafiagro.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public List<Cliente> verCliente(){
        return clienteRepository.findAll();
    }


    public Cliente crearCliente(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCedula(clienteDTO.getCedula());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setMunicipio(clienteDTO.getMunicipio());
        clienteRepository.save(cliente);
        return cliente;
    }

    public void eliminarCliente(ClienteDTO clienteDTO)throws IllegalArgumentException{
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteDTO.getId());
        optionalCliente.ifPresent(cliente -> {
            clienteRepository.deleteById(cliente.getId());
        });
        if (!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("No existe ningun cliente con la identificacion proporcionada");
        }
    }

    public void editarCliente(ClienteDTO clienteDTO){
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteDTO.getId());
        optionalCliente.ifPresent(cliente -> {
            cliente.setCedula(clienteDTO.getCedula());
            if (clienteDTO.getNombre() != null){
                cliente.setNombre(clienteDTO.getNombre());
            }

            if (clienteDTO.getTelefono() != null){
                cliente.setTelefono(clienteDTO.getTelefono());
            }

            if (clienteDTO.getDireccion() != null){
                cliente.setDireccion(clienteDTO.getDireccion());
            }

            if (clienteDTO.getMunicipio() != null){
                cliente.setMunicipio(clienteDTO.getMunicipio());
            }

            clienteRepository.save(cliente);
        });

    }


}
