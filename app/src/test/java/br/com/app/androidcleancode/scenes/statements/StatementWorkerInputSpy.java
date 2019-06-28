package br.com.app.androidcleancode.scenes.statements;

import java.util.Collections;
import java.util.List;

public class StatementWorkerInputSpy implements StatementWorkerInput {

    boolean getStatementsWasCalled = false;

    @Override
    public List<StatementModel> getStatements() {
        getStatementsWasCalled = true;
        return getStatementModels();
    }

    private List<StatementModel> getStatementModels() {
        StatementModel model = new StatementModel();

        return Collections.singletonList(model);
    }
}
