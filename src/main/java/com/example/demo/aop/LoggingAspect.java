package com.example.demo.aop;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 前処理
    // @Before("execution(* com.example.demo.service..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = LocalTime.now().format(dtf);
        System.out.println("前処理: " + formattedTime + " **メソッド開始** : "
            + joinPoint.getSignature().getName());
    }

    // 後処理
    // @After("execution(* com.example.demo.service..*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = LocalTime.now().format(dtf);
        System.out.println("後処理: " + formattedTime + " **メソッド終了** : "
            + joinPoint.getSignature().getName());
        System.out.println("メソッド終了:" + formattedTime);
    }

    // @Around("execution(* com.example.demo.service.TargetService.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("===== 【@Around:前】=====");
        System.out.println("Target");
        System.out.println(" クラス: " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(" メソッド:" + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // 実行メソッドを呼び出す
        System.out.println("===== 【@Around:後】=====");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return result;
    }
}