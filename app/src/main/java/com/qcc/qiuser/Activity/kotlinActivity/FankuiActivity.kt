package com.qcc.qiuser.Activity.kotlinActivity

import android.os.Bundle
import com.google.gson.Gson
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.NetError
import com.qcc.qiuser.Bean.Regist_phoneback
import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import com.qcc.qiuser.Util.SystemSetting
import kotlinx.android.synthetic.main.activity_fankui.*
import org.xutils.common.Callback
import java.util.HashMap

/**
 * 向后台反馈问题的activity
 */
class FankuiActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fankui)
        fankui_back.setOnClickListener { _ -> onBackPressed() }
        fankui_tijiao.setOnClickListener { _ -> tijiao() }
    }

    internal var ss = SystemSetting(this)
    private fun tijiao() {
        val params = HashMap<String, Any>()
        var s = fankui_wenti.text.toString()
        if (s.equals("")) {
            toast("请输入反馈内容")
            return
        }
        params.put("name", s)
        params.put("id", ss.showPhone())
        NetUtils.Post(BaseData.FANKUI, params, object : Callback.CommonCallback<String> {
            override fun onSuccess(result: String) {
                if (result.substring(0, 18).contains("Error")) {
                    val erro = Gson().fromJson(result, NetError::class.java)
                    toast(erro.msg)
                } else {
                    val bee = Gson().fromJson(result, Regist_phoneback::class.java)
                    toast(bee.msg)
                }
            }

            override fun onError(ex: Throwable, isOnCallback: Boolean) {
                toast(resources.getString(R.string.net_error))
            }

            override fun onCancelled(cex: Callback.CancelledException) {

            }

            override fun onFinished() {

            }
        })
    }
}
