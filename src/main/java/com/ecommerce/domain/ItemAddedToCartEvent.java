package com.ecommerce.domain;

import java.time.Instant;

public class ItemAddedToCartEvent extends DomainEvent {
  private final Instant timestamp;
  private final Item item;
  private final EventType eventType;

  public ItemAddedToCartEvent(Item item, EventType eventType) {
    this.eventType = eventType;
    this.timestamp = Instant.now();
    this.item = item;
  }

  public Item getItem() {
    return this.item;
  }

  public EventType getEventType() {
    return this.eventType;
  }
}
