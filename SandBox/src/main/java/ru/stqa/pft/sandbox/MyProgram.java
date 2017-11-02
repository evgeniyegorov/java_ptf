package ru.stqa.pft.sandbox;

public class MyProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Evgeniy");

    /*Задание 2 Начало*/
    Square s = new Square(7);
    Rectangle r = new Rectangle(4, 7);

    Point p1 = new Point(17.0,1.5);
    Point p2 = new Point(4.5,7.7);
    System.out.println("Расстояние между точками p1 и p2 = "+p1.distance(p2));
    /*Задание 2 Конец*/


    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}


