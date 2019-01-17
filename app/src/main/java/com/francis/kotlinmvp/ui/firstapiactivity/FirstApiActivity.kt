package com.francis.kotlinmvp.ui.firstapiactivity

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.kotlinmvp.R
import com.francis.kotlinmvp.base.BaseActivity
import com.francis.kotlinmvp.data.response.CompainRes
import com.francis.kotlinmvp.data.response.postdetails.PostDetailsResponse
import com.francis.kotlinmvp.utils.UiUtils

class FirstApiActivity :BaseActivity(), FirstApiView {
    var presenter: FirstApiPresenter? = null
    var dialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apiactivity)
        ButterKnife.bind(this)
        setInstance()
    }


    private fun setInstance() {
        presenter = FirstApiPresenter()
        presenter?.setView(this)
    }

    @OnClick(R.id.button)
    fun onClickAction(v: View?) {
        when (v?.id) {
            R.id.button -> {
                presenter?.zipOperator()
            }
        }
    }


    override fun showLoading() {
        if (dialog == null) {
            dialog = UiUtils.showLoadingDialog(this, "Loading")
            dialog?.show()
        } else {
            dialog?.show()
        }
    }

    override fun hideLoading() {
        if (dialog != null) dialog?.dismiss()
    }

    override fun showError(errorMsg: String?) {
        UiUtils.showToast(this, errorMsg)
    }


    override fun onApiSuccess(response: PostDetailsResponse?) {
        UiUtils.showToast(this, "Api response is success")
    }

    override fun onZipResponseSuccess(response: CompainRes?) {
        UiUtils.showToast(this, "Api response is success")
    }
}


