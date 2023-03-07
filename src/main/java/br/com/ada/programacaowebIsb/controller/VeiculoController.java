package br.com.ada.programacaowebIsb.controller;
import br.com.ada.programacaowebIsb.VeiculoDTO;
import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.service.VeiculoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/")
    public ResponseEntity<String> createVeiculo(@Valid @RequestBody VeiculoDTO veiculo) {
        try {

            Veiculo veiculoDB = Veiculo.builder()
                    .placa(veiculo.getPlaca())
                    .modelo(veiculo.getModelo())
                    .disponivel(veiculo.isDisponivel())
                    .tipo(veiculo.getTipo())
                    .build();

            this.veiculoService.createVehicle(veiculoDB);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Veiculo criado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/todos")
    public List<Veiculo> listarTodos() {
        return this.veiculoService.listarTodos();
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPor(@PathVariable("id") Long id) {

        Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPor(id);

        if (optionalVeiculo.isPresent()) {
            return ResponseEntity.ok(optionalVeiculo.get());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/")
    public ResponseEntity<String> atualizarVeiculo(@RequestBody VeiculoDTO veiculo) {
        //1 - buscar veiculo pela placa
        //2 - atualizar veiculo

        try {
            Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPelaPlaca(veiculo.getPlaca());

            if (optionalVeiculo.isPresent()) {
                Veiculo veiculoPorPlacaDB = optionalVeiculo.get();
                Veiculo veiculoAtualizar = Veiculo.builder().id(veiculoPorPlacaDB.getId())
                        .modelo(veiculo.getModelo())
                        .marca(veiculo.getMarca())
                        .placa(veiculo.getPlaca())
                        .tipo(veiculo.getTipo())
                        .disponivel(veiculo.isDisponivel())
                        .build();
                this.veiculoService.createVehicle(veiculoAtualizar);

                return ResponseEntity
                        .ok("Veículo atualizado!");
            }
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void removerVeiculo(@PathVariable Long id){
        this.veiculoService.removerVeiculoPorId(id);
    }
}
