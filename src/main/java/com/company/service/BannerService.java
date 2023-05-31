package com.company.service;

import com.company.dao.BannerDao;
import com.company.domain.Banner;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class BannerService implements BaseService<Banner> {

    private final BannerDao dao = new BannerDao();

    @Override
    public ResponseEntity<DataDTO<List<Banner>>> findAll(String sort) {
        try {
            List<Banner> banners = dao.findAll();
            if (banners.isEmpty()) {
                throw new GenericNotFoundException("Banners not found!");
            }
            switch (sort) {
                case "1" -> banners.sort(Comparator.comparing(Banner::getId));
                case "2" -> banners.sort(Comparator.comparing(Banner::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(banners));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Banner>> findByID(Long id) {
        try {
            Banner banner = dao.findAll().stream().filter(banner1 ->
                    banner1.getId().equals(id)).findFirst().orElse(null);
            if (banner == null) {
                throw new GenericNotFoundException("Banner not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(banner), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Banner>>> findByColor(String color) {
        try {
            List<Banner> banners = dao.findAll().stream().filter(banner ->
                    banner.getColor().equals(color)).toList();
            if (banners.isEmpty()) {
                throw new GenericNotFoundException("Banner not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(banners), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Banner>>> filterByPrice(Double min, Double max) {
        try {
            List<Banner> banners = dao.findAll().stream().filter(banner ->
                    banner.getPrice() >= min && banner.getPrice() <= max).toList();
            if (banners.isEmpty()) {
                throw new GenericNotFoundException("Banner not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(banners), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Banner>>> findByName(String name) {
        try {
            List<Banner> banners = dao.findAll().stream().filter(banner ->
                    banner.getName().contains(name)).toList();
            if (banners.isEmpty()) {
                throw new GenericNotFoundException("Banner not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(banners), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Banner>>> findByWeight(Integer weight) {
        try {
            List<Banner> banners = dao.findAll().stream().filter(banner ->
                    banner.getWeight().equals(weight)).toList();
            if (banners.isEmpty()) {
                throw new GenericNotFoundException("Banner not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(banners), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
