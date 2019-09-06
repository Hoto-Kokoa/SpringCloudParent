package com.test.filter;


import com.sun.deploy.net.HttpRequest;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.tools.ant.taskdefs.condition.Http;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter("/v")
public class VocabularyFilterServlet implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("VocabularyFilterServlet初始化");
    }

    public void doFilter(final ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("VocabularyFilterServlet开始过滤");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(req.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName());
                Object ret = null;
                try {
                    ret= methodProxy.invokeSuper(o, objects);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ret;
            }
        });
//
//        filterChain.doFilter((HttpServletRequest)enhancer.create(),servletResponse);



//使用JDK动态代理
//        HttpServletRequest r = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
//                req.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(method.getName());
//                        if ("getParameter" == method.getName()) {
//                            System.out.println("动态代理拦截到了getParameter方法");
//                            String vocabulary = servletRequest.getParameter("vocabulary");
//                            System.out.println("动态代理拦截到vocabulary过滤前内容为:"+vocabulary);
//                            vocabulary = vocabulary.replace("cnm", "富强民主");
//                            vocabulary = vocabulary.replace("nmsl", "文明和谐");
//                            vocabulary = vocabulary.replace("wdnmd", "自由平等");
//                            System.out.println("过滤后:"+vocabulary);
//                            return vocabulary;
//                        }
//                        return method.invoke(servletRequest, args);
//                    }
//                });
//
//        filterChain.doFilter(r,servletResponse);




//不使用动态代理
////        String vocabulary = servletRequest.getParameter("vocabulary");
//        System.out.println("过滤前:"+vocabulary);
//        vocabulary = vocabulary.replace("cnm", "富强民主");
//
//        vocabulary = vocabulary.replace("nmsl", "文明和谐");
//
//        vocabulary = vocabulary.replace("wdnmd", "自由平等");
//        System.out.println("过滤后:"+vocabulary);
//        servletRequest.setAttribute("vocabulary",vocabulary);
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
