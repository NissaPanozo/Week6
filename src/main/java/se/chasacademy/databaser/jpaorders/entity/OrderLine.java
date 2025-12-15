package se.chasacademy.databaser.jpaorders.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "T_ORDER_LINE",
        uniqueConstraints = {
                // Inte i SQL-schemat, men hjälper logiskt; ta bort om du vill vara 100% passiv
                // @UniqueConstraint(name = "UK_ORDER_LINE_ORDER_LINENO", columnNames = {"ORDER_ID","LINE_NUMBER"})
        }
)
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID", nullable = false) // FK -> T_ORDER(ORDER_ID)
    private OrderEntity order;

    @Column(name = "LINE_NUMBER", nullable = false)
    private Integer lineNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false) // FK -> T_PRODUCT(PROD_ID)
    private Product product;

    @Column(name = "QTY", nullable = false)
    private Integer quantity;

    @Column(name = "LINE_TOTAL_CENTS", nullable = false)
    private Integer lineTotalCents;

    // getters/setters
}

