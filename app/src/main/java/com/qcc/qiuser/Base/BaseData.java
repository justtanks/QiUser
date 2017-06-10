package com.qcc.qiuser.Base;

/**
 *存储url
 */
public class BaseData {
    public static final String BASEURL = "http://121.199.32.4:8088";
    public static final String BASEPOSITON = "http://www.qichengcheng.cn";
    //短信验证
    public static final String DUANXINYANZHENG = BASEURL + "/index.php/Home/Index/sendcode/";
    //显示代理人列表http://www.qichengcheng.cn/index.php/Home/Waiter/waiter_list
    public static final String DAILILIEBIAO = BASEURL + "/index.php/Home/Waiter/waiter_list";
    //介绍页面图片http://www.qichengcheng.cn/index.php/Home/App/qichengcheng
    public static final String JIESHAO = BASEURL + "/index.php/Home/App/qichengcheng";
    //用户端登陆接口 http://www.qichengcheng.cn/Home/App/denglu/user/18266142739/password/222222
    public static final String USERlOGIN = BASEURL + "/Home/App/denglu";
    //http://www.qichengcheng.cn/Home/App/zhuce/user/18266142739/password/222222
    public static final String USERREGIST = BASEURL + "/Home/App/zhuce/";
    //问题反馈接口http://www.qichengcheng.cn/Home/App/fankui/name/neirong/id/18266142739
    public  static  final  String FANKUI=BASEURL+"/Home/App/fankui/";
    // 搜索接口I http://www.qichengcheng.cn/Home/App/Shangbiao_chaxun/name/哈哈
    public  static  final  String SEARCH=BASEURL+"/Home/App/Shangbiao_chaxun";
    //搜索返回图片前缀 http://pic.tmkoo.com/pic.php?s=0&zch=
    public static  final  String IMGPRO="http://pic.tmkoo.com/pic.php?s=0&zch=";
}
