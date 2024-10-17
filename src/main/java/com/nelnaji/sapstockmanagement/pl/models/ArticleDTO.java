package com.nelnaji.sapstockmanagement.pl.models;

import com.nelnaji.sapstockmanagement.dl.entities.Article;
import com.nelnaji.sapstockmanagement.dl.entities.Stock;

import java.util.UUID;

public record ArticleDTO(
        UUID id,
        String designation,
        double unitPriceExceludingTax,
        double unitPriceIncludingTax,
        String picture,
        String category,
        int quantity

) {

    public static ArticleDTO fromStock(Stock stock) {
        Article a = stock.getArticle();

        return new ArticleDTO(a.getId(),a.getDesignation(),a.getUnitPriceExcludingTax() / 100D,a.getUnitPriceIncludingTax() / 100D ,a.getPicture(),a.getCategory().getDesignation() ,stock.getCurrentQuantity());
    }

}
