package alexiuscrow.spring.postproc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Test
    public void printMsg() throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        context.getBean(Quoter.class).sayQuote();
    }
}
