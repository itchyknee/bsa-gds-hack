package uk.nhsbsa.gds.hack.model;

import org.springframework.hateoas.Links;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmort on 25/01/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse extends PaymentRequest {

    private String status;

    private Integer payment_id;

    Links links;
}
