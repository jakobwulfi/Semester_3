package graphimplementation;

public class Edge {
  int u; // Første knude index
  int v; // Anden knude index
  int e; // Kantens værdi, fx afstanden mellem to punkter

  public Edge(int u, int v, int e) {
    this.u = u;
    this.v = v;
    this.e = e;
  }

  public boolean equals(Object o) {
    return u == ((Edge)o).u && v == ((Edge)o).v;
  }

  public int element() {
    return e;
  }


  public String toString(){
    return "(" + u + ", " + v +"): " + e;
  }
}
