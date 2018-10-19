package se.chalmers.group22.gymcompanion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import se.chalmers.group22.gymcompanion.Model.LocalDatabaseTest;
import se.chalmers.group22.gymcompanion.Model.ParserTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LocalDatabaseTest.class,
        ParserTest.class
})

public class JunitTestSuite {
}
