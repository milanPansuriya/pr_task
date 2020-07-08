package com.milan.myapplication.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private lateinit var rxPermissions: RxPermissions
    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)


    }

    override fun hideProgress() {
    }

    override fun showProgress() {

    }

    @SuppressLint("CheckResult")
    open fun checkPermission(
        permissions: Array<String?>,
        permissionCallback: permissionCallback
    ) {
        rxPermissions = RxPermissions(this)
        val subscribe = rxPermissions.requestEach(*permissions)
            .subscribe(
                { permission: Permission ->
                    if (permission.granted) {
                        permissionCallback.onPemissionGiven(permission)
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        permissionCallback.onPermissionDeny(permission)
                    } else {
                        permissionCallback.onPermissionDenyWithNever(permission)
                    }
                },
                { t: Throwable? -> }
            ) {}
    }

    private fun performDI() = AndroidInjection.inject(this)


    interface permissionCallback {
        fun onPemissionGiven(permission: Permission)
        fun onPermissionDeny(permission: Permission)
        fun onPermissionDenyWithNever(permission: Permission)
    }
}