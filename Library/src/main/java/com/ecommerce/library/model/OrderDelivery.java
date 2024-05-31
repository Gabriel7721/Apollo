package com.ecommerce.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_delivery")
public class OrderDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_delivery_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_person_id", referencedColumnName = "delivery_person_id")
    private DeliveryPerson deliveryPerson;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "assigned_date")
    private Date assignedDate;

    private String status;
    private boolean isAccept;
}
