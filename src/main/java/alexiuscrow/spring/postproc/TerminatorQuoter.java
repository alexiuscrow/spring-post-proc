package alexiuscrow.spring.postproc;

import alexiuscrow.spring.postproc.annotations.PostProxy;
import alexiuscrow.spring.postproc.annotations.Profiling;
import alexiuscrow.spring.postproc.annotations.RandomInt;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @RandomInt(min = 1, max = 4)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase #1");
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase #2");
        System.out.println("repeat = " + repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostProxy
    public void sayQuote() {
        System.out.println("Phase #3");
        for (int i = 0; i < repeat; i++)
            System.out.println("message = " + message);
    }
}
