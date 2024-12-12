package com.beerhouse.api.request;

import com.beerhouse.type.BeerStyle;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BeerRequest {

    @NotBlank(message = "Parâmetro name não informado.")
    @ApiModelProperty(value = "Nome da cerveja.")
    private String name;

    @NotNull(message = "Parâmetro style não informado.")
    @ApiModelProperty(value = "Estilo da cerveja.")
    private BeerStyle style;

    @NotBlank(message = "Parâmetro brewery não informado.")
    @ApiModelProperty(value = "Nome do produtor da cerveja.")
    private String brewery;

    @NotNull(message = "Parâmetro alcVol não informado.")
    @ApiModelProperty(value = "Teor alcoólico da cerveja.")
    private Double alcVol;

    @NotNull(message = "Parâmetro ml não informado.")
    @ApiModelProperty(value = "Conteúdo líquido da cerveja.")
    private Double ml;

    @NotNull(message = "Parâmetro price não informado.")
    @ApiModelProperty(value = "Preço da cerveja.")
    private Double price;
}