package com.hsk.hxqh.agp_eam.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 * 实际物料
 */

public class MATUSETRANS implements Serializable {
    public String ACTUALSTASKID;//任务
    public String ITEMNUM;//项目
    public String DESCRIPTION;//项目描述
    public String STORELOC;//库房
    public String POSITIVEQUANTITY;//数量
    public String BINNUM;//货柜
    public String LOTNUM;//批次
    public String ROTASSETNUM;//周转资产
    public String ISSUETYPE;//交易类型
    public String ENTERBY;//输入人
    public String ACTUALDATE;//实际日期

    public String getACTUALSTASKID() {
        return ACTUALSTASKID;
    }

    public void setACTUALSTASKID(String ACTUALSTASKID) {
        this.ACTUALSTASKID = ACTUALSTASKID;
    }

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

    public String getSTORELOC() {
        return STORELOC;
    }

    public void setSTORELOC(String STORELOC) {
        this.STORELOC = STORELOC;
    }

    public String getPOSITIVEQUANTITY() {
        return POSITIVEQUANTITY;
    }

    public void setPOSITIVEQUANTITY(String POSITIVEQUANTITY) {
        this.POSITIVEQUANTITY = POSITIVEQUANTITY;
    }

    public String getBINNUM() {
        return BINNUM;
    }

    public void setBINNUM(String BINNUM) {
        this.BINNUM = BINNUM;
    }

    public String getLOTNUM() {
        return LOTNUM;
    }

    public void setLOTNUM(String LOTNUM) {
        this.LOTNUM = LOTNUM;
    }

    public String getROTASSETNUM() {
        return ROTASSETNUM;
    }

    public void setROTASSETNUM(String ROTASSETNUM) {
        this.ROTASSETNUM = ROTASSETNUM;
    }

    public String getISSUETYPE() {
        return ISSUETYPE;
    }

    public void setISSUETYPE(String ISSUETYPE) {
        this.ISSUETYPE = ISSUETYPE;
    }

    public String getENTERBY() {
        return ENTERBY;
    }

    public void setENTERBY(String ENTERBY) {
        this.ENTERBY = ENTERBY;
    }

    public String getACTUALDATE() {
        return ACTUALDATE;
    }

    public void setACTUALDATE(String ACTUALDATE) {
        this.ACTUALDATE = ACTUALDATE;
    }
}
