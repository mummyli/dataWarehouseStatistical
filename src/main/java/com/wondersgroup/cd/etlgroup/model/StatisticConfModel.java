package com.wondersgroup.cd.etlgroup.model;

import java.util.List;

/**
 * Created by lsj on 2017-7-18.
 */
public class StatisticConfModel {

    private String statisticalName;
    private List<ViewModel> viewList;
    private List<String> sqls;

    public String getStatisticalName() {
        return statisticalName;
    }

    public void setStatisticalName(String statisticalName) {
        this.statisticalName = statisticalName;
    }

    public List<ViewModel> getViewList() {
        return viewList;
    }

    public void setViewList(List<ViewModel> viewList) {
        this.viewList = viewList;
    }

    public List<String> getSqls() {
        return sqls;
    }

    public void setSqls(List<String> sqls) {
        this.sqls = sqls;
    }
}
