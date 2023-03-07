package br.com.ada.programacaowebIsb.service;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.repository.VeiculoRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

 //  **** Pode-se fazer assim também, injetando no construtor ***

//    public VeiculoService(VeiculoRepository veiculoRepository) {
//        this.veiculoRepository = veiculoRepository;
//    }

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void createVehicle(Veiculo veiculo) {
        this.veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return this.veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarVeiculoPor(@PathVariable("id") Long id) {
//        Optional<Object> empty = Optional.empty();
//        empty.ifPresent(System.out::println);
        return this.veiculoRepository.findById(id);
    }

    public Optional<Veiculo> buscarVeiculoPelaPlaca(String placa) {
        return this.veiculoRepository.findByPlacaContaining(placa);
    }

    public void removerVeiculoPorId(Long id) {
        this.veiculoRepository.deleteById(id);
    }
}
