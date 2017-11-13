package com.starry.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

import static com.starry.util.JsoupUtil.clean;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest orgRequest = null;
    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        if(("postType".equals(name) || "postContent".equals(name)) && !isIncludeRichText){
            return super.getParameter(name);
        }
        name = clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            value = clean(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        // 处理markdown和富文本
        if(("postType".equals(name) || "postContent".equals(name))){
            String[] arr = super.getParameterValues(name);
            if(arr != null){
                for (int i=0;i<arr.length;i++) {
                    // 过滤非法标签
                    arr[i] = clean(arr[i]);
                    // 替换markdown每行开头的">"符号
                    arr[i] = arr[i].replaceAll("\n&gt;","\n>");
                    // 替换markdown第一行的">"符号
                    if(arr[i].startsWith("&gt;")) {
                        arr[i] = arr[i].replaceFirst("&gt;",">");
                    }
                }
            }
            return arr;
        }
        name = clean(name);
        String[] arr = super.getParameterValues(name);
        if(arr != null){
            for (int i=0;i<arr.length;i++) {
                arr[i] = clean(arr[i]);
            }
        }
        return arr;
    }


    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        name = clean(name);
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)) {
            value = clean(value);
        }
        return value;
    }

    /**
     * 获取初始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取初始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }

        return req;
    }
}
