package com.brianbig.flexy.web_app;

import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.domain.products.Product;
import com.brianbig.flexy.workflow.OrderWorker;
import com.brianbig.flexy.workflow.OrderWorkflowInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/make-order", method = RequestMethod.POST)
    public String makeOrder(
            @RequestParam("customer_id") long customerId,
            @RequestParam("product_id") long productId){
        var order = Order.builder()
                .customer(Customer.builder().id(customerId).build())
                .product(Product.builder().id(productId).build())
                .build();
        Order order_  = workflow.makeOrder(order);

        return "redirect:/";
    }
    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public String addCustomer(
            @RequestParam("email") String email,
            @RequestParam("telephone") String telephone,
            @RequestParam("address") String address){
        var customer = Customer.builder()
                .email(email)
                .telephone(telephone)
                .address(address)
                .build();
        restClient.addCustomer(customer);
        return "redirect:/";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") double price)
            {
        var product = Product.builder()
                .name(name)
                .price(price)
                .build();
        restClient.addProduct(product);
        return "redirect:/";
    }
}
