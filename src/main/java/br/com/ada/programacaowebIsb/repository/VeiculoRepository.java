package br.com.ada.programacaowebIsb.repository;

import br.com.ada.programacaowebIsb.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// O JpaRepository recebe a classe modelo e o tipo da PRIMARY KEY dentro da classe modelo

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>  {

    Optional<Veiculo> findByPlacaContaining(String placa);

}
