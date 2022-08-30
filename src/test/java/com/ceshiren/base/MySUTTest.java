package com.ceshiren.base;
import com.ceshiren.MySUT;

import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

public class MySUTTest {
    static final Logger logger = getLogger(lookup().lookupClass());
    //MySUT mySUT =new MySUT("两个加法的测试用例");
    static MySUT mySUT;
    @BeforeAll
    public static void beforeAll(){
        mySUT=new MySUT("两个加法测试用例");
    }

    @Test
    public void sumTest(){
        int sum= mySUT.sum(1,2);
        logger.info("1+2="+sum);
        //assertEquals(4,sum,"1+2的结果有误");
    }

    @Test
    public void sumTest2(){
        int sum= mySUT.sum(99,2);
        logger.info("99+2="+sum);
        assertEquals(101,sum,"99+2的结果无误");
    }

    @BeforeEach
    public void beforeEach(){
        mySUT.initId();
        logger.info("id生成成功");
    }
    //练习三：在每次测试方法即@Test注解修饰的方法运行完成后，ID进行注销操作

    @AfterEach
    public void AfterEach(){
        mySUT.destroyId();
        System.out.println("ID注销成功");
    }
}


