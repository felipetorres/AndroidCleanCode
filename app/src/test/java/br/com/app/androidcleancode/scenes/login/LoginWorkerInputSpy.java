package br.com.app.androidcleancode.scenes.login;

import br.com.app.androidcleancode.api.LoginResponse;
import retrofit2.Response;

public class LoginWorkerInputSpy implements LoginWorkerInput {

    boolean loginWasCalled = false;
    private LoginWorkerDelegate delegate;

    LoginWorkerInputSpy(LoginWorkerDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void login(LoginModel.Request request) {
        loginWasCalled = true;
        Response<LoginResponse> fakeResponse = Response.success(200, new LoginResponse());
        delegate.onResponse(fakeResponse);
    }
}
