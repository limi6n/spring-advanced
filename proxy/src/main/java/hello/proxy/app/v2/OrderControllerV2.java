package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    /**
     * LogTrace 적용 대상
     * @param itemId
     * @return
     */
    @GetMapping("/v2/request")
    public String request(@RequestParam("itemId") String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    /**
     * LogTrace 적용 대상 아님
     * @return
     */
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }

}
