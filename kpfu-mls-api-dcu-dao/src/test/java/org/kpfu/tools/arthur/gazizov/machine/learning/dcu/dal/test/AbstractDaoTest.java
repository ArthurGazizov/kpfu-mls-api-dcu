package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test;

import org.junit.runner.RunWith;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test.config.BaseDalTestConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

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
  protected DataSetModel generateDataSet() {
    return DataSetModel.Builder.aDataSetModel()
            .name(UUID.randomUUID().toString())
            .build();
  }

  protected DataSetElementModel generateDataSetElement() {
    return DataSetElementModel.Builder.aDataSetElementModel()
            .imageId(ThreadLocalRandom.current().nextLong())
            .build();
  }

  protected TagModel generateTag() {
    return TagModel.Builder.aTagModel()
            .name(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .build();
  }
}
