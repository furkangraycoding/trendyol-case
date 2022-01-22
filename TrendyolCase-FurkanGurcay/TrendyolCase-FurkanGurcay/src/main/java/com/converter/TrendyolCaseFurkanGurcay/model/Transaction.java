package com.converter.TrendyolCaseFurkanGurcay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Entity
@Table(name="Links")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_date", nullable = false)
    @CreatedDate
    private long createdDate;

    private String requestedLink;
    private String responsedLink;
}
