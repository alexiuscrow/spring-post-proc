package alexiuscrow.spring.postproc;

import org.junit.Test;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MainTest {

    @Test
    public void printMsg() throws InterruptedException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("context.groovy");
    }
}
