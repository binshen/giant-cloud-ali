package com.giant.cloud.seata.service.impl;

import com.giant.cloud.seata.service.AccountService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void debit(String userId, int money) {
        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}",money,userId);

        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[] {money, userId});
        LOGGER.info("Account Service End ... ");
    }
}
