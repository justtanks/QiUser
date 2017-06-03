package com.qcc.qiuser.kotlintest

import com.google.gson.Gson
import com.qcc.qiuser.Bean.WellcomePagePicBean

/**
 * Created by Administrator on 2017/6/1.
 */
class Test {

    var xfile:String ?= null
    fun showImage(){
//        Gson().fromJson<WellcomePagePicBean>("hello",WellcomePagePicBean)
        xfile="hello"
        print(xfile)
    }
}