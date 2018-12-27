package com.baizhi.fl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/10.
 */

@Configuration   //声明为全局配置  把 交给工厂管理
@Aspect  // 切面 的注解            @poinCut 切入点的注解
public class LogAspect {  // 日志的功能
    //定义切入点
    @Pointcut(value = "@annotation(LogAnnotation)")  // 切入点的引入解释 开发
    public void poinCut() {

    }

    /*@Pointcut(value = "execution(* com.baizhi.fl.service.*.*(..))")  //还可以   基于注解 方法二
    public void poinCut(){

    }*/

    //定义环绕通知
    @Around(value = "poinCut()") //引入切入点
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //是谁  什么时间  干了什么事   执行结果
        //获取session 拿到当前用户 进而来确定是谁
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("CurrentUser");
        //获取到当前时间
        Date date = new Date();

        //获取方法名
        String name = proceedingJoinPoint.getSignature().getName();

        //获取方法名对象  基于反射
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();  //获取到方法对象
        // 通过方法对象拿到方法上的注解对象
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        //拿到注解的属性值
        String name1 = annotation.name();
        //定义一个标志
        boolean flag=false;
        Object proceed=null;
        try {

            proceed = proceedingJoinPoint.proceed();//方法执行
            flag=true;// 如果方法没出异常  将flag 标志改为 true
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;

    }


}
