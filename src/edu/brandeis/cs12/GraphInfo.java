package edu.brandeis.cs12;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphInfo {
  String filename;
  JSONObject parsedResult;

  GraphInfo(String file) {
    filename = file;
  }
  
  public void parseFile() throws FileNotFoundException {
    parsedResult = readJSONFile(filename);
  }
  
  private JSONObject readJSONFile(String filename) throws FileNotFoundException {
    FileReader reader = new FileReader(filename);
    JSONTokener tokens = new JSONTokener(reader);
    JSONObject jsonObject = new JSONObject(tokens);
    return jsonObject;
  }
  
  public void buildGraph(MyGraph grp) {
    if (!parsedResult.has("graph")) errorFail("No graph tag");
    JSONObject body = parsedResult.getJSONObject("graph");
    
    if (!body.has("name")) errorFail("FAIL: No name tag");
    grp.setName(body.getString("name"));
    
    if (!body.has("edges")) errorFail("FAIL: No edges tag");
    JSONArray edges = body.getJSONArray("edges");
    
    for (int i=0; i<edges.length(); i++) {
      JSONObject edge = edges.getJSONObject(i);
      grp.addEdge(edge.getString("from"), edge.getString("to"), edge.getInt("label"));
    }
  }

  private static void errorFail(String error) {
    System.out.println(error);
    System.exit(1);
  }
}

