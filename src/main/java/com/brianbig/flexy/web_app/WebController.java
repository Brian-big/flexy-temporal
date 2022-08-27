package com.brianbig.flexy.web_app;

import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.domain.products.Product;
import com.brianbig.flexy.workflow.OrderWorker;
import com.brianbig.flexy.workflow.OrderWorkflowInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("WebController")
public class WebController {

    private final OrderWorkflowInterface workflow = OrderWorker.getWorkFlow();
    @Autowired private WebRestClient restClient;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "Flexy - Made resilient with temporal");
        model.addAttribute("products", restClient.fetchProducts());
        model.addAttribute("customers", restClient.fetchCustomers());
        model.addAttribute("orders", restClient.fetchOrders());
        return "index";
    }


    @PostMapping("/")
    public String makeOrder(@RequestParam("customer_id") long customerId,
                          @RequestParam("product_id") long productId
                          ){
        var order = Order.builder()
                .customer(Customer.builder().id(customerId).build())
                .product(Product.builder().id(productId).build())
                .build();
        workflow.makeOrder(order);

        return "index";
    }
}
