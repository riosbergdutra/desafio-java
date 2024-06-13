package design.patterns.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.patterns.demo.model.Cliente;
import design.patterns.demo.repository.ClienteRepository;
import design.patterns.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}