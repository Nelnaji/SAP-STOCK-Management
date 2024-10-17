package com.nelnaji.sapstockmanagement.pl.controllers;

import com.nelnaji.sapstockmanagement.bll.services.StockService;
import com.nelnaji.sapstockmanagement.dl.entities.Article;
import com.nelnaji.sapstockmanagement.dl.entities.Stock;
import com.nelnaji.sapstockmanagement.pl.models.ArticleDTO;
import com.nelnaji.sapstockmanagement.pl.models.ArticleDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final StockService stockService;

    @GetMapping
    public String getArticle(Model model) {

        // s -> ArticleDTO.fromStock(s)
        List<Stock> stocks = stockService.getStocks();
        List<ArticleDTO> articles = stocks.stream().map(ArticleDTO::fromStock).toList();
        model.addAttribute("articles", articles);
        return "article/index";
    }


    @GetMapping("/{id}")
    public String getArticleDetail(@PathVariable UUID id, Model model) {

        ArticleDetailDTO articleDetail = ArticleDetailDTO.fromStock(stockService.findStockByArticleId(id));

        model.addAttribute("article", articleDetail);
        return "article/detail";
    }
}
