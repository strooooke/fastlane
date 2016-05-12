package tools.fastlane.screengrab.locale;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Locale;

public class LocaleTestRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        Locale testLocale = LocaleUtil.getTestLocale();
        Locale endingLocale = LocaleUtil.getEndingLocale();

        return new Statement() {
            public void evaluate() throws Throwable {
                try {
                    if(testLocale != null) {
                        LocaleUtil.changeDeviceLocaleTo(testLocale);
                    }

                    base.evaluate();
                } finally {
                    if(endingLocale != null) {
                        LocaleUtil.changeDeviceLocaleTo(endingLocale);
                    }
                }
            }
        };
    }
}
