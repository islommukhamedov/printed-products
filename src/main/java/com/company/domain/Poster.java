package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poster extends BaseDomain {
    private String purpose;
    private Integer numberAudience;
    private String posterMaterial;

    @Builder(builderMethodName = "childBuilder")
    public Poster(Long id, String color, Double price, Integer quantity, String purpose, Integer numberAudience, String posterMaterial) {
        super(id, color, price, quantity);
        this.purpose = purpose;
        this.numberAudience = numberAudience;
        this.posterMaterial = posterMaterial;
    }
}
