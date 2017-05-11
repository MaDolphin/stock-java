package com.dolphin.entity;

/**
 * Created by I337852 on 5/11/2017.
 */
public class RestHistoryData {
    private String vl;
    private String ccode;
    private String tag;
    private String cname;

    public RestHistoryData() {
        super();
    }

    public RestHistoryData(String vl, String ccode, String tag, String cname) {
        this.vl = vl;
        this.ccode = ccode;
        this.tag = tag;
        this.cname = cname;
    }

    public String getVl() {
        return vl;
    }

    public void setVl(String vl) {
        this.vl = vl;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
