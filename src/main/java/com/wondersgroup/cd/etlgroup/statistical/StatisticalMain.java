package com.wondersgroup.cd.etlgroup.statistical;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

/**
 * Created by lsj on 2017-7-18.
 */
public class StatisticalMain {

    private SparkSession spark;
    private String confFile;

    public StatisticalMain(String appName, SparkConf conf) {
        this.spark = SparkSession
                .builder()
                .appName(appName)
                .config(conf)
                .getOrCreate();
    }

    public void start(){


    }
}
