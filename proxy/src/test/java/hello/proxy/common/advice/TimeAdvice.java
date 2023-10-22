package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // target 을 찾아서 알아서 인수를 넘겨줌.
        Object result = invocation.proceed();

        long endTiem = System.currentTimeMillis();
        long resultTime = endTiem - startTime;
        log.info("TimeProxy 종료 resultTime={}", resultTime);

        return result;
    }
}
