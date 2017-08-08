package org.mylearn.framework;

import org.mylearn.framework.bean.Handler;
import org.mylearn.framework.helper.BeanHelper;
import org.mylearn.framework.helper.ConfigHelper;
import org.mylearn.framework.helper.ControllerHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发器
 *
 * Created by admin on 2017/8/8.
 */
//TODO WebServlet注解
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化相关 Helper 类
        HelperLoader.init();
        // 获取 ServletContext 对象 (用于注册 Servlet)
        ServletContext servletContext = servletConfig.getServletContext();
        // 注册处理 JSP 的 Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        // 注册处理静态自愿的默认 Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方法与请求路径
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();
        // 获取 Action 处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (null != handler) {
            // 获取 Controller 类及其 Bean 实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
        }
    }
}
