package com.gnoatto.Clientes.controllers;


import com.gnoatto.Clientes.models.ClienteModel;
import com.gnoatto.Clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteModel criarCliente(@RequestBody ClienteModel novoCliente){
        return clienteService.criarCliente(novoCliente);
    }

    @GetMapping
    public List<ClienteModel> buscarTodos(){
        return clienteService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteModel atualizarCliente(@PathVariable Long id,@RequestBody ClienteModel novoCliente){
        return clienteService.atualizarCliente(id, novoCliente);
    }

}
