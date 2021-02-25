package com.sibela.presentationlayermvp

class LoginPresenter(var view: LoginTask.View?) : LoginTask.Presenter {

    override fun loginUser(email: String, password: String) {

        view?.displayLoading()
        DummyAuth.login(email, password, object : DummyAuth.Callback {

            override fun loginSuccessful() {
                view?.onLoggedIn()
            }

            override fun invalidUser() {
                view?.displayUserNotFound()
            }

            override fun invalidUserOrPassword() {
                view?.displayInvalidUserOrPassword()
            }
        })
    }

    override fun onViewDestroyed() {
        view = null
    }
}