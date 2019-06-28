package br.com.app.androidcleancode.scenes.login;

import br.com.app.androidcleancode.api.LoginResponse;

class LoginModel {

    static class Request {
        private String user;
        private String password;

        Request(String user, String password) {
            this.user = user;
            this.password = password;
        }

        String getPassword() { return password; }
        String getUser() { return user; }
    }

    static class Response {
        private int status;
        private LoginResponse obj;

        Response(int status, LoginResponse obj) {
            this.status = status;
            this.obj = obj;
        }

        int getStatus() { return status; }
        LoginResponse getObj() { return obj; }
    }
}
