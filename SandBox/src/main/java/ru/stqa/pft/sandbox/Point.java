package ru.stqa.pft.sandbox;

public class Point {
  private double x;
  private double y;
  private double d;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(double x, double y) {
    double dx = this.x - x;
    double dy = this.y - y;
    d = Math.sqrt(dx * dx + dy * dy);
    return d;
  }

  public double distance(Point p2) {
    return  distance(p2.x, p2.y);
  }
}
