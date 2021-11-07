package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graphs {

  private int numberOfNodes;
  private HashMap<Integer, List<Integer>> adjacentList;

  public Graphs() {
    numberOfNodes = 0;
    adjacentList = new HashMap<>();
  }

  public static void main(String[] args) {
    Graphs graph = new Graphs();
    graph.addVertex(0);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);
    graph.addEdge(3, 1);
    graph.addEdge(3, 4);
    graph.addEdge(4, 2);
    graph.addEdge(4, 5);
    graph.addEdge(1, 2);
    graph.addEdge(1, 0);
    graph.addEdge(0, 2);
    graph.addEdge(6, 5);
    graph.showConnections();
  }

  private void addVertex(int node) {
    adjacentList.put(node, new ArrayList<>());
    numberOfNodes++;
  }

  private void addEdge(int node1, int node2) {
    adjacentList.get(node1).add(node2);
    adjacentList.get(node2).add(node1);
  }

  private void showConnections() {
    if (!adjacentList.isEmpty()) {

      adjacentList.entrySet().stream()
          .forEach(
              key -> {
                System.out.println(key);
              });
    }
  }
}
