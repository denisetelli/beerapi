package com.beerhouse.api.response;

import com.beerhouse.type.BeerStyle;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BeerResponse {

    @ApiModelProperty(value = "Id da cerveja.")
    private Integer id;
    @ApiModelProperty(value = "Nome da cerveja.")
    private String name;
    @ApiModelProperty(value = "Estilo da cerveja.")
    private BeerStyle style;
    @ApiModelProperty(value = "Nome do produtor da cerveja.")
    private String brewery;
    @ApiModelProperty(value = "Teor alcoólico da cerveja.")
    private Double alcVol;
    @ApiModelProperty(value = "Conteúdo líquido da cerveja.")
    private Double ml;
    @ApiModelProperty(value = "Preço da cerveja.")
    private Double price;
}