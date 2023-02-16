package helpers;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private List<Product> products;
    private Customer customer;
    private Double amount;
    private String status;
    private LocalDate bookingDate;
    private LocalDate deliveryDate;

    public Order() {
    }

    public Order(Long id, List<Product> products, Customer customer, Double amount, String status, LocalDate bookingDate, LocalDate deliveryDate) {
        this.id = id;
        this.products = products;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
        this.bookingDate = bookingDate;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
