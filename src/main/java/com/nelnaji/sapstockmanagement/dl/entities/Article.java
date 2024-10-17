package com.nelnaji.sapstockmanagement.dl.entities;


import com.nelnaji.sapstockmanagement.dl.enums.VAT;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Check(constraints = "vat IN (6,12,21)")
public class Article extends BaseEntity {

    @Column(nullable = false, unique = true, length = 80)
    private String designation;

    @Column(nullable = false)
    @Min(0L)
    private long unitPriceExcludingTax;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VAT vat;

    @Column(unique = true)
    private String picture;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;


    public Article(UUID id, String designation, long unitPriceExcludingTax, VAT vat, String picture, Category category) {
        super(id);
        this.designation = designation;
        this.unitPriceExcludingTax = unitPriceExcludingTax;
        this.vat = vat;
        this.picture = picture;
        this.category = category;
    }

    public long getUnitPriceIncludingTax() {
        return getUnitPriceExcludingTax() + getAddedValue();
    }

    public long getAddedValue() {
        BigDecimal vat = BigDecimal.valueOf(this.vat.value, 2);
        BigDecimal priceTTE = BigDecimal.valueOf(this.unitPriceExcludingTax);
        BigDecimal addedValue = priceTTE.multiply(vat);
        return addedValue.setScale(0, RoundingMode.HALF_UP).longValue();
    }

}
