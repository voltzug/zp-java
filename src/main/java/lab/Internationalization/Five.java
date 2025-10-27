package lab.Internationalization;

import base.Context;

public class Five extends Context {
    @Override
    protected void execute() throws Exception {
        System.out.println(new Language(ELocale.PL).getMessageTest());
    }
}
