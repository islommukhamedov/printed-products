package com.company.ui;

import com.company.controller.BannerController;
import com.company.controller.NewspaperController;
import com.company.controller.PosterController;
import com.company.utils.BaseUtils;

import java.util.Objects;

public class AppUI {

    private final BannerController bannerController = new BannerController();

    private final NewspaperController newspaperController = new NewspaperController();

    private final PosterController posterController = new PosterController();

    public void run() {
        BaseUtils.println("\n\n1 -> Banner");
        BaseUtils.println("2 -> Newspaper");
        BaseUtils.println("3 -> Poster");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> bannerUI();
            case "2" -> newsPaperUI();
            case "3" -> posterUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    public String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by color");
        BaseUtils.println("4 -> Filter by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void bannerUI() {
        BaseUtils.println("\n\n5 -> Find by name");
        BaseUtils.println("6 -> Find weight");
        switch (baseUI()) {
            case "1" -> showAllBanner();
            case "2" -> bannerController.findByID();
            case "3" -> bannerController.findByColor();
            case "4" -> bannerController.filterByPrice();
            case "5" -> bannerController.findByName();
            case "6" -> bannerController.findByWeight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        bannerUI();
    }

    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }

    private void showAllBanner() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            bannerUI();
        }
        bannerController.showAll(operation);
        showAllBanner();
    }

    private void newsPaperUI() {
        BaseUtils.println("\n\n5 -> Find by title");
        switch (baseUI()) {
            case "1" -> showAllNewspaper();
            case "2" -> newspaperController.findByID();
            case "3" -> newspaperController.findByColor();
            case "4" -> newspaperController.filterByPrice();
            case "5" -> newspaperController.findByTitle();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        newsPaperUI();
    }

    private void showAllNewspaper() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            newsPaperUI();
        }
        newspaperController.showAll(operation);
        showAllNewspaper();
    }

    private void posterUI() {
        BaseUtils.println("\n\n5 -> Find by purpose");
        BaseUtils.println("6 -> Find by audience");
        switch (baseUI()) {
            case "1" -> showAllPoster();
            case "2" -> posterController.findByID();
            case "3" -> posterController.findByColor();
            case "4" -> posterController.filterByPrice();
            case "5" -> posterController.findByPurpose();
            case "6" -> posterController.filterByAudience();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        posterUI();
    }

    private void showAllPoster() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            posterUI();
        }
        posterController.showAll(operation);
        showAllPoster();
    }
}
