package com.nelnaji.sapstockmanagement.pl.models;

import com.nelnaji.sapstockmanagement.dl.entities.Article;
import com.nelnaji.sapstockmanagement.dl.entities.Stock;
import com.nelnaji.sapstockmanagement.dl.enums.VAT;

import java.util.UUID;

public record ArticleDetailDTO(
        UUID id,
        String designation,
        double unitPriceExcludingTax,
        double UnitPriceIncludingTax,
        VAT vat,
        double addedValue,
        String picture,
        String category,
        int quantity
) {

    public static ArticleDetailDTO fromStock(Stock stock){
        Article a = stock.getArticle();

        return new ArticleDetailDTO(a.getId(), a.getDesignation(), a.getUnitPriceExcludingTax() / 100D, a.getUnitPriceIncludingTax() / 100D,a.getVat(), a.getAddedValue() / 100D, a.getPicture(), a.getCategory().getDesignation(), stock.getCurrentQuantity());
    }
}
