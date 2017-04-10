package com.hsk.hxqh.agp_eam.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 * 计划物料
 */

public class WPMATERIAL implements Serializable {
    public String ITEMNUM;//项目
    public String DESCRIPTION;//项目描述
    public String ISSUETO;//
    public String ITEMQTY;//数量
    public String LINECOST;//
    public String LINETYPE;
    public String LOCATION;//库房
    public String ORDERUNIT;
    public String PR;
    public String PRLINENUM;
    public String REQUESTBY;//请求者
    public String REQUIREDATE;//要求的日期
    public String TASKID;//任务
    public String UNITCOST;
    public String VENDOR;//供应商
    public String WPMATERIALINVITECAT;
    public String WPMATERIALSTODES;
    public String itemnum;//
    public String TYPE;

    public String getITEMNUM() {
        return ITEMNUM;
    }

    public void setITEMNUM(String ITEMNUM) {
        this.ITEMNUM = ITEMNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getISSUETO() {
        return ISSUETO;
    }

    public void setISSUETO(String ISSUETO) {
        this.ISSUETO = ISSUETO;
    }

    public String getITEMQTY() {
        return ITEMQTY;
    }

    public void setITEMQTY(String ITEMQTY) {
        this.ITEMQTY = ITEMQTY;
    }

    public String getLINECOST() {
        return LINECOST;
    }

    public void setLINECOST(String LINECOST) {
        this.LINECOST = LINECOST;
    }

    public String getLINETYPE() {
        return LINETYPE;
    }

    public void setLINETYPE(String LINETYPE) {
        this.LINETYPE = LINETYPE;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getORDERUNIT() {
        return ORDERUNIT;
    }

    public void setORDERUNIT(String ORDERUNIT) {
        this.ORDERUNIT = ORDERUNIT;
    }

    public String getPR() {
        return PR;
    }

    public void setPR(String PR) {
        this.PR = PR;
    }

    public String getPRLINENUM() {
        return PRLINENUM;
    }

    public void setPRLINENUM(String PRLINENUM) {
        this.PRLINENUM = PRLINENUM;
    }

    public String getREQUESTBY() {
        return REQUESTBY;
    }

    public void setREQUESTBY(String REQUESTBY) {
        this.REQUESTBY = REQUESTBY;
    }

    public String getREQUIREDATE() {
        return REQUIREDATE;
    }

    public void setREQUIREDATE(String REQUIREDATE) {
        this.REQUIREDATE = REQUIREDATE;
    }

    public String getTASKID() {
        return TASKID;
    }

    public void setTASKID(String TASKID) {
        this.TASKID = TASKID;
    }

    public String getUNITCOST() {
        return UNITCOST;
    }

    public void setUNITCOST(String UNITCOST) {
        this.UNITCOST = UNITCOST;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public String getWPMATERIALINVITECAT() {
        return WPMATERIALINVITECAT;
    }

    public void setWPMATERIALINVITECAT(String WPMATERIALINVITECAT) {
        this.WPMATERIALINVITECAT = WPMATERIALINVITECAT;
    }

    public String getWPMATERIALSTODES() {
        return WPMATERIALSTODES;
    }

    public void setWPMATERIALSTODES(String WPMATERIALSTODES) {
        this.WPMATERIALSTODES = WPMATERIALSTODES;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
}
