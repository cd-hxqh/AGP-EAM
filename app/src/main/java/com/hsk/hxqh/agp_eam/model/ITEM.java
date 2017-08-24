package com.hsk.hxqh.agp_eam.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 * 物资台帐
 */

public class ITEM implements Serializable {
    public String ITEMNUM;//物资编码
    public String DESCRIPTION;//物资名称
    public String IN19;//规格型号
    public String IN20;//备注
    public String IN26;//物资大类
    public String IN27;//物资小类
    public String ROTATING;//固定资产？
    public String INSPECTIONREQUIRED;//接收时检查？
    public String STATUS;//状态
    public String LOTTYPE;//批次类型
    public String ORDERUNIT;//订购单位

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

    public String getIN19() {
        return IN19;
    }

    public void setIN19(String IN19) {
        this.IN19 = IN19;
    }

    public String getIN20() {
        return IN20;
    }

    public void setIN20(String IN20) {
        this.IN20 = IN20;
    }

    public String getIN26() {
        return IN26;
    }

    public void setIN26(String IN26) {
        this.IN26 = IN26;
    }

    public String getIN27() {
        return IN27;
    }

    public void setIN27(String IN27) {
        this.IN27 = IN27;
    }

    public String getROTATING() {
        return ROTATING;
    }

    public void setROTATING(String ROTATING) {
        this.ROTATING = ROTATING;
    }

    public String getINSPECTIONREQUIRED() {
        return INSPECTIONREQUIRED;
    }

    public void setINSPECTIONREQUIRED(String INSPECTIONREQUIRED) {
        this.INSPECTIONREQUIRED = INSPECTIONREQUIRED;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getLOTTYPE() {
        return LOTTYPE;
    }

    public void setLOTTYPE(String LOTTYPE) {
        this.LOTTYPE = LOTTYPE;
    }

    public String getORDERUNIT() {
        return ORDERUNIT;
    }

    public void setORDERUNIT(String ORDERUNIT) {
        this.ORDERUNIT = ORDERUNIT;
    }
}
