package cloud.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author daniel
 * @since 09/03/2017
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        /*
         * pre          before route
         * routing      --
         * post         between routing and error
         * error        --
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true; // always enable
    }

    @Override
    public Object run() {
        RequestContext     _context = RequestContext.getCurrentContext();
        HttpServletRequest _request = _context.getRequest();

        log.info(String.format("[x] %s request to %s", _request.getMethod(), _request.getRequestURL().toString()));

        String _token = _request.getParameter("accessToken");
        if (_token == null) {
            log.warn("[x] access token is empty");
            _context.setSendZuulResponse(false);
            _context.setResponseStatusCode(401);
            return null;
        }

        log.info("[x] access token ok");

        return null;
    }

}
