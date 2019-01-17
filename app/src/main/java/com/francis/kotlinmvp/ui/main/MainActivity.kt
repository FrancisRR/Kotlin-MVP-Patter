package com.francis.kotlinmvp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.kotlinmvp.R
import com.francis.kotlinmvp.base.BaseActivity
import com.francis.kotlinmvp.ui.firstapiactivity.FirstApiActivity
import com.francis.kotlinmvp.ui.secondapiactivity.SecondApiActivity

class MainActivity : AppCompatActivity() {


    private val TAG: String? = this::class.java.simpleName;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }


    @OnClick(
        R.id.btnFirst,
        R.id.btnSecond,
        R.id.btVariable
    )
    internal fun clickEvent(v: View?) {
        when (v?.id) {
            R.id.btnFirst -> {
                startActivity(Intent(this, FirstApiActivity::class.java))
            }
            R.id.btnSecond -> {
                startActivity(Intent(this, SecondApiActivity::class.java))
            }
        }
    }


}
