package com.qcc.qiuser.Activity.kotlinActivity
import android.os.Bundle
import com.google.gson.Gson
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import org.xutils.common.Callback
class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    //搜索方法
    fun search(text:String){
        var param=HashMap<String,Any>()
        param.put("name",text)
        NetUtils.Post(BaseData.SEARCH,param,object :Callback.CommonCallback<String>{
            override fun onFinished() {
             }

            override fun onCancelled(cex: Callback.CancelledException?) {
             }

            override fun onError(ex: Throwable?, isOnCallback: Boolean) {
             }

            override fun onSuccess(result: String?) {

             }

        })
    }
}
