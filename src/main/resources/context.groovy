import alexiuscrow.spring.postproc.TerminatorQuoter
import alexiuscrow.spring.postproc.listeners.PostProxyInvokerContextListener
import alexiuscrow.spring.postproc.proc.ProfilingHandlerBeanPostProcessor
import alexiuscrow.spring.postproc.proc.RandomIntAnnotationBeanPostProcessor
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor

beans {
    autowiredAnnotationBeanPostProcessor(AutowiredAnnotationBeanPostProcessor)
    commonAnnotationBeanPostProcessor(CommonAnnotationBeanPostProcessor)
    postProxyInvokerContextListener(PostProxyInvokerContextListener)
    profilingHandlerBeanPostProcessor(ProfilingHandlerBeanPostProcessor)
    randomIntAnnotationBeanPostProcessor(RandomIntAnnotationBeanPostProcessor)
    terminatorQuoter(TerminatorQuoter) { bean ->
        message = "Hello!"
    }
}