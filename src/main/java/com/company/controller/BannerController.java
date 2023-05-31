package com.company.controller;

import com.company.domain.Banner;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.BannerService;
import com.company.utils.BaseUtils;

import java.util.List;

public class BannerController implements BaseController {

    private final BannerService service = new BannerService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Banner>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByName() {
        BaseUtils.print("Enter name: ");
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWeight() {
        BaseUtils.print("Enter weight: ");
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByWeight(BaseUtils.readInteger());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
