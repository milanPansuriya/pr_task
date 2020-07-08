package com.milan.myapplication.ui.main.presenter

import com.milan.myapplication.base.BasePresenter
import com.milan.myapplication.base.SchedulerProvider
import com.milan.myapplication.ui.main.interector.MainMVPInteractor
import com.milan.myapplication.ui.main.view.MainMVPView
import com.milan.myapplication.utils.Utils
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), MainMVPPresenter<V, I> {
    override fun getPostList() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(
                it.getPostList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ postRespo ->
                        getView()?.let {
                            it.hideProgress()
                            it.setPostData(postRespo)

                        }
                    }, { error ->
                        getView()?.let {
                            it.hideProgress()
                            it.showValidationMessage(Utils.getErrorMessage(error))
                        }
                    })
            )
        }
    }
}

