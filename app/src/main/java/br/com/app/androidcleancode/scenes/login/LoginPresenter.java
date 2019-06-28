package br.com.app.androidcleancode.scenes.login;

interface LoginPresenterInput {
    void presentLoginData(LoginModel.Response response);
}

class LoginPresenter implements LoginPresenterInput {

    @Override
    public void presentLoginData(LoginModel.Response response) {

    }
}
