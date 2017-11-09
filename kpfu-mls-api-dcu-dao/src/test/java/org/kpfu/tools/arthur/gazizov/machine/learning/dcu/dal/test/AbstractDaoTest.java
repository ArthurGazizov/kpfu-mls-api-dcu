package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test;

import org.junit.runner.RunWith;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test.config.BaseDalTestConfig;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BaseDalTestConfig.class)
@TestExecutionListeners({
        SqlScriptsTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
public abstract class AbstractDaoTest {
}
