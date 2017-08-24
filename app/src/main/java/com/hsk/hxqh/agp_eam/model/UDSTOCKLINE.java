package com.hsk.hxqh.agp_eam.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 * 库存盘点子表
 */

public class UDSTOCKLINE implements Serializable {
    public int SN;//序号
    public String ITEMNUM;//物资编码
    public String UDSTOCKLINEITEDES;//物资名称
    public String UDSTOCKLINEITEISS;//发放单位
    public int QUANTITY1;//账存数量
    public int QUANTITY2;//实际数量
    public int DIFFERENCE;//差异数量
    public String REASON;//差异原因

    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public String getITEMNUM() {
        return ITEMNUM;
    }

    public void setITEMNUM(String ITEMNUM) {
        this.ITEMNUM = ITEMNUM;
    }

    public String getUDSTOCKLINEITEDES() {
        return UDSTOCKLINEITEDES;
    }

    public void setUDSTOCKLINEITEDES(String UDSTOCKLINEITEDES) {
        this.UDSTOCKLINEITEDES = UDSTOCKLINEITEDES;
    }

    public String getUDSTOCKLINEITEISS() {
        return UDSTOCKLINEITEISS;
    }

    public void setUDSTOCKLINEITEISS(String UDSTOCKLINEITEISS) {
        this.UDSTOCKLINEITEISS = UDSTOCKLINEITEISS;
    }

    public int getQUANTITY1() {
        return QUANTITY1;
    }

    public void setQUANTITY1(int QUANTITY1) {
        this.QUANTITY1 = QUANTITY1;
    }

    public int getQUANTITY2() {
        return QUANTITY2;
    }

    public void setQUANTITY2(int QUANTITY2) {
        this.QUANTITY2 = QUANTITY2;
    }

    public int getDIFFERENCE() {
        return DIFFERENCE;
    }

    public void setDIFFERENCE(int DIFFERENCE) {
        this.DIFFERENCE = DIFFERENCE;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }
}
