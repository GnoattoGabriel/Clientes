package com.gnoatto.Clientes.services;

import com.gnoatto.Clientes.models.ClienteModel;
import com.gnoatto.Clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criarCliente(ClienteModel novoCliente){
        return clienteRepository.save(novoCliente);
    }

    public List<ClienteModel> listarTodos(){
        return clienteRepository.findAll();
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<ClienteModel> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel novoCliente){
        Optional<ClienteModel> clienteNoBanco = clienteRepository.findById(id);

        if(clienteNoBanco.isPresent()){
            ClienteModel clienteEditar = clienteNoBanco.get();

            clienteEditar.setNome(novoCliente.getNome());
            clienteEditar.setEmail(novoCliente.getEmail());
            clienteEditar.setTelefone(novoCliente.getTelefone());

            return clienteRepository.save(clienteEditar);

        } else return null;

    }
}
