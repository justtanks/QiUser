package com.qcc.qiuser.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 *  返回所有的代理人信息
 */

public class WaitersBean implements Serializable {
    private String flag;
    private String msg;
    private int num;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private List<personDataBean> zonghe;
        private List<personDataBean> good_say;
        private List<personDataBean> order;

        public List<personDataBean> getZonghe() {
            return zonghe;
        }

        public void setZonghe(List<personDataBean> zonghe) {
            this.zonghe = zonghe;
        }

        public List<personDataBean> getGood_say() {
            return good_say;
        }

        public void setGood_say(List<personDataBean> good_say) {
            this.good_say = good_say;
        }

        public List<personDataBean> getOrder() {
            return order;
        }

        public void setOrder(List<personDataBean> order) {
            this.order = order;
        }

        public static class personDataBean implements Serializable {
            /**
             * waiter_id : 71
             * waiter_name : 刘超
             * waiter_password : 870916
             * waiter_sex : 1
             * waiter_id_card : 371121198801072978
             * waiter_phone_number : 13365443879
             * waiter_pic : /Uploads/touxiang/liuchao.jpg
             * waiter_address : 山东省德州市
             * waiter_work_time : 1
             * waiter_good_work : [{"id":"2236","waiter_id":"71","good_work_id":"1"},{"id":"2237","waiter_id":"71","good_work_id":"9"},{"id":"2238","waiter_id":"71","good_work_id":"12"},{"id":"2239","waiter_id":"71","good_work_id":"13"},{"id":"2240","waiter_id":"71","good_work_id":"15"},{"id":"2241","waiter_id":"71","good_work_id":"16"},{"id":"2242","waiter_id":"71","good_work_id":"17"},{"id":"2243","waiter_id":"71","good_work_id":"26"}]
             * good_say : 0
             * is_renzheng : 1
             * waiter_qq : 1335116136
             * waiter_pinglun : [{"id":"12","waiter_id":"71","user_id":"8","order_num":"1488245274","waiter_evaluate":"服务超棒！赞一个！","evaluate_type":"1"},{"id":"14","waiter_id":"71","user_id":"8","order_num":"1490606640","waiter_evaluate":"服务超棒！赞一个！","evaluate_type":"1"}]
             */

            private String waiter_id;
            private String waiter_name;
            private String waiter_password;
            private String waiter_sex;
            private String waiter_id_card;
            private String waiter_phone_number;
            private String waiter_pic;
            private String waiter_address;
            private String waiter_work_time;
            private String good_say;
            private String is_renzheng;
            private String waiter_qq;
            private List<WaiterGoodWorkBean> waiter_good_work;
            private List<WaiterPinglunBean> waiter_pinglun;

            public String getWaiter_id() {
                return waiter_id;
            }

            public void setWaiter_id(String waiter_id) {
                this.waiter_id = waiter_id;
            }

            public String getWaiter_name() {
                return waiter_name;
            }

            public void setWaiter_name(String waiter_name) {
                this.waiter_name = waiter_name;
            }

            public String getWaiter_password() {
                return waiter_password;
            }

            public void setWaiter_password(String waiter_password) {
                this.waiter_password = waiter_password;
            }

            public String getWaiter_sex() {
                return waiter_sex;
            }

            public void setWaiter_sex(String waiter_sex) {
                this.waiter_sex = waiter_sex;
            }

            public String getWaiter_id_card() {
                return waiter_id_card;
            }

            public void setWaiter_id_card(String waiter_id_card) {
                this.waiter_id_card = waiter_id_card;
            }

            public String getWaiter_phone_number() {
                return waiter_phone_number;
            }

            public void setWaiter_phone_number(String waiter_phone_number) {
                this.waiter_phone_number = waiter_phone_number;
            }

            public String getWaiter_pic() {
                return waiter_pic;
            }

            public void setWaiter_pic(String waiter_pic) {
                this.waiter_pic = waiter_pic;
            }

            public String getWaiter_address() {
                return waiter_address;
            }

            public void setWaiter_address(String waiter_address) {
                this.waiter_address = waiter_address;
            }

            public String getWaiter_work_time() {
                return waiter_work_time;
            }

            public void setWaiter_work_time(String waiter_work_time) {
                this.waiter_work_time = waiter_work_time;
            }

            public String getGood_say() {
                return good_say;
            }

            public void setGood_say(String good_say) {
                this.good_say = good_say;
            }

            public String getIs_renzheng() {
                return is_renzheng;
            }

            public void setIs_renzheng(String is_renzheng) {
                this.is_renzheng = is_renzheng;
            }

            public String getWaiter_qq() {
                return waiter_qq;
            }

            public void setWaiter_qq(String waiter_qq) {
                this.waiter_qq = waiter_qq;
            }

            public List<WaiterGoodWorkBean> getWaiter_good_work() {
                return waiter_good_work;
            }

            public void setWaiter_good_work(List<WaiterGoodWorkBean> waiter_good_work) {
                this.waiter_good_work = waiter_good_work;
            }

            public List<WaiterPinglunBean> getWaiter_pinglun() {
                return waiter_pinglun;
            }

            public void setWaiter_pinglun(List<WaiterPinglunBean> waiter_pinglun) {
                this.waiter_pinglun = waiter_pinglun;
            }

            public static class WaiterGoodWorkBean implements Serializable{
                /**
                 * id : 2236
                 * waiter_id : 71
                 * good_work_id : 1
                 */

                private String id;
                private String waiter_id;
                private String good_work_id;
                private  String side_name;
                private  String side_belong_id;
                private  String side_add_time;
                private  String side_price;
                private  String panter_price;
                private  String percentage_price;
                private  String side_pic;
                private String side_jieshao_pic;
                private  String weixin_pic;
                private  String weixin_js_pic;
                private  String side_nav;

                public String getSide_name() {
                    return side_name;
                }

                public void setSide_name(String side_name) {
                    this.side_name = side_name;
                }

                public String getSide_belong_id() {
                    return side_belong_id;
                }

                public void setSide_belong_id(String side_belong_id) {
                    this.side_belong_id = side_belong_id;
                }

                public String getSide_add_time() {
                    return side_add_time;
                }

                public void setSide_add_time(String side_add_time) {
                    this.side_add_time = side_add_time;
                }

                public String getSide_price() {
                    return side_price;
                }

                public void setSide_price(String side_price) {
                    this.side_price = side_price;
                }

                public String getPanter_price() {
                    return panter_price;
                }

                public void setPanter_price(String panter_price) {
                    this.panter_price = panter_price;
                }

                public String getPercentage_price() {
                    return percentage_price;
                }

                public void setPercentage_price(String percentage_price) {
                    this.percentage_price = percentage_price;
                }

                public String getSide_pic() {
                    return side_pic;
                }

                public void setSide_pic(String side_pic) {
                    this.side_pic = side_pic;
                }

                public String getSide_jieshao_pic() {
                    return side_jieshao_pic;
                }

                public void setSide_jieshao_pic(String side_jieshao_pic) {
                    this.side_jieshao_pic = side_jieshao_pic;
                }

                public String getWeixin_pic() {
                    return weixin_pic;
                }

                public void setWeixin_pic(String weixin_pic) {
                    this.weixin_pic = weixin_pic;
                }

                public String getWeixin_js_pic() {
                    return weixin_js_pic;
                }

                public void setWeixin_js_pic(String weixin_js_pic) {
                    this.weixin_js_pic = weixin_js_pic;
                }

                public String getSide_nav() {
                    return side_nav;
                }

                public void setSide_nav(String side_nav) {
                    this.side_nav = side_nav;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getWaiter_id() {
                    return waiter_id;
                }

                public void setWaiter_id(String waiter_id) {
                    this.waiter_id = waiter_id;
                }

                public String getGood_work_id() {
                    return good_work_id;
                }

                public void setGood_work_id(String good_work_id) {
                    this.good_work_id = good_work_id;
                }
            }

            public static class WaiterPinglunBean implements Serializable{
                /**
                 * id : 12
                 * waiter_id : 71
                 * user_id : 8
                 * order_num : 1488245274
                 * waiter_evaluate : 服务超棒！赞一个！
                 * evaluate_type : 1
                 */

                private String id;
                private String waiter_id;
                private String user_id;
                private String order_num;
                private String waiter_evaluate;
                private String evaluate_type;


                private String user_name;
                private String user_telphone;
                private String user_password;
                private String user_head_pic;
                private String tjr_tel_phone;
                private String register_date;

                private String user_sex;
                private String belong_industry;
                private String user_qq;
                private String user_email;
                private String second_user_name;
                private String second_user_tel;
                private String user_address;

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getUser_telphone() {
                    return user_telphone;
                }

                public void setUser_telphone(String user_telphone) {
                    this.user_telphone = user_telphone;
                }

                public String getUser_password() {
                    return user_password;
                }

                public void setUser_password(String user_password) {
                    this.user_password = user_password;
                }

                public String getUser_head_pic() {
                    return user_head_pic;
                }

                public void setUser_head_pic(String user_head_pic) {
                    this.user_head_pic = user_head_pic;
                }

                public String getTjr_tel_phone() {
                    return tjr_tel_phone;
                }

                public void setTjr_tel_phone(String tjr_tel_phone) {
                    this.tjr_tel_phone = tjr_tel_phone;
                }

                public String getRegister_date() {
                    return register_date;
                }

                public void setRegister_date(String register_date) {
                    this.register_date = register_date;
                }

                public String getUser_sex() {
                    return user_sex;
                }

                public void setUser_sex(String user_sex) {
                    this.user_sex = user_sex;
                }

                public String getBelong_industry() {
                    return belong_industry;
                }

                public void setBelong_industry(String belong_industry) {
                    this.belong_industry = belong_industry;
                }

                public String getUser_qq() {
                    return user_qq;
                }

                public void setUser_qq(String user_qq) {
                    this.user_qq = user_qq;
                }

                public String getUser_email() {
                    return user_email;
                }

                public void setUser_email(String user_email) {
                    this.user_email = user_email;
                }

                public String getSecond_user_name() {
                    return second_user_name;
                }

                public void setSecond_user_name(String second_user_name) {
                    this.second_user_name = second_user_name;
                }

                public String getSecond_user_tel() {
                    return second_user_tel;
                }

                public void setSecond_user_tel(String second_user_tel) {
                    this.second_user_tel = second_user_tel;
                }

                public String getUser_address() {
                    return user_address;
                }

                public void setUser_address(String user_address) {
                    this.user_address = user_address;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getWaiter_id() {
                    return waiter_id;
                }

                public void setWaiter_id(String waiter_id) {
                    this.waiter_id = waiter_id;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getOrder_num() {
                    return order_num;
                }

                public void setOrder_num(String order_num) {
                    this.order_num = order_num;
                }

                public String getWaiter_evaluate() {
                    return waiter_evaluate;
                }

                public void setWaiter_evaluate(String waiter_evaluate) {
                    this.waiter_evaluate = waiter_evaluate;
                }

                public String getEvaluate_type() {
                    return evaluate_type;
                }

                public void setEvaluate_type(String evaluate_type) {
                    this.evaluate_type = evaluate_type;
                }
            }
        }

    }
}
