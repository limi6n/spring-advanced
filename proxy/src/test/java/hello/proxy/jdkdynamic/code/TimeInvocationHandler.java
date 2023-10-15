package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target; // 동적프록시가 호출할 대상

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // 리플렉션을 사용해서 target 인스턴스의 메서드를 실행
        // args : 호출 시 넘겨줄 인수
        Object result = method.invoke(target, args);

        long endTiem = System.currentTimeMillis();
        long resultTime = endTiem - startTime;
        log.info("TimeProxy 종료 resultTime={}", resultTime);

        return result;
    }
}
