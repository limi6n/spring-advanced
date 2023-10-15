package hello.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }

    /**
     * LogTrace 적용 대상
     * @param itemId
     * @return
     */
    @GetMapping("/v3/request")
    String request(@RequestParam("itemId") String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    /**
     * LogTrace 적용 대상 아님
     * @return
     */
    @GetMapping("/v3/no-log")
    String noLog() {
        return "ok";
    }

}
