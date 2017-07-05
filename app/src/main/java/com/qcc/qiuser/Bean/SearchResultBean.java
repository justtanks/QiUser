package com.qcc.qiuser.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class SearchResultBean {



    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * agent : 河南美誉商标专利事务所有限公司
             * announcementDate :
             * announcementIssue :
             * appDate : 2015-12-04
             * applicantCn : 应城市益新农业科技有限公司
             * currentStatus : 评审分案
             * intCls : 1
             * regDate :
             * regIssue :
             * regNo : 18521050
             * tmImg : c4518fee92dac17f967541ee3bb13223
             * tmName : 哈哈农夫
             */

            private String agent;
            private String announcementDate;
            private String announcementIssue;
            private String appDate;
            private String applicantCn;
            private String currentStatus;
            private String intCls;
            private String regDate;
            private String regIssue;
            private String regNo;
            private String tmImg;
            private String tmName;

            public String getAgent() {
                return agent;
            }

            public void setAgent(String agent) {
                this.agent = agent;
            }

            public String getAnnouncementDate() {
                return announcementDate;
            }

            public void setAnnouncementDate(String announcementDate) {
                this.announcementDate = announcementDate;
            }

            public String getAnnouncementIssue() {
                return announcementIssue;
            }

            public void setAnnouncementIssue(String announcementIssue) {
                this.announcementIssue = announcementIssue;
            }

            public String getAppDate() {
                return appDate;
            }

            public void setAppDate(String appDate) {
                this.appDate = appDate;
            }

            public String getApplicantCn() {
                return applicantCn;
            }

            public void setApplicantCn(String applicantCn) {
                this.applicantCn = applicantCn;
            }

            public String getCurrentStatus() {
                return currentStatus;
            }

            public void setCurrentStatus(String currentStatus) {
                this.currentStatus = currentStatus;
            }

            public String getIntCls() {
                return intCls;
            }

            public void setIntCls(String intCls) {
                this.intCls = intCls;
            }

            public String getRegDate() {
                return regDate;
            }

            public void setRegDate(String regDate) {
                this.regDate = regDate;
            }

            public String getRegIssue() {
                return regIssue;
            }

            public void setRegIssue(String regIssue) {
                this.regIssue = regIssue;
            }

            public String getRegNo() {
                return regNo;
            }

            public void setRegNo(String regNo) {
                this.regNo = regNo;
            }

            public String getTmImg() {
                return tmImg;
            }

            public void setTmImg(String tmImg) {
                this.tmImg = tmImg;
            }

            public String getTmName() {
                return tmName;
            }

            public void setTmName(String tmName) {
                this.tmName = tmName;
            }
        }
    }
}
