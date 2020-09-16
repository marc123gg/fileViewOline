package cn.keking.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author marc
 * @date 2020/9/20
 */
@Configuration
public class FilterConfiguration {


    //解决中文乱码问题
    @Bean
    public FilterRegistrationBean getChinesePathFilter() {
        ChinesePathFilter filter = new ChinesePathFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        return registrationBean;
    }

    //来源信任过滤
    @Bean
    public FilterRegistrationBean getTrustHostFilter() {
        Set<String> filterUri = new HashSet<>();
        filterUri.add("/onlinePreview");
        filterUri.add("/picturesPreview");
        filterUri.add("/getCorsFile");
        filterUri.add("/addTask");
        TrustHostFilter filter = new TrustHostFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.setUrlPatterns(filterUri);
        return registrationBean;
    }

    //设置预览服务的url，主要是适配ngnix
    @Bean
    public FilterRegistrationBean getBaseUrlFilter() {
        Set<String> filterUri = new HashSet<>();
        filterUri.add("/index");
        filterUri.add("/onlinePreview");
        filterUri.add("/picturesPreview");
        BaseUrlFilter filter = new BaseUrlFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.setUrlPatterns(filterUri);
        return registrationBean;
    }

    //为请求添加文件预览参数 例如： 字体 颜色 行距 大小 ...
    @Bean
    public FilterRegistrationBean getWatermarkConfigFilter() {
        Set<String> filterUri = new HashSet<>();
        filterUri.add("/onlinePreview");
        filterUri.add("/picturesPreview");
        WatermarkConfigFilter filter = new WatermarkConfigFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.setUrlPatterns(filterUri);
        return registrationBean;
    }
}
