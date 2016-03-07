package edu.brandeis.cs12;

import java.io.FileNotFoundException;
public class JSONExample {

  public static void main(String[] args) throws FileNotFoundException {
    MyGraph myGraph = new MyGraph();

    GraphInfo info = new GraphInfo("graphinfo.json");
    info.parseFile();
    info.buildGraph(myGraph);
    System.out.println(myGraph);
  }
}
