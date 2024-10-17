package com.nelnaji.sapstockmanagement.bll.services;

import com.nelnaji.sapstockmanagement.dl.entities.Stock;

import java.util.List;
import java.util.UUID;

// @Service // n'est pas obligatoire dans l'interface mais obligé dans l'implementation
public interface StockService {

    List<Stock> getStocks();
    Stock findStock(UUID id);
    Stock findStockByArticleId(UUID articleId);
}

