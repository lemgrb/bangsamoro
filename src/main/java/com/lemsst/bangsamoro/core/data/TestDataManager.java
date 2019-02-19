package com.lemsst.bangsamoro.core.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class TestDataManager {

    // TODO: Why not just pass the name of the class as String? e.g. "TestDataManager"
    private static final Logger LOGGER = LogManager.getLogger(TestDataManager.class.getName());

    /**
     * TODO: Outside the IDE, how to ensure program can read from the resource path?
     */
    public static TestScenarioData getScenarioTestData(String testScenarioId) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        TestScenarioData testScenarioData = null;

        try {
            testScenarioData = mapper.readValue(new File("src/main/resources/ctd/" + testScenarioId), TestScenarioData.class);
            LOGGER.info("==== TEST DATA ====");
            LOGGER.info(ReflectionToStringBuilder.toString(testScenarioData, ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return testScenarioData;
    }
}
