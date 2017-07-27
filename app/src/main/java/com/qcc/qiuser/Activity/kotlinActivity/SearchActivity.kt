package com.qcc.qiuser.Activity.kotlinActivity

 import android.content.Intent
 import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.gson.Gson
import com.qcc.qiuser.Adapter.SearchResultAdapter
import com.qcc.qiuser.Base.BaseActivity
import com.qcc.qiuser.Base.BaseData
import com.qcc.qiuser.Bean.SearchResultBean
import com.qcc.qiuser.R
import com.qcc.qiuser.Util.NetUtils
import kotlinx.android.synthetic.main.activity_search.*
import org.xutils.common.Callback

//展示搜索结果的activity
class SearchActivity : BaseActivity(), TextView.OnEditorActionListener {

    var adapter:SearchResultAdapter?=null
    var searchDatas:SearchResultBean.ResultBean?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        search_back.setOnClickListener { _ -> onBackPressed() }
        search_text.setOnEditorActionListener(this)
        init()
    }

    fun init() {
        if(adapter==null){
            adapter=SearchResultAdapter(ArrayList<SearchResultBean.ResultBean.DataBean>(),this@SearchActivity)
            search_lv.adapter=adapter
        }
        search_bt.setOnClickListener { _ -> searchResult() }
        search_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var text=search_text.text.toString()
                if(text.equals("")||null==text){
                    search_lv.visibility= View.GONE
                    search_relative1.visibility=View.VISIBLE
                    search_relative2.visibility=View.GONE
                }
             }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             }
        })
        search_lv.setOnItemClickListener { parent, view, position, id -> toResult(position) }
    }
    //跳转到搜索详情界面
    fun toResult(position:Int){
        var intent=Intent(this,SearchResultActivity::class.java)
        var bundle=Bundle()
        bundle.putString("trademark_id",searchDatas?.data?.get(position)?.regNo)
        bundle.putString("trademark_num",searchDatas?.data?.get(position)?.intCls)
        intent.putExtra("search",bundle)
       startActivity(intent)
    }
// 服务器请求数据
    fun searchResult() {
        var s:String=search_text.text.toString()
        if(s.equals("")){
            toast("请输入搜索内容")
            return
        }
        val params = java.util.HashMap<String, Any>()
        params.put("name",s)
        NetUtils.Post(BaseData.SEARCH,params,object : Callback.CommonCallback<String>{
            override fun onSuccess(result: String?) {
                var result:SearchResultBean= Gson().fromJson(result,SearchResultBean::class.java)
                if(result.reason.equals("Success")){
                    if (result.result.data.size==0||result.result.data.isEmpty()){
                        //没有搜索结果
                        search_lv.visibility= View.GONE
                        search_relative1.visibility=View.GONE
                        search_relative2.visibility=View.VISIBLE

                    }else{
                        //展示搜索结果并显示listview 隐藏其他两个东西
                        search_lv.visibility= View.VISIBLE
                        search_relative1.visibility=View.GONE
                        search_relative2.visibility=View.GONE
                        searchDatas=result.result
                        adapter?.setDataBeens(result.result.data)
                        adapter?.notifyDataSetChanged()

                    }
                }else{
                    toast("搜索出现问题，请重试")
                }
            }

            override fun onCancelled(cex: Callback.CancelledException?) {

            }

            override fun onFinished() {

            }

            override fun onError(ex: Throwable?, isOnCallback: Boolean) {
              toast("网络错误")
            }

        })
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            var manager: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
            searchResult()
            return true
        }
        return false
    }


}
