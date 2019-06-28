package br.com.app.androidcleancode.scenes.login;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginInteractorTest {

    private String passwordWithAtLeastOneUppercaseOneSpecialAndAnAlphanumeric() {
        return "ab$C123";
    }

    @Test
    public void should_callPresenter_with_correctInput() {
        LoginInteractor loginInteractor = new LoginInteractor();
        LoginPresenterInputSpy presenterSpy = new LoginPresenterInputSpy();
        loginInteractor.output = presenterSpy;
        loginInteractor.loginWorkerInput = new LoginWorkerInputSpy(loginInteractor);

        String correctEmail = "justA+Correct@email.com.tt";
        LoginModel.Request request = new LoginModel.Request(correctEmail,
                passwordWithAtLeastOneUppercaseOneSpecialAndAnAlphanumeric());
        loginInteractor.validate(request);

        assertTrue(presenterSpy.presentWasCalled);
    }

    @Test
    public void shouldNot_callPresenter_with_incorrectInput() {
        LoginInteractor loginInteractor = new LoginInteractor();
        LoginPresenterInputSpy presenterSpy = new LoginPresenterInputSpy();
        loginInteractor.output = presenterSpy;

        LoginModel.Request request = new LoginModel.Request("anIncorrectEmail.com", "123456");
        loginInteractor.validate(request);

        assertFalse(presenterSpy.presentWasCalled);
    }

    @Test
    public void should_callWorker_with_correctInput() {
        LoginInteractor loginInteractor = new LoginInteractor();
        loginInteractor.output = new LoginPresenterInputSpy();
        LoginWorkerInputSpy worker = new LoginWorkerInputSpy(loginInteractor);
        loginInteractor.loginWorkerInput = worker;

        String correctEmail = "justA+Correct@email.com.tt";
        LoginModel.Request request = new LoginModel.Request(correctEmail,
                passwordWithAtLeastOneUppercaseOneSpecialAndAnAlphanumeric());
        loginInteractor.validate(request);

        assertTrue(worker.loginWasCalled);
    }

    @Test
    public void shouldNot_callWorker_with_incorrectInput() {
        LoginInteractor loginInteractor = new LoginInteractor();
        loginInteractor.output = new LoginPresenterInputSpy();
        LoginWorkerInputSpy worker = new LoginWorkerInputSpy(loginInteractor);
        loginInteractor.loginWorkerInput = worker;

        LoginModel.Request request = new LoginModel.Request("anIncorrectEmail.com", "123456");
        loginInteractor.validate(request);

        assertFalse(worker.loginWasCalled);
    }
}