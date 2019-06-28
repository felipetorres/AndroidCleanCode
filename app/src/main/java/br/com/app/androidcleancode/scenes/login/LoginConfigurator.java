package br.com.app.androidcleancode.scenes.login;

enum LoginConfigurator {
    INSTANCE;
    public void configure(LoginActivity activity) {

        LoginInteractor interactor = new LoginInteractor();
        interactor.output = new LoginPresenter();

        if(activity.output == null) {
            activity.output = interactor;
        }
    }
}
