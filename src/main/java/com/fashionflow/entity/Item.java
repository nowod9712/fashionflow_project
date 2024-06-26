package com.fashionflow.entity;

import com.fashionflow.constant.ItemStatus;
import com.fashionflow.constant.SellStatus;
import com.fashionflow.dto.CategoryDTO;
import com.fashionflow.dto.ItemFormDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //상품번호

    @Column(nullable = false)
    private String itemName; //상품이름

    @Column(columnDefinition = "longtext", nullable = false)
    private String content; //상세설명

    @Column(nullable = false)
    private int price; //상품가격

    @Column(nullable = false)
    private int delivery; //배송비

    @Column(nullable = false)
    private String address; //주소

    @Column(nullable = false)
    private LocalDateTime regdate; //등록일

    private Integer viewCount; //조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category; //카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemStatus itemStatus; //상품 상태

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SellStatus sellStatus; //판매 상태




    public void updateItemInfo(String itemName, Category category, SellStatus sellStatus, ItemStatus itemStatus, String content, int price, int delivery, String address) {
        this.itemName = itemName;
        this.category = category;
        this.sellStatus = sellStatus;
        this.itemStatus = itemStatus;
        this.content = content;
        this.price = price;
        this.delivery = delivery;
        this.address = address;
    }

}
