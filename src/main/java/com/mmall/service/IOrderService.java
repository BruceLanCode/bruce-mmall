package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * @author bruce
 * 2022/7/16 18:00
 */

public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);
    ServerResponse aliCallback(Map<String,String> params);
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
    ServerResponse createOrder(Integer userId, Integer shippingId);
}
