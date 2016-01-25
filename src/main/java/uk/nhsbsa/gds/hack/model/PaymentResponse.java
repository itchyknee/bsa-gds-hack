package uk.nhsbsa.gds.hack.model;

import org.springframework.hateoas.Links;

/**
 * Created by dmort on 25/01/16.
 */
public class PaymentResponse extends PaymentRequest {

    private String status;

    private Integer payment_id;

    Links links;
}
