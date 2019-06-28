package br.com.app.androidcleancode.scenes.login;

import java.util.regex.Matcher;

import br.com.app.androidcleancode.api.LoginResponse;
import retrofit2.Response;

interface LoginInteractorInput extends LoginWorkerDelegate {
    void validate(LoginModel.Request request);
}

class LoginInteractor implements LoginInteractorInput {

    LoginPresenterInput output;
    LoginWorkerInput loginWorkerInput;

    private LoginWorkerInput getLoginWorkerInput() {
        if (loginWorkerInput == null) return new LoginWorker(this);
        return loginWorkerInput;
    }

    @Override
    public void validate(LoginModel.Request request) {
        String user = request.getUser();
        String password = request.getPassword();

        Matcher cpfMatcher = Patterns.CPF.matcher(user);
        Matcher emailMatcher = Patterns.EMAIL.matcher(user);
        Matcher passMatcher = Patterns.PASSWORD.matcher(password);

        if((cpfMatcher.matches() || emailMatcher.matches())
                && passMatcher.matches()) {
            getLoginWorkerInput().login(request);
        }
    }

    @Override
    public void onFailure(Throwable t) { }

    @Override
    public void onResponse(Response<LoginResponse> response) {
        LoginModel.Response loginResponse = new LoginModel.Response(response.code(),
                                                                    response.body());

        output.presentLoginData(loginResponse);
    }
}
