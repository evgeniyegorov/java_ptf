package ru.stqa.pft.sandbox;

public class Point {
  private final double x;
  private final double y;
  private double d;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point a, Point b) {
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    d = Math.sqrt(dx * dx + dy * dy);
    return d;
  }

}
