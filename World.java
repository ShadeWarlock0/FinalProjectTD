import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.imageio.*;
import javax.swing.*;

public class World
{
  public static void main(String[] args)
  {
    Display display = new Display(500, 500);
    display.run();
  }
  
  private int lives;
  private int money;
  private ArrayList<Sprite> sprites;
  private int width;
  private int height;
  private Image background;
  private ArrayList<Coordinate> path;
  
  public World(int w, int h)
  {
    try
    {
    URL url = getClass().getResource("Map.png");
    background = ImageIO.read(url);
    }
    catch(IOException e)
    {
      e.printStackTrace();
      throw new RuntimeException("bad");
    }

    width = w;
    height = h;
    path = new ArrayList<Coordinate>();
    path.add(new Coordinate(257, 57)); //index 0
    path.add(new Coordinate(404, 54)); //index 1
    path.add(new Coordinate(403, 180)); //2
    path.add(new Coordinate(162, 182)); //3
    path.add(new Coordinate(156, 79)); //4
    path.add(new Coordinate(70, 79)); //5
    path.add(new Coordinate(70, 280)); //6
    path.add(new Coordinate(278, 280)); //7
    path.add(new Coordinate(278, 356)); //8
    path.add(new Coordinate(135, 356)); //9
    path.add(new Coordinate(135, 453)); //10
    path.add(new Coordinate(401, 453)); //11
    path.add(new Coordinate(401, 520)); //12
    path.add(new Coordinate(401, 1000)); //13
    sprites = new ArrayList<Sprite>();
    double dir;
    lives = 100;
    

    //normal sprites
    sprites.add(new Sprite(87, 100, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(87, 165, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(87, 225, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(157, 205, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(237, 205, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(317, 205, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(185, 120, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(255, 120, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(325, 120, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(65, 360, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(65, 430, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(330, 390, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(390, 390, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(300, 270, 50, 50, "EmptyTower.png"));
    sprites.add(new Sprite(300, 330, 50, 50, "EmptyTower.png"));
    sprites.add(new EnemySprite(257, 0, 15, 15, "Robot.gif", 0, 0, 10, path));
    money = 200;


    //mobile sprites
    
//    dir = Math.random() * 2 * Math.PI;
//    sprites.add(new MobileSprite(Math.random() * (width - 50),
//                                 Math.random() * (height - 50), 50, 50, "circle.png",
//                                 Math.cos(dir), Math.sin(dir)));
//    dir = Math.random() * 2 * Math.PI;
//    sprites.add(new MobileSprite(Math.random() * (width - 50),
//                                 Math.random() * (height - 50), 50, 50, "circle.png",
//                                 Math.cos(dir), Math.sin(dir)));
//
//    //heavy sprites
//    dir = Math.random() * 2 * Math.PI;
//    sprites.add(new HeavySprite(Math.random() * (width - 50),
//                                 Math.random() * (height - 50), 50, 50, "triangle.png",
//                                 Math.cos(dir), Math.sin(dir)));
//    dir = Math.random() * 2 * Math.PI;
//    sprites.add(new HeavySprite(Math.random() * (width - 50),
//                                 Math.random() * (height - 50), 50, 50, "triangle.png",
//                                 Math.cos(dir), Math.sin(dir)));
  }
  
  public void stepAll()
  {
    if (lives <= 0)
    {
      JFrame j = new JFrame();
      JOptionPane.showMessageDialog(j, "GAME OVER");
      throw new RuntimeException("You suck.");
    }
    for (int i = 0; i < sprites.size(); i++)
    {
      Sprite s = sprites.get(i);
      
      s.step(this);
      if (sprites.get(i) instanceof EnemySprite)
      {
        EnemySprite e = (EnemySprite)sprites.get(i);
        if (e.getHP() <= 0)
        {
          sprites.remove(i);
          money ++;
        }
        if (e.getIndex() == 13)
        {
          sprites.remove(i);
          lives--;
        }
      }
    }
  }
  public ArrayList<Sprite> getSprites()
  {
    return sprites;
  }
  public int getWidth()
  {
    return width;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getNumSprites()
  {
    return sprites.size();
  }
  
  public Sprite getSprite(int index)
  {
    return sprites.get(index);
  }

  public void mouseClicked(int x, int y)
  {
    System.out.println("mouseClicked:  " + x + ", " + y);
  }
  
  public void keyPressed(int key)
  {
    System.out.println("keyPressed:  " + key);
    if (key == 23)
    {
      System.out.println("You pressed key " + key + " this time.");
    }
  }
  
  public void keyReleased(int key)
  {
    System.out.println("keyReleased:  " + key);
  }
  
  public String getTitle()
  {
    return "Feinberg Tower Defense! Lives: " + lives + " Pesos: " + money;
  }

  public void paintComponent(Graphics g)
  {
    //g.setColor(Color.BLACK);
    //g.fillRect(0, 0, width, height);
        
    g.drawImage(background, 0, 0, width, height, null);
    for (int i = 0; i < sprites.size(); i++)
    {
      Sprite sprite = sprites.get(i);
      g.drawImage(Display.getImage(sprite.getImage()),
                  (int)sprite.getLeft(), (int)sprite.getTop(),
                  sprite.getWidth(), sprite.getHeight(), null);
    }
  }
}
