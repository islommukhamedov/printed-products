package com.company.service;

import com.company.dao.PosterDao;
import com.company.domain.Poster;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class PosterService implements BaseService<Poster> {

    private final PosterDao dao = new PosterDao();

    @Override
    public ResponseEntity<DataDTO<List<Poster>>> findAll(String sort) {
        try {
            List<Poster> posters = dao.findAll();
            if (posters.isEmpty()) {
                throw new GenericNotFoundException("Posters not found!");
            }
            switch (sort) {
                case "1" -> posters.sort(Comparator.comparing(Poster::getId));
                case "2" -> posters.sort(Comparator.comparing(Poster::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(posters));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Poster>> findByID(Long id) {
        try {
            Poster poster = dao.findAll().stream().filter(poster1 ->
                    poster1.getId().equals(id)).findFirst().orElse(null);
            if (poster == null) {
                throw new GenericNotFoundException("Poster not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(poster), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Poster>>> findByColor(String color) {
        try {
            List<Poster> posters = dao.findAll().stream().filter(poster ->
                    poster.getColor().equals(color)).toList();
            if (posters.isEmpty()) {
                throw new GenericNotFoundException("Poster not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(posters), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Poster>>> filterByPrice(Double min, Double max) {
        try {
            List<Poster> posters = dao.findAll().stream().filter(poster ->
                    poster.getPrice() >= min && poster.getPrice() <= max).toList();
            if (posters.isEmpty()) {
                throw new GenericNotFoundException("Poster not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(posters), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Poster>>> findByPurpose(String purpose) {
        try {
            List<Poster> posters = dao.findAll().stream().filter(poster ->
                    poster.getPurpose().equals(purpose)).toList();
            if (posters.isEmpty()) {
                throw new GenericNotFoundException("Poster not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(posters), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Poster>>> filterByAudience(Integer min, Integer max) {
        try {
            List<Poster> posters = dao.findAll().stream().filter(poster ->
                    poster.getNumberAudience() >= min && poster.getNumberAudience() <= max).toList();
            if (posters.isEmpty()) {
                throw new GenericNotFoundException("Poster not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(posters), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
