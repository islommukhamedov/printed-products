package com.company.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Banner extends BaseDomain {
    private String name;
    private Double height;
    private Double length;
    private Integer weight;

    @Builder(builderMethodName = "childBuilder")
    public Banner(Long id, String color, Double price, Integer quantity, String name, Double height, Double length, Integer weight) {
        super(id, color, price, quantity);
        this.name = name;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }
}
