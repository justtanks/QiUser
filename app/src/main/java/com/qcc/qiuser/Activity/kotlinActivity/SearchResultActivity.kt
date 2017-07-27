package com.qcc.qiuser.Activity.kotlinActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.SearchItemBean

import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import kotlinx.android.synthetic.main.activity_search_result.*
import org.xutils.common.Callback
import org.xutils.x

class SearchResultActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        init()
    }
    private fun init(){
        result_back.setOnClickListener { _->onBackPressed() }
        var bundle=intent.getBundleExtra("search")
        var trademark_id=bundle.get("trademark_id")
        var trademark_num=bundle.get("trademark_num")
        val params = java.util.HashMap<String, Any>()
        params.put("trademark_id",trademark_id)
        params.put("trademark_num",trademark_num)
        NetUtils.Post(BaseData.XIANGQING,params,object :Callback.CommonCallback<String>{
            override fun onCancelled(cex: Callback.CancelledException?) {

            }

            override fun onSuccess(result: String?) {
                var result:SearchItemBean=Gson().fromJson(result,SearchItemBean::class.java)
                x.image().bind(result_img,BaseData.IMGPRO+result.result.data.tmImg)
                result_name.text=result.result.data.tmName
                result_title.text=result.result.data.tmName
                result_num.text=result.result.data.regNo
                result_leibie.text="第"+result.result.data.intCls+"类"
                result_per.text=result.result.data.applicantCn
                result_local.text=result.result.data.addressCn
                result_qixian.text=result.result.data.privateDate
                var service:StringBuffer= StringBuffer()
                for ( x in result.result.data.goods ){
                    service.append(x.goodsCode).append("-").append(x.goodsName).append(";")
                }
                result_fuwuxiangmu.text=service.subSequence(0,service.length-1).toString()
                result_shenqingjigou.text=result.result.data.agent
                for (x in result.result.data.flow){
                    var s:TextView= TextView(this@SearchResultActivity)
                    s.text=x.flowDate+"---->"+x.flowName
                    s.setTextColor(resources.getColor(R.color.gray))
                    result_baozi.addView(s)
                }

            }

            override fun onError(ex: Throwable?, isOnCallback: Boolean) {

            }

            override fun onFinished() {

            }

        })

    }

}
