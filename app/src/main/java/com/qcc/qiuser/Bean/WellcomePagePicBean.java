package com.qcc.qiuser.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class WellcomePagePicBean {

    /**
     * flag : Success
     * msg : http://www.qichengcheng.cn/Uploads/app/index/lALOtGUzYM0Gi80E2g_1242_1675.png
     * data : []
     * num : 1
     */

    private String flag;
    private String msg;
    private int num;
    private List<?> data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
