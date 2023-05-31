package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Newspaper extends BaseDomain {
    private String title;
    private Integer numberOfPage;
    private String publishedDate;

    @Builder(builderMethodName = "childBuilder")
    public Newspaper(Long id, String color, Double price, Integer quantity, String title, Integer numberOfPage, String publishedDate) {
        super(id, color, price, quantity);
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.publishedDate = publishedDate;
    }
}
