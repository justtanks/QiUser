package com.qcc.qiuser.Bean;

import java.util.List;

/**
 * 短信验证返回的数据
 */

public class Regist_phoneback {

    /**
     * flag : Success
     * msg : 6151
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
