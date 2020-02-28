package org.xujin.springboot.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author xujin
 * @package-name org.xujin.springboot.filter
 * @createtime 2020-02-28 16:28
 */

public class myFilter implements Filter {
    private String name;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.name = filterConfig.getInitParameter("name");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process..."+name);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
