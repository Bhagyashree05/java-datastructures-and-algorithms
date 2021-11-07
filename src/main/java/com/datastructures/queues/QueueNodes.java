package com.datastructures.queues;

public class QueueNodes {
  private int value;
  private QueueNodes next;

  public QueueNodes(int value) {
    this.value = value;
    this.next = null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public QueueNodes getNext() {
    return next;
  }

  public void setNext(QueueNodes next) {
    this.next = next;
  }
}
