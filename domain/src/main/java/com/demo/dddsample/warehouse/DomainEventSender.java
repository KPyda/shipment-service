package com.demo.dddsample.warehouse;

public interface DomainEventSender {
    void send(DomainEvent event);
}
