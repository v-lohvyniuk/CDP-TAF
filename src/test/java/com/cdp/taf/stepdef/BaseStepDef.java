package com.cdp.taf.stepdef;

import com.cdp.taf.core.SpringConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {SpringConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseStepDef extends AbstractTestNGSpringContextTests {
}