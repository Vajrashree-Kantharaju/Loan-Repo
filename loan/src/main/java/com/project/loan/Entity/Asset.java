package com.project.loan.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetId;
    @Getter
    @Setter
    private Long Id;
    @Getter
    @Setter
    private String assetName;
    @Getter
    @Setter
    private Double assetPrice;
    @Getter
    @Setter
    private Double Quantity;
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

}
