package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BannerDao implements BaseDao<Banner> {

    private final String bannerFile = "src/main/resources/banner.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Banner> findAll() throws IOException {
        return readBannerFile();
    }

    public List<Banner> readBannerFile() throws IOException {
        List<Banner> banners = new ArrayList<>();
        List<String> strings = fileReader.readFile(bannerFile);
        strings.forEach(s -> banners.add(toBanner(s)));
        return banners;
    }

    private Banner toBanner(String line) {
        String[] strings = line.split(",");
        return Banner.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .name(strings[4])
                .height(Double.valueOf(strings[5]))
                .length(Double.valueOf(strings[6]))
                .weight(Integer.valueOf(strings[7]))
                .build();
    }
}
