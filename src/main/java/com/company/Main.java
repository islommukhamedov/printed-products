package com.company;

import com.company.ui.AppUI;
import com.company.utils.BaseUtils;

public class Main {
    static AppUI appUI = new AppUI();

    public static void main(String[] args) {
        BaseUtils.println("\n\n*************** Project: Warehouse search system *****************");
        BaseUtils.println("--------------- Author: Iroda Khikmatullaeva ---------------");
        BaseUtils.println("--------------- Email: iroda_khikmatullaeva@student.itpu.uz ---------------");
        BaseUtils.println("--------------- Creation date: since 29/04/23  ---------------");
        BaseUtils.println("--------------- Version: version-0.0.1 ---------------");
        appUI.run();
    }
}