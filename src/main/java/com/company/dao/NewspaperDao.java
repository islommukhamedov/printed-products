package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Newspaper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewspaperDao implements BaseDao<Newspaper> {

    private final String newspaperFile = "src/main/resources/newspaper.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Newspaper> findAll() throws IOException {
        return readBannerFile();
    }

    public List<Newspaper> readBannerFile() throws IOException {
        List<Newspaper> newspapers = new ArrayList<>();
        List<String> strings = fileReader.readFile(newspaperFile);
        strings.forEach(s -> newspapers.add(toNewspaper(s)));
        return newspapers;
    }

    private Newspaper toNewspaper(String line) {
        String[] strings = line.split(",");
        return Newspaper.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .title(strings[4])
                .numberOfPage(Integer.valueOf(strings[5]))
                .publishedDate(strings[6])
                .build();
    }
}
