package com.qcc.qiuser.Activity.kotlinActivity

import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Bundle
import android.view.WindowManager
import com.qcc.qiuser.Activity.HomeTabActivity
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import kotlinx.android.synthetic.main.activity_wellcome.*
import org.xutils.common.Callback
import org.xutils.x
import java.util.HashMap


//首页欢迎界面 通过java转换的
class WellcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStates()
        setContentView(R.layout.activity_wellcome)
        x.image().bind(welcome_pic, "http://www.qichengcheng.cn/Uploads/app/index/qichengcheng.jpg")
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

    private fun setStates() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = window
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

//    private fun getPic() {
//        NetUtils.Post(BaseData.JIESHAO, HashMap<String, Any>(), object : Callback.CommonCallback<String> {
//            override fun onCancelled(cex: Callback.CancelledException?) {
//            }
//
//            override fun onFinished() {
//
//            }
//
//            override fun onSuccess(result: String?) {
//
//            }
//
//            override fun onError(ex: Throwable?, isOnCallback: Boolean) {
//
//            }
//
//        })
//    }
}
