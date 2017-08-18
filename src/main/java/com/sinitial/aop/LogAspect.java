package com.sinitial.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Date;

public class LogAspect {
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "  " + methodName + " at " + new Date() + "执行！");
    }

    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i] + ",");
            }
        }
    }

    public void afterReturn(JoinPoint joinPoint, Object value) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "  " + methodName + " at " + new Date() + "完成！");
        System.out.println(value);
    }
}
