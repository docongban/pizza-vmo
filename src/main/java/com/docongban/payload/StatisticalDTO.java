package com.docongban.payload;

import lombok.Data;

@Data
public class StatisticalDTO {
    private Long total;
    private Long totalAfterDiscount;
    private String date;
}
