package com.lemsst.bangsamoro.core.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class YAMLDataManager {

    private static final Logger LOGGER = LogManager.getLogger(YAMLTestDataManager.class.getName());

    /**
     * https://stackoverflow.com/questions/51835394/how-do-i-manage-my-test-data-as-an-object-reading-from-a-yaml-file
     * https://stackoverflow.com/questions/666477/possible-to-pass-parameters-to-testng-dataprovider
     */
    @DataProvider(name = "dp")
    public static Object[][] getData(ITestContext context) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        YAMLPOJO yamlpojo = null;

        try {
            yamlpojo = mapper.readValue(new File("src/main/resources/ctd/SCENARIO_002.yaml"), YAMLPOJO.class);
            LOGGER.info("==== TEST DATA ====");
            LOGGER.info(ReflectionToStringBuilder.toString(yamlpojo, ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> list = yamlpojo.getList();

        Object[][] data = list.stream()
                .map(dataSet -> dataSet.toArray())
                .toArray(Object[][]::new);

        return data;
    }

}
