package com.wondersgroup.cd.etlgroup.statistical;

import org.apache.spark.SparkConf;

/**
 * Created by lsj on 2017-7-19.
 */
public class StatisticalController {

    private static final String DEFAULT_APP_NAME = "center statistic app";

    public static void main(String[] args) {
        String appName;

        if(args.length==1) appName = args[0];
        else appName = DEFAULT_APP_NAME;

        SparkConf sparkConf = null;
        new StatisticalMain(appName,sparkConf).start();
    }
}
