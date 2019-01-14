package com.francis.kotlinmvp.app

public interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(errorMsg: String?)
}