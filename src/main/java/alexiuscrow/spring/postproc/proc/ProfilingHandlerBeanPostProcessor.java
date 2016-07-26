package alexiuscrow.spring.postproc.proc;

import alexiuscrow.spring.postproc.annotations.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new TreeMap<String, Class>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                    long time = System.nanoTime();
                    Object res = method.invoke(bean, args);
                    time = System.nanoTime() - time;
                    System.out.println("Time: " + time);
                    return res;
                }
            });
        }
        return bean;
    }
}
