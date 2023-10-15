package hello.proxy.pureproxy.concreateproxy.code;

import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void proxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy proxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(proxy);
        client.execute();
    }
}
