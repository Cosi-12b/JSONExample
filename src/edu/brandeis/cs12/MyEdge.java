package edu.brandeis.cs12;

public class MyEdge {
  String from;
  String to;
  int weight;
  
  MyEdge(String from, String to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
  
  public String toString() {
    return(String.format("\n    Edge: <from:%s to:%s weight:%d>", from, to, weight));
  }
}
