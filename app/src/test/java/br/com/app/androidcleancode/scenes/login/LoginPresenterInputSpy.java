package br.com.app.androidcleancode.scenes.login;

public class LoginPresenterInputSpy implements LoginPresenterInput {

    boolean presentWasCalled = false;
    LoginModel.Response reponseCopy;

    @Override
    public void presentLoginData(LoginModel.Response response) {
        presentWasCalled = true;
        reponseCopy = response;
    }
}
