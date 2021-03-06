package com.ecommerce.domain;

import java.time.Instant;

public class ItemRemovedFromCartEvent extends DomainEvent {
  private final Item item;
  private final EventType eventType;
  private final Instant timestamp;

  public ItemRemovedFromCartEvent(Item item, EventType eventType) {
    this.item = item;
    this.eventType = eventType;
    this.timestamp = Instant.now();
  }

  public Item getItem() {
    return this.item;
  }

  public EventType getEventType() {
    return this.eventType;
  }
}
