package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Poster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PosterDao implements BaseDao<Poster> {

    private final String posterFile = "src/main/resources/poster.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Poster> findAll() throws IOException {
        return readPosterFile();
    }

    public List<Poster> readPosterFile() throws IOException {
        List<Poster> posters = new ArrayList<>();
        List<String> strings = fileReader.readFile(posterFile);
        strings.forEach(s -> posters.add(toPoster(s)));
        return posters;
    }

    private Poster toPoster(String line) {
        String[] strings = line.split(",");
        return Poster.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .purpose(strings[4])
                .numberAudience(Integer.valueOf(strings[5]))
                .posterMaterial(strings[6])
                .build();
    }
}
