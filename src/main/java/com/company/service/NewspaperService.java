package com.company.service;

import com.company.dao.NewspaperDao;
import com.company.domain.Newspaper;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class NewspaperService implements BaseService<Newspaper> {

    private final NewspaperDao dao = new NewspaperDao();

    @Override
    public ResponseEntity<DataDTO<List<Newspaper>>> findAll(String sort) {
        try {
            List<Newspaper> newspapers = dao.findAll();
            if (newspapers.isEmpty()) {
                throw new GenericNotFoundException("Newspapers not found!");
            }
            switch (sort) {
                case "1" -> newspapers.sort(Comparator.comparing(Newspaper::getId));
                case "2" -> newspapers.sort(Comparator.comparing(Newspaper::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(newspapers));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Newspaper>> findByID(Long id) {
        try {
            Newspaper newspaper = dao.findAll().stream().filter(newspaper1 ->
                    newspaper1.getId().equals(id)).findFirst().orElse(null);
            if (newspaper == null) {
                throw new GenericNotFoundException("Newspaper not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(newspaper), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Newspaper>>> findByColor(String color) {
        try {
            List<Newspaper> newspapers = dao.findAll().stream().filter(newspaper ->
                    newspaper.getColor().equals(color)).toList();
            if (newspapers.isEmpty()) {
                throw new GenericNotFoundException("Newspaper not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(newspapers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Newspaper>>> filterByPrice(Double min, Double max) {
        try {
            List<Newspaper> newspapers = dao.findAll().stream().filter(newspaper ->
                    newspaper.getPrice() >= min && newspaper.getPrice() <= max).toList();
            if (newspapers.isEmpty()) {
                throw new GenericNotFoundException("Newspaper not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(newspapers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Newspaper>>> findByTitle(String title) {
        try {
            List<Newspaper> newspapers = dao.findAll().stream().filter(newspaper ->
                    newspaper.getTitle().equals(title)).toList();
            if (newspapers.isEmpty()) {
                throw new GenericNotFoundException("Newspaper not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(newspapers), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
