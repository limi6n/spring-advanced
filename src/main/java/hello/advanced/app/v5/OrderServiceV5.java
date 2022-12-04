package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final TraceTemplate template;

    private final OrderRepositoryV5 orderRepository;

    public OrderServiceV5(LogTrace trace, OrderRepositoryV5 orderRepository) {
        this.template = new TraceTemplate(trace);
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", (TraceCallback<Void>) () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
