package org.shigm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogComponent {

    @Pointcut("execution(* org.shigm.aop.service.*.*(..))")
    public void pec(){
    }

    @Before(value = "pec()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("before>>>>>>>"+name);
    }

    @After(value = "pec()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("after>>>>>>>"+name);
    }

    @AfterReturning(value = "pec()",returning = "result")
    public void afterreturn(JoinPoint jp,Object result){
        String name = jp.getSignature().getName();
        System.out.println("before>>>>>>>"+name+">>>>>result"+result);
    }

    @AfterThrowing(value = "pec()",throwing="e")
    public void excep(JoinPoint jp,Exception e){
        String name = jp.getSignature().getName();
        System.out.println("before>>>>>>>"+name+">>>>>exception"+e.getMessage());
    }

    @Around(value = "pec()")
    public Object huanrao(ProceedingJoinPoint pjp) throws Throwable {
        Object object = pjp.proceed(); //方法返回值 可以再次修改
        return object;
    }
}
