package com.hsk.hxqh.agp_eam.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/27.
 */

public class WORKORDER implements Serializable {
    public String WONUM;//工单
    public String DESCRIPTION;//描述
    public String WORKTYPE;//工单类型
    public String ASSETNUM;//资产
    public String ASSETDES;//资产描述
    public String STATIONDES;//站场
    public String LOCATION;//位置
    public String LOCATIONDES;//位置描述
    public String UDWOREQNUM;//工作申请编号
    public String UDFAULTREPORTNUM;//故障提报ACT号
    public String UDYEARPLANNUM;//年度计划编号
    public String UDSTATUS;//状态
    public String CREATEBYNAME;//创建人
    public String CREATEDATE;//创建时间
    public String SCHEDSTART;//调度开始时间
    public String SCHEDFINISH;//计划完成时间
    public String ACTSTART;//实际开始时间
    public String ACTFINISH;//实际完成时间
    public String UDYEAR;//年度计划
    public String WORKFREQUENCY;//频率
    public String JPNUM;//作业计划
    public String UDWORKSCOPE;//工作范围
    public String UDFAULTDESC;//故障描述
    public String UDREASON;//故障原因
    public String HAZARDLEVEL;//工期
    public String UDSTATIONNUM;//

    public String getWONUM() {
        return WONUM;
    }

    public void setWONUM(String WONUM) {
        this.WONUM = WONUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getWORKTYPE() {
        return WORKTYPE;
    }

    public void setWORKTYPE(String WORKTYPE) {
        this.WORKTYPE = WORKTYPE;
    }

    public String getWORKFREQUENCY() {
        return WORKFREQUENCY;
    }

    public void setWORKFREQUENCY(String WORKFREQUENCY) {
        this.WORKFREQUENCY = WORKFREQUENCY;
    }

    public String getACTSTART() {
        return ACTSTART;
    }

    public void setACTSTART(String ACTSTART) {
        this.ACTSTART = ACTSTART;
    }

    public String getACTFINISH() {
        return ACTFINISH;
    }

    public void setACTFINISH(String ACTFINISH) {
        this.ACTFINISH = ACTFINISH;
    }

    public String getASSETNUM() {
        return ASSETNUM;
    }

    public void setASSETNUM(String ASSETNUM) {
        this.ASSETNUM = ASSETNUM;
    }

    public String getASSETDES() {
        return ASSETDES;
    }

    public void setASSETDES(String ASSETDES) {
        this.ASSETDES = ASSETDES;
    }

    public String getCREATEBYNAME() {
        return CREATEBYNAME;
    }

    public void setCREATEBYNAME(String CREATEBYNAME) {
        this.CREATEBYNAME = CREATEBYNAME;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getHAZARDLEVEL() {
        return HAZARDLEVEL;
    }

    public void setHAZARDLEVEL(String HAZARDLEVEL) {
        this.HAZARDLEVEL = HAZARDLEVEL;
    }

    public String getJPNUM() {
        return JPNUM;
    }

    public void setJPNUM(String JPNUM) {
        this.JPNUM = JPNUM;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getLOCATIONDES() {
        return LOCATIONDES;
    }

    public void setLOCATIONDES(String LOCATIONDES) {
        this.LOCATIONDES = LOCATIONDES;
    }

    public String getSCHEDSTART() {
        return SCHEDSTART;
    }

    public void setSCHEDSTART(String SCHEDSTART) {
        this.SCHEDSTART = SCHEDSTART;
    }

    public String getSCHEDFINISH() {
        return SCHEDFINISH;
    }

    public void setSCHEDFINISH(String SCHEDFINISH) {
        this.SCHEDFINISH = SCHEDFINISH;
    }

    public String getSTATIONDES() {
        return STATIONDES;
    }

    public void setSTATIONDES(String STATIONDES) {
        this.STATIONDES = STATIONDES;
    }

    public String getUDFAULTDESC() {
        return UDFAULTDESC;
    }

    public void setUDFAULTDESC(String UDFAULTDESC) {
        this.UDFAULTDESC = UDFAULTDESC;
    }

    public String getUDFAULTREPORTNUM() {
        return UDFAULTREPORTNUM;
    }

    public void setUDFAULTREPORTNUM(String UDFAULTREPORTNUM) {
        this.UDFAULTREPORTNUM = UDFAULTREPORTNUM;
    }

    public String getUDREASON() {
        return UDREASON;
    }

    public void setUDREASON(String UDREASON) {
        this.UDREASON = UDREASON;
    }

    public String getUDSTATIONNUM() {
        return UDSTATIONNUM;
    }

    public void setUDSTATIONNUM(String UDSTATIONNUM) {
        this.UDSTATIONNUM = UDSTATIONNUM;
    }

    public String getUDSTATUS() {
        return UDSTATUS;
    }

    public void setUDSTATUS(String UDSTATUS) {
        this.UDSTATUS = UDSTATUS;
    }

    public String getUDWOREQNUM() {
        return UDWOREQNUM;
    }

    public void setUDWOREQNUM(String UDWOREQNUM) {
        this.UDWOREQNUM = UDWOREQNUM;
    }

    public String getUDWORKSCOPE() {
        return UDWORKSCOPE;
    }

    public void setUDWORKSCOPE(String UDWORKSCOPE) {
        this.UDWORKSCOPE = UDWORKSCOPE;
    }

    public String getUDYEAR() {
        return UDYEAR;
    }

    public void setUDYEAR(String UDYEAR) {
        this.UDYEAR = UDYEAR;
    }

    public String getUDYEARPLANNUM() {
        return UDYEARPLANNUM;
    }

    public void setUDYEARPLANNUM(String UDYEARPLANNUM) {
        this.UDYEARPLANNUM = UDYEARPLANNUM;
    }
}
