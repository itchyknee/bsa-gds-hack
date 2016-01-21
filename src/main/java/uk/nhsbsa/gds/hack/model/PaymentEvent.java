package uk.nhsbsa.gds.hack.model;



public class PaymentEvent {

    private String id;

    private String firstName;
    private String lastName;

    public PaymentEvent() {}

    public PaymentEvent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Payment[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

