package com.brianbig.flexy.workflow;

import com.brianbig.flexy.common.FlexyRestClient;
import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.domain.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class ApiHelper extends FlexyRestClient {

    @Autowired private OrderService orderService;

    public Order makeOrder(Order order){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Order> orderHttpEntity = new HttpEntity<>(order, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Order> order_ = restTemplate.postForEntity(
                baseApiURL + "orders/", orderHttpEntity, Order.class
        );
        return order_.getBody();
    }

    public Order updateOrder(Order order) {

        String url = String.format("%s/orders/", baseApiURL);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> orderHttpEntity = new HttpEntity<>(order, headers);
        ResponseEntity<Order> response = restTemplate.exchange(
                url, HttpMethod.PUT, orderHttpEntity, Order.class
        );
        return response.getBody();
    }
}
