package com.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
  private final List<DomainEvent> events = new ArrayList<>();
  private final List<Item> items = new ArrayList<>();
  private final List<Product> removedProducts = new ArrayList<>();

  public void add(Item item) {
    final ItemAddedToCartEvent itemAddedToCartEvent = new ItemAddedToCartEvent(item, EventType.ADD);
    events.add(itemAddedToCartEvent);
//    this.items.add(item);
    System.out.println("Added");
  }

  public List<Item> show() {
    return this.events.stream()
      .filter(event -> event.getEventType().equals(EventType.ADD))
      .map(event -> event.getItem())
      .collect(Collectors.toList());
  }

  public void remove(Item item) {
    final ItemRemovedFromCartEvent itemRemovedFromCartEvent = new ItemRemovedFromCartEvent(item, EventType.REMOVE);
    events.add(itemRemovedFromCartEvent);
    System.out.println("Removed");
//    this.removedProducts.add(item.getProduct());
  }

  public List<Product> showRemovedProducts() {
    return this.events.stream()
      .filter(event -> event.getEventType().equals(EventType.REMOVE))
      .map(event -> event.getItem().getProduct())
      .collect(Collectors.toList());
  }
}
