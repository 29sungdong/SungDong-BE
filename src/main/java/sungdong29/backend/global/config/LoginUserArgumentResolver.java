package sungdong29.backend.global.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import sungdong29.backend.global.config.jwt.TokenProvider;

@RequiredArgsConstructor
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final TokenProvider tokenProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Long resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String token = tokenProvider.getAccessToken(request);

        if(token!=null && tokenProvider.validateAccessToken(token)) {
            String userId=tokenProvider.getTokenUserId(token);
            return Long.parseLong(userId);
        }

        return null;
    }
}