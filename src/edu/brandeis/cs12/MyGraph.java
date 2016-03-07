package edu.brandeis.cs12;

import java.util.ArrayList;

public class MyGraph {
  ArrayList<MyEdge>edges = new ArrayList<MyEdge>();
  String name;

  public void setName(String name) {
    this.name = name;
   }
  
  public void addEdge(String from, String to, int weight) {
    edges.add(new MyEdge(from, to, weight));
  }
  
  public String toString() {
    return(String.format("GRAPH: %s %s", name, edges));
  }

}
