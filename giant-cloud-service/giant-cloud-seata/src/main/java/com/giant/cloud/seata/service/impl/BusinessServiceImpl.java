package com.giant.cloud.seata.service.impl;

import com.giant.cloud.seata.service.BusinessService;
import com.giant.cloud.seata.service.OrderService;
import com.giant.cloud.seata.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    private StorageService storageService;
    private OrderService orderService;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    public void purchase(String userId, String commodityCode, int orderCount) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
        throw new RuntimeException("xxx");
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
