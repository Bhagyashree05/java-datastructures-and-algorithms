package com.datastructures.hashtables;

import java.util.ArrayList;

public class HashtableImplementation {

  ArrayList<HashTableKeyValueArray>[] data;
  private int length;

  HashtableImplementation(int size) {
    data = new ArrayList[size];
    length = 0;
  }

  public static void main(String[] args) {
    HashtableImplementation hashTableObj = new HashtableImplementation(30);
    hashTableObj.setMethod("Grapes", 100);
    hashTableObj.setMethod("Apples", 75);
    hashTableObj.setMethod("Orange", 10);
    int value = hashTableObj.get("Orange");
    System.out.println("get() demo : " + value);
    System.out.println("keys() demo : ");
    hashTableObj.keys();
  }

  private int hashMethod(String key) {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      hash = (hash + key.charAt(i) * i) % data.length;
    }
    return hash;
  }

  private void setMethod(String key, int value) {
    int address = hashMethod(key);
    if (data[address] == null) {
      ArrayList<HashTableKeyValueArray> arrayData = new ArrayList<>();
      data[address] = arrayData;
      length++;
    }
    HashTableKeyValueArray keyValue = new HashTableKeyValueArray(key, value);
    data[hashMethod(key)].add(keyValue);
  }

  private Integer get(String key) {
    int address = hashMethod(key);
    if (data[address] == null) {
      return 0;
    }
    for (HashTableKeyValueArray keyValueData : data[address]) {
      if (keyValueData.getKey().equals(key)) {
        return keyValueData.getValue();
      }
    }
    return 0;
  }

  private String[] keys() {
    ArrayList<HashTableKeyValueArray>[] bucket = data;
    String[] keysArray = new String[length];
    int count = 0;
    for (ArrayList<HashTableKeyValueArray> keyValues : bucket) {
      if (keyValues != null) {
        keysArray[count] = keyValues.get(0).getKey();
        count++;
      }
    }
    printData(keysArray);
    return keysArray;
  }

  private void printData(String[] keys) {
    if (keys.length > 0) {
      for (String key : keys) {
        System.out.print(key + "\t");
      }
    }
  }
}
