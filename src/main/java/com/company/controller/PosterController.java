package com.company.controller;

import com.company.domain.Poster;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.PosterService;
import com.company.utils.BaseUtils;

import java.util.List;

public class PosterController implements BaseController {

    private final PosterService service = new PosterService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Poster>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void filterByAudience() {
        BaseUtils.print("Enter min: ");
        Integer min = BaseUtils.readInteger();
        BaseUtils.print("Enter max: ");
        Integer max = BaseUtils.readInteger();
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.filterByAudience(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByPurpose() {
        BaseUtils.print("Enter purpose: ");
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.findByPurpose(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
