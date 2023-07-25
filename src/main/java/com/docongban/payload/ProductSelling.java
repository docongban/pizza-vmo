package com.docongban.payload;

import lombok.Data;

@Data
public class ProductSelling {
    private String title;
    private String content;
    private String thumbnail;
    private String price;
    private Long countProduct;
}
