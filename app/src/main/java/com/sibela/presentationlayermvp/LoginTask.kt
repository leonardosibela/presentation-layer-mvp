package com.sibela.presentationlayermvp

interface LoginTask {

    interface View {
        fun displayLoading()

        fun displayUserNotFound()

        fun displayInvalidUserOrPassword()

        fun onLoggedIn()
    }

    interface Presenter {
        fun loginUser(email: String, password: String)

        fun onViewDestroyed()
    }
}