package com.linmu.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xxx_
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Test> dataList = new ArrayList<>();

//        List<Test> result = dataList.stream()
//                .collect(Collectors.groupingBy(Test::getCustomer_id))
//                .values()
//                .stream()
//                .map(list -> list.stream().max(Comparator.comparing(o -> o.auth_end_date)).get())
//                .collect(Collectors.toList());

        Map<String, Test> maxMap = new HashMap<>(16);

        for (Test test : dataList) {
            Test max = maxMap.get(test.getCustomer_id());
            if(max == null || max.getAuth_end_date().compareTo(test.getAuth_end_date()) < 0) {
                maxMap.put(test.getCustomer_id(), max);
            }
        }

        Collection<Test> ans = maxMap.values();
    }
}

class Test {
    String maintain_id;
    String trade_id;
    String customer_id;
    String uid;
    String customer_name;
    String maintain_code;
    String maintainFrequency;
    LocalDate auth_end_date;
    String product_i;


    public String getMaintain_id() {
        return maintain_id;
    }

    public void setMaintain_id(String maintain_id) {
        this.maintain_id = maintain_id;
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMaintain_code() {
        return maintain_code;
    }

    public void setMaintain_code(String maintain_code) {
        this.maintain_code = maintain_code;
    }

    public String getMaintainFrequency() {
        return maintainFrequency;
    }

    public void setMaintainFrequency(String maintainFrequency) {
        this.maintainFrequency = maintainFrequency;
    }

    public LocalDate getAuth_end_date() {
        return auth_end_date;
    }

    public void setAuth_end_date(LocalDate auth_end_date) {
        this.auth_end_date = auth_end_date;
    }

    public String getProduct_i() {
        return product_i;
    }

    public void setProduct_i(String product_i) {
        this.product_i = product_i;
    }
}
