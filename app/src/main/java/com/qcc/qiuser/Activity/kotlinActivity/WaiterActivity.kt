package com.qcc.qiuser.Activity.kotlinActivity

import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.WaitersBean
import com.qcc.qiuser.R
import org.xutils.x
import kotlinx.android.synthetic.main.activity_waiter.*

/**
 * Created by Administrator on 2017/5/8.
 * 展示代理人详细信息
 */

class WaiterActivity : BaseActivity() {
    var mPersonDataBean: WaitersBean.DataBean.personDataBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiter)
        init()
    }

    fun init() {
        mPersonDataBean = intent.getSerializableExtra("waiterdata") as WaitersBean.DataBean.personDataBean
        waiter_name.text = mPersonDataBean?.waiter_name
        x.image().bind(waiter_head, BaseData.BASEURL + mPersonDataBean?.waiter_pic)
        waitermsg_back.setOnClickListener { _ -> onBackPressed() }
        waiter_jingyan.text = mPersonDataBean?.waiter_work_time
        waiter_location.text = mPersonDataBean?.waiter_address
        var judges = mPersonDataBean?.waiter_pinglun
        judges?.let {
            for (se in judges) {
                var s = StringBuffer(se.user_telphone)
                s.replace(3, 7, "****")
                initPinglun(s.toString(), se.waiter_evaluate)
            }
        }
        var shanchang = mPersonDataBean?.waiter_good_work
        shanchang?.let {
            for (hs in shanchang) {
                initBestArea(hs.side_name)
            }
        }

    }

    private fun initPinglun(username: String, pinglun: String) {
        val view = layoutInflater.inflate(R.layout.item_waiter_judge, waiter_judgecontainer, false)
        val name = view.findViewById(R.id.judge_name) as TextView
        val judge = view.findViewById(R.id.judge_content) as TextView
        val ratingBar = view.findViewById(R.id.judge_start) as RatingBar
        val stars = ratingBar.progressDrawable as LayerDrawable
        stars.getDrawable(2).setColorFilter(resources.getColor(R.color.maincolor), PorterDuff.Mode.SRC_ATOP)  //设置星星颜色
        name.text = username
        judge.text = pinglun
        waiter_judgecontainer.addView(view)
    }

    //初始化所有擅长领域的button
    private fun initBestArea(text: String) {
        val button = Button(applicationContext)
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0)
        button.layoutParams = params
        button.setBackgroundResource(R.mipmap.waiter_btback)
        button.text = text
        button.gravity = Gravity.CENTER
        button.textSize = 8f
        button.setTextColor(resources.getColor(R.color.bestareatextcolor))
        waiter_bestarea.addView(button)
    }
}
