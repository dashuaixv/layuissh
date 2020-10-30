package com.gt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaysshApplicationTests {

    private  final Logger logger= LoggerFactory.getLogger(LaysshApplication.class);

    @Test
    public void contextLoads() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
    }

}
