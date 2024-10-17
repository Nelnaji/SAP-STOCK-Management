package com.nelnaji.sapstockmanagement.il.Initializers;

import com.nelnaji.sapstockmanagement.dal.repositories.ArticleRepository;
import com.nelnaji.sapstockmanagement.dal.repositories.CategoryRepository;
import com.nelnaji.sapstockmanagement.dal.repositories.StockMovementRepository;
import com.nelnaji.sapstockmanagement.dal.repositories.StockRepository;
import com.nelnaji.sapstockmanagement.dl.entities.Article;
import com.nelnaji.sapstockmanagement.dl.entities.Category;
import com.nelnaji.sapstockmanagement.dl.entities.Stock;
import com.nelnaji.sapstockmanagement.dl.entities.StockMovement;
import com.nelnaji.sapstockmanagement.dl.enums.StockMovementType;
import com.nelnaji.sapstockmanagement.dl.enums.VAT;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StockRepository stockRepository;
    private final StockMovementRepository movementRepository;
    private final StockMovementRepository stockMovementRepository;

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {
            List<Category> categories = List.of(
                    new Category(UUID.randomUUID(), "Jeux vidéo"),
                    new Category(UUID.randomUUID(), "Livres"),
                    new Category(UUID.randomUUID(), "Films")
            );
            categoryRepository.saveAll(categories);
        }

        if (articleRepository.count() == 0) {
            List<Category> categories = categoryRepository.findAll();
            List<Article> articles = List.of(
                    new Article(
                            UUID.randomUUID(),
                            "Dragon ball sparkling zero",
                            999L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Jeux vidéo")).findFirst().orElseThrow()
                    ),
                    new Article(
                            UUID.randomUUID(),
                            "Sun Tzu, L'art de la guèrre",
                            699L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Livres")).findFirst().orElseThrow()
                    ),
                    new Article(
                            UUID.randomUUID(),
                            "Le dernier samurai",
                            399L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Films")).findFirst().orElseThrow()
                    )
            );
            articleRepository.saveAll(articles);
        }

        if (stockMovementRepository.count() == 0) {

            List<Article> articles = articleRepository.findAll();

            List<StockMovement> movements = List.of(
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            10,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Dragon ball sparkling zero")).findFirst().orElseThrow()
                    ),
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            20,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Sun Tzu, L'art de la guèrre")).findFirst().orElseThrow()
                    ),
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            50,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Le dernier samurai")).findFirst().orElseThrow()
                    )
            );

            List<Stock> stocks = List.of(
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(0).getQuantity(),
                            movements.get(0).getArticle()),
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(1).getQuantity(),
                            movements.get(1).getArticle()
                    ),
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(2).getQuantity(),
                            movements.get(2).getArticle()
                    ));
            movementRepository.saveAll(movements);
            stockRepository.saveAll(stocks);
        }
    }
}