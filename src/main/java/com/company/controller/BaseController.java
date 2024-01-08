package com.company.controller;

public interface BaseController {
    void showAll(String sort);

    void findByID();

    void findByColor();

    void filterByPrice();
}

public void addNewBase() {
    BaseUtils.println("Enter base details:");
}

public void deleteBase() {
    BaseUtils.println("Enter base ID to delete:");
}

public void addNewCategory() {
    BaseUtils.println("Enter new category name:");
}
