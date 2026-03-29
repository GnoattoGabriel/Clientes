package com.gnoatto.Clientes.controllers;


import com.gnoatto.Clientes.models.ClienteModel;
import com.gnoatto.Clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel novoCliente){
        ClienteModel cliente = clienteService.criarCliente(novoCliente);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> buscarTodos(){
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id,@RequestBody ClienteModel novoCliente){
        ClienteModel cliente = clienteService.atualizarCliente(id, novoCliente);
        return ResponseEntity.ok(cliente);
    }

}
