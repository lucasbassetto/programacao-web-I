package br.com.ada.programacaowebIsb;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO {



    private String placa;

    @NotBlank(message = "Preencher o campo")
    private String modelo;
    private String marca;
    private String tipo;
    private boolean disponivel;
}
