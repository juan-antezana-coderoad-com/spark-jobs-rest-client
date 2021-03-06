package com.github.ywilkof.sparkrestclient;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yonatan on 11.10.15.
 */
public class SparkRestClientBuilderTest {

    private SparkRestClient.SparkRestClientBuilder builder;

    @Before
    public void setUp() {
        builder = SparkRestClient.builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_WhenHostNotSet_ThenThrowException() throws Exception {
        builder.masterPort(6066);
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_WhenClientIsNull_ThenThrowException() throws Exception {
        builder.masterHost("localhost");
        builder.masterPort(6066);
        builder.httpClient(null);
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_WhenSparkVersionIsNull_ThenThrowException() throws Exception {
        builder.masterHost("localhost");
        builder.masterPort(6066);
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuild_WhenSparkVersionIsEmpty_ThenThrowException() throws Exception {
        builder.masterHost("localhost");
        builder.masterPort(6066);
        builder.sparkVersion("");
        builder.build();
    }
}