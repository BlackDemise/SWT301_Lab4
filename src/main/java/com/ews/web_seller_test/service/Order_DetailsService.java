package com.ews.web_seller_test.service;

import com.ews.web_seller_test.model.Order_Details;

import java.util.List;

public interface Order_DetailsService {
    void insertOrder_Details(Order_Details orderDetails);

    void editOrder_Details(Order_Details cartItem);

    void deleteOrder_Details(int id);

    Order_Details getOrder_Details(int id);

    List<Order_Details> getAllOrder_Details();

    List<Order_Details> searchOrder_Details(String keyword);
    List<Order_Details> orderDetailsListByOrderId(int orderId);

}
