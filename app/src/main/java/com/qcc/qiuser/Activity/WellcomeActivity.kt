package com.qcc.qiuser.Activity

import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.WellcomePagePicBean
import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import org.xutils.common.Callback
import org.xutils.x
import java.util.HashMap

//首页欢迎界面 通过java转换的
class WellcomeActivity : BaseActivity() {
    private var headImg: ImageView? = null
    var textTest: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStates()
        setContentView(R.layout.activity_wellcome)
        headImg = findViewById(R.id.welcome_pic) as ImageView
        x.image().bind(headImg, "http://www.qichengcheng.cn/Uploads/app/index/qichengcheng.jpg")
//        getPic()
        testTestNull()
        mHandler.postDelayed({
            toLogin()
            this@WellcomeActivity.finish()
        }, 1500)
    }

    internal var mHandler = Handler()
    private fun toLogin() {
        val intent = Intent(this, HomeTabActivity::class.java)
        startActivity(intent)
    }

    private fun testTestNull() {
        textTest?.let {
            loge(textTest?.text.toString())
        }
    }

    private fun setStates() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = window
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    private fun getPic() {
        NetUtils.Post(BaseData.JIESHAO, HashMap<String, Any>(), object : Callback.CommonCallback<String> {
            override fun onSuccess(result: String) {
                val bean = Gson().fromJson(result, WellcomePagePicBean::class.java)
                x.image().bind(headImg, bean.msg)

            }

            override fun onError(ex: Throwable, isOnCallback: Boolean) {

            }

            override fun onCancelled(cex: Callback.CancelledException) {

            }

            override fun onFinished() {

            }
        })
    }
}
