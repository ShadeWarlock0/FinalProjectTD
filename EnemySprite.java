import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public class EnemySprite extends LivingSprite
{
  private int HP;
  private ArrayList<Coordinate> path;
  private int index;
  
  public EnemySprite(double left, double top, int width, int height, String image,
                     double velocityX, double velocityY, int health, ArrayList<Coordinate> path)
  {
    super(left, top, width, height, image, 0, 0);
    velocityX = 0;
    velocityY = 0;
    index = 0;
    HP = health;
    this.path = path;
  }
  public int getHP()
  {
    return HP;
  }
  public int getIndex()
  {
    return index;
  }
  public void injure(int damage)
  {
    HP -= damage;
  }
  public void step(World world)
  {
    super.step(world);
    if (super.getLeft() > path.get(index).getX())
    {
      super.setLeft(super.getLeft() - 1);
    }
    else if (super.getLeft() < path.get(index).getX())
    {
      super.setLeft(super.getLeft() + 1);
    }
    if (super.getTop() > path.get(index).getY())
    {
      super.setTop(super.getTop() - 1);
    }
    else if (super.getTop() - super.getHeight() < path.get(index).getY())
    {
      super.setTop(super.getTop() + 1);
    }
    if (Math.abs(super.getLeft() - path.get(index).getX()) <= 1 && Math.abs(super.getTop() - path.get(index).getY()) <= 1)
    {
      if (index < 12)
        index++;
    }
  }
}
