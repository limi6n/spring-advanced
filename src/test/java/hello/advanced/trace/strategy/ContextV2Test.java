package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyLogic1() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new StrategyLogic1());
        context1.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyLogic2() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스 -> 람다
     */
    @Test
    void strategyLogic3() {
        ContextV2 context1 = new ContextV2();
        context1.execute(() -> log.info("비즈니스 로직1 실행"));
        context1.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
