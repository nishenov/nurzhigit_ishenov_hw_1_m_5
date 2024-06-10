package com.example.nurzhigit_ishenov_hw_1_m_5

class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun onPlusClicked() {
        model.plus()
        view?.updateCount(model.getResult())

        if (model.getResult() == 10) {
            view?.showToast("Поздравляем")
        } else if (model.getResult() == 15) {
            view?.setTextColorGreen()
        } else {
            view?.setTextColorBlack()
        }
    }

    fun onMinusClicked() {
        model.minus()
        view?.updateCount(model.getResult())

        if (model.getResult() == 10) {
            view?.showToast("Поздравляем")
        } else if (model.getResult() == 15) {
            view?.setTextColorGreen()
        } else {
            view?.setTextColorBlack()
        }
    }

    fun detachView() {
        this.view = null
    }

}