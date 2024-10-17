package com.nelnaji.sapstockmanagement.bll.services.impls;

import com.nelnaji.sapstockmanagement.bll.services.StockService;
import com.nelnaji.sapstockmanagement.dal.repositories.StockRepository;
import com.nelnaji.sapstockmanagement.dl.entities.Article;
import com.nelnaji.sapstockmanagement.dl.entities.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

private final StockRepository stockRepository;

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findStock(UUID id) {
        return stockRepository.findById(id).orElseThrow();
    }

    public Stock findStockByArticleId(UUID articleId){
        return stockRepository.findByArticleId(articleId).orElseThrow();
    }

}
