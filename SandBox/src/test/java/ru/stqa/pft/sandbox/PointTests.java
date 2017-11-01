package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test

  public void testPoint() {
    Point p1 = new Point(17.0,1.5);
    Point p2 = new Point(4.5,7.7);

    Assert.assertEquals(p1.distance(p1,p2), 13.953135848260061);
  }
}
