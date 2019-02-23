package com.lemsst.bangsamoro.core.data.excel.poisamples;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Two dimensional arrays do not need to have the same column size
 * In @Test in testng, if you do data driven, the column size need to be the same
 */
public class JavaBasics {

    public static void main(String[] args) {

        Object[][] testData = new Object[3][];

        testData[0] = new Object[1];
        testData[0][0] = "1";
        testData[1] = new Object[2];
        testData[1][0] = "2";
        testData[1][1] = "3";
        testData[2] = new Object[3];
        testData[2][0] = "4";
        testData[2][1] = "5";
        testData[2][2] = "6";

        System.out.println(ReflectionToStringBuilder.toString(testData, ToStringStyle.MULTI_LINE_STYLE));
    }

}
