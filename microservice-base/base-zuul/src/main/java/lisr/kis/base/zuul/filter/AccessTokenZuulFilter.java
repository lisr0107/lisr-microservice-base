package lisr.kis.base.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * 在网关中实现对请求的验证，加入@component启用过滤器
 * @author Admin
 *
 */

public class AccessTokenZuulFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(AccessTokenZuulFilter.class);
	
	/**
	 * 过滤器执行逻辑
	 */
	@Override
	public Object run() throws ZuulException {
		logger.info("AccessTokenFilter");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(request.getRequestURI());//可以对某些请求不进行处理，比如获取token等
		String accessToken = request.getParameter("token");
		if (StringUtils.isEmpty(accessToken)){
			logger.warn("Token is empty");
			ctx.setSendZuulResponse(false);  //不进行路由处理  // Only forward onto to the chain if a zuul response is not being sent
			ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());  //设置错误返会码
			ctx.setResponseBody("Token is Empty");
			ctx.set("isSuccess", false);
			return null;
		}
		return null;
		
	}

	/**
	 * 过滤器是否执行
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 过滤器执行顺序
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 4;
	}

	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return  "pre";
	}

}
