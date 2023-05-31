package com.company.controller;

import com.company.domain.Newspaper;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.NewspaperService;
import com.company.utils.BaseUtils;

import java.util.List;

public class NewspaperController implements BaseController {

    private final NewspaperService service = new NewspaperService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Newspaper>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByTitle() {
        BaseUtils.print("Enter title: ");
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.findByTitle(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
