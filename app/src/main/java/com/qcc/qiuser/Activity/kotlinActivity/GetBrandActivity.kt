package com.qcc.qiuser.Activity.kotlinActivity

import android.os.Bundle
import com.google.gson.Gson
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.NetError
import com.qcc.qiuser.Bean.Regist_phoneback

import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import com.qcc.qiuser.Util.StringUtils
import kotlinx.android.synthetic.main.activity_get_brand.*
import org.xutils.common.Callback

//进行商标申请的activity
class GetBrandActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_brand)
        init()
    }

    fun init() {
        getbrand_back.setOnClickListener { _ -> onBackPressed() }
        getbrand_input.setOnClickListener { _ -> inputBrand() }
    }
    //网络提交到服务器 包括商标名称和电话号码 trademark_name/123/user_tel/123
    fun inputBrand() {
        var brandName=getbrand_brandname.text.toString()
        var phoneNum=getbrand_phonenum.text.toString()
        if (brandName==""){
            toast("商标名称不能为空")
            return
        }
        if (phoneNum==""){
            toast("电话号码不能为空")
            return
        }
        if(StringUtils.isPhone(phoneNum)||StringUtils.isTelephone(phoneNum)){

        }else{
            toast("请输入正确的手机号或者电话号码")
            return
        }
        var param=HashMap<String,Any>()
        param.put("trademark_name",brandName)
        param.put("user_tel",phoneNum)
        NetUtils.Post(BaseData.INPUTBRAND,param,object:Callback.CommonCallback<String>{
            override fun onError(ex: Throwable?, isOnCallback: Boolean) {
                toast("注册失败，请检查网络后重试")
            }

            override fun onFinished() {
            }

            override fun onSuccess(result: String?) {
                result?.let {
                    if (result.substring(0,18).contains("Error")){
                        var a:NetError=Gson().fromJson(result,NetError::class.java)
                        toast(a.msg)
                        return
                    }
                    var res:Regist_phoneback= Gson().fromJson(result,Regist_phoneback::class.java)
                    if(res.flag=="Success"){
                        toast(res.msg)
                    }
                }
            }

            override fun onCancelled(cex: Callback.CancelledException?) {

            }
        })
    }
}
