package com.qcc.qiuser.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class SearchItemBean {
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

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * addressCn : 湖北省应城市育才南路137号
             * addressEn :
             * agent : 河南美誉商标专利事务所有限公司
             * announcementDate :
             * announcementIssue :
             * appDate : 2015-12-04
             * applicantCn : 应城市益新农业科技有限公司
             * applicantEn :
             * applicantOther1 :
             * applicantOther2 :
             * category : 一般
             * color : 否
             * flow : [{"code":"0","flowDate":"2015-12-04","flowName":"申请收文"},{"code":"0","flowDate":"2016-04-19","flowName":"等待受理通知书发文"},{"code":"0","flowDate":"2016-11-10","flowName":"等待驳回通知发文"},{"code":"0","flowDate":"2016-12-06","flowName":"申请收文"},{"code":"0","flowDate":"2017-04-11","flowName":"评审分案"}]
             * gjzcrq :
             * goods : [{"beDeleted":"false","goodsCode":"0109","goodsName":"肥料制剂"},{"beDeleted":"false","goodsCode":"0109","goodsName":"土壤调节制剂"},{"beDeleted":"false","goodsCode":"0109","goodsName":"植物肥料"},{"beDeleted":"false","goodsCode":"0109","goodsName":"混合肥料"},{"beDeleted":"false","goodsCode":"0109","goodsName":"海藻（肥料）"},{"beDeleted":"false","goodsCode":"0109","goodsName":"肥料"},{"beDeleted":"false","goodsCode":"0109","goodsName":"氮肥"},{"beDeleted":"false","goodsCode":"0109","goodsName":"腐殖质表层肥"},{"beDeleted":"false","goodsCode":"0109","goodsName":"农业用肥"},{"beDeleted":"false","goodsCode":"0109","goodsName":"盐类（肥料）"}]
             * hqzdrq :
             * id : 17861249
             * idCardNo :
             * intCls : 1
             * privateDate : 至
             * regDate :
             * regIssue :
             * regNo : 18521050
             * remainCount : 32038
             * tmImg : c4518fee92dac17f967541ee3bb13223
             * tmName : 哈哈农夫
             * yxqrq :
             */

            private String addressCn;
            private String addressEn;
            private String agent;
            private String announcementDate;
            private String announcementIssue;
            private String appDate;
            private String applicantCn;
            private String applicantEn;
            private String applicantOther1;
            private String applicantOther2;
            private String category;
            private String color;
            private String gjzcrq;
            private String hqzdrq;
            private String id;
            private String idCardNo;
            private String intCls;
            private String privateDate;
            private String regDate;
            private String regIssue;
            private String regNo;
            private String remainCount;
            private String tmImg;
            private String tmName;
            private String yxqrq;
            private List<FlowBean> flow;
            private List<GoodsBean> goods;

            public String getAddressCn() {
                return addressCn;
            }

            public void setAddressCn(String addressCn) {
                this.addressCn = addressCn;
            }

            public String getAddressEn() {
                return addressEn;
            }

            public void setAddressEn(String addressEn) {
                this.addressEn = addressEn;
            }

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

            public String getApplicantEn() {
                return applicantEn;
            }

            public void setApplicantEn(String applicantEn) {
                this.applicantEn = applicantEn;
            }

            public String getApplicantOther1() {
                return applicantOther1;
            }

            public void setApplicantOther1(String applicantOther1) {
                this.applicantOther1 = applicantOther1;
            }

            public String getApplicantOther2() {
                return applicantOther2;
            }

            public void setApplicantOther2(String applicantOther2) {
                this.applicantOther2 = applicantOther2;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getGjzcrq() {
                return gjzcrq;
            }

            public void setGjzcrq(String gjzcrq) {
                this.gjzcrq = gjzcrq;
            }

            public String getHqzdrq() {
                return hqzdrq;
            }

            public void setHqzdrq(String hqzdrq) {
                this.hqzdrq = hqzdrq;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIdCardNo() {
                return idCardNo;
            }

            public void setIdCardNo(String idCardNo) {
                this.idCardNo = idCardNo;
            }

            public String getIntCls() {
                return intCls;
            }

            public void setIntCls(String intCls) {
                this.intCls = intCls;
            }

            public String getPrivateDate() {
                return privateDate;
            }

            public void setPrivateDate(String privateDate) {
                this.privateDate = privateDate;
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

            public String getRemainCount() {
                return remainCount;
            }

            public void setRemainCount(String remainCount) {
                this.remainCount = remainCount;
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

            public String getYxqrq() {
                return yxqrq;
            }

            public void setYxqrq(String yxqrq) {
                this.yxqrq = yxqrq;
            }

            public List<FlowBean> getFlow() {
                return flow;
            }

            public void setFlow(List<FlowBean> flow) {
                this.flow = flow;
            }

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class FlowBean {
                /**
                 * code : 0
                 * flowDate : 2015-12-04
                 * flowName : 申请收文
                 */

                private String code;
                private String flowDate;
                private String flowName;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getFlowDate() {
                    return flowDate;
                }

                public void setFlowDate(String flowDate) {
                    this.flowDate = flowDate;
                }

                public String getFlowName() {
                    return flowName;
                }

                public void setFlowName(String flowName) {
                    this.flowName = flowName;
                }
            }

            public static class GoodsBean {
                /**
                 * beDeleted : false
                 * goodsCode : 0109
                 * goodsName : 肥料制剂
                 */

                private String beDeleted;
                private String goodsCode;
                private String goodsName;

                public String getBeDeleted() {
                    return beDeleted;
                }

                public void setBeDeleted(String beDeleted) {
                    this.beDeleted = beDeleted;
                }

                public String getGoodsCode() {
                    return goodsCode;
                }

                public void setGoodsCode(String goodsCode) {
                    this.goodsCode = goodsCode;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }
            }
        }
    }
}
