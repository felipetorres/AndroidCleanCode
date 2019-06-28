package br.com.app.androidcleancode.scenes.login;

import androidx.annotation.NonNull;
import br.com.app.androidcleancode.api.LoginResponse;
import br.com.app.androidcleancode.api.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface LoginWorkerInput {
    void login(LoginModel.Request request);
}

interface LoginWorkerDelegate {
    void onFailure(Throwable t);
    void onResponse(Response<LoginResponse> response);
}

class LoginWorker implements LoginWorkerInput {

    private LoginWorkerDelegate delegate;

    LoginWorker(LoginWorkerDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void login(LoginModel.Request request) {
        Service.api().login(request.getUser(), request.getPassword()).enqueue(new LoginCallback());
    }

    private class LoginCallback implements Callback<LoginResponse> {
        @Override
        public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
            delegate.onResponse(response);
        }

        @Override
        public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
            delegate.onFailure(t);
        }
    }
}
