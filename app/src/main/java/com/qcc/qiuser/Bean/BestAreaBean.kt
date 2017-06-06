package com.qcc.qiuser.Bean

/**
 * Created by Administrator on 2017/6/5.
 */

class BestAreaBean {



    var flag: String? = null
    var num: Int = 0
    var msg: List<MsgBean>? = null
    var data: List<*>? = null

    class MsgBean {
        var sid: String? = null
        var name: String? = null
        var time: String? = null
        var sid_side: List<SidSideBean>? = null

        class SidSideBean {
            /**
             * id : 1
             * side_name : 普通注册
             * side_belong_id : 1
             * side_add_time : 2016-12-27 11:34:09
             * side_price : 597
             * panter_price : 100
             * percentage_price : 50
             * side_pic : /Public/Home/img/side/097add3c3aff835d3da370ceef856c19.jpg
             * side_jieshao_pic : /Public/Home/img/sides/putongzhuce.png
             * weixin_pic : /Public/Home/css/weixin/image/somal/putong.png
             * weixin_js_pic : /Public/Home/css/weixin/image/somal/putongzhuce.png
             * side_nav : 代理人全程托管式服务，实时同步官方系统，24小时拿到官方申请号。
             */

            var id: String? = null
            var side_name: String? = null
            var side_belong_id: String? = null
            var side_add_time: String? = null
            var side_price: String? = null
            var panter_price: String? = null
            var percentage_price: String? = null
            var side_pic: String? = null
            var side_jieshao_pic: String? = null
            var weixin_pic: String? = null
            var weixin_js_pic: String? = null
            var side_nav: String? = null
        }
    }
}
