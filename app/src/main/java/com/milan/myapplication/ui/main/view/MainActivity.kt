package com.milan.myapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milan.myapplication.R
import com.milan.myapplication.base.BaseActivity
import com.milan.myapplication.listner.OnRVItemClickListener
import com.milan.myapplication.ui.main.interector.MainMVPInteractor
import com.milan.myapplication.ui.main.model.PostRespo
import com.milan.myapplication.ui.main.presenter.MainMVPPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, OnRVItemClickListener {
    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    lateinit var postItemAdapter: PostItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        recData.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        presenter.getPostList()
    }

    override fun showProgress() {
        pgbLoading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        pgbLoading.visibility = View.GONE
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun showValidationMessage(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun setPostData(postRespo: PostRespo) {
        postItemAdapter = PostItemAdapter(this@MainActivity, postRespo, this)
        recData.adapter = postItemAdapter
    }

    override fun onItemClick(v: View, position: Int) {

    }
}