package HomeWork_4;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Logger {
    @AroundInvoke
    public Object printLog(InvocationContext ctx) throws Exception{
        System.out.println("Method called: " + ctx.getMethod());
        return ctx.proceed();
    }
}