package com.wondersgroup.cd.etlgroup.statistical;

import com.wondersgroup.cd.etlgroup.model.StatisticConfModel;
import com.wondersgroup.cd.etlgroup.model.ViewModel;
import com.wondersgroup.cd.etlgroup.utils.PropertiesReader;
import com.wondersgroup.cd.etlgroup.utils.XMLPharser;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

import java.util.List;

/**
 * Created by lsj on 2017-7-18.
 */
public class StatisticalMain {

    private SparkSession spark;
    private String confFile;
    private String sqlPathBase;

    public StatisticalMain(String appName, SparkConf conf) {
        this.spark = SparkSession
                .builder()
                .appName(appName)
                .getOrCreate();
        this.sqlPathBase = PropertiesReader.read("sqlBase");
    }

    public void start(){
        List<ViewModel> dics = XMLPharser.getViewModel(null,"//dics/views/view");

        System.out.println("success read dics");
        createViews(dics);

        List<StatisticConfModel> scmList = XMLPharser.getStatisticConf(null,"sts");
        for(StatisticConfModel scm:scmList){

            createViews(scm.getViewList());
            for(String sql : scm.getSqls()){
                String viewName = sql.replace(".sql","");

                Dataset result = spark.sql(PropertiesReader.readTxtContent(sqlPathBase+sql));
                result.createOrReplaceTempView(viewName);

                result.write().csv("hdfs://192.168.1.240:9000/zhgl/"+viewName);
            }
        }
    }

    public void createViews(List<ViewModel> viewList){
        for(ViewModel view:viewList){
            Dataset dicRDD = spark.read().option("header", "true").csv(view.getFilePath());
            dicRDD.createOrReplaceTempView(view.getViewName());
        }
    }
}
