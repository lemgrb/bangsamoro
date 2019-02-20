package com.lemsst.bangsamoro.core.data;

import org.testng.annotations.DataProvider;

public class ExcelDataManager {

    @DataProvider(name="dp", parallel = true)
    public static Object[][] getData() {
        return new Object[][] {
                {"lmorningstar578","Password123"},
                {"lmorningstar578","Password124"}
        };
    }

}
