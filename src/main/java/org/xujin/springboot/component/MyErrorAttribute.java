package org.xujin.springboot.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author xujin
 * @package-name org.xujin.springboot.component
 * @createtime 2020-02-28 15:28
 */
//在容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttributes.put("company","xujin");
        return errorAttributes;
    }
}
