import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public class Sprite
{
  private double left;  //the x-coordinate of the left edge of the sprite
  private double top;   //the y-coordinate of the top edge of the sprite
  private int width;
  private int height;
  private String image;
  
  public Sprite(double theLeft, double theTop, int theWidth, int theHeight, String theImage)
  {
    left = theLeft;
    top = theTop;
    width = theWidth;
    height = theHeight;
    setImage(theImage);
  }
  
  public double getLeft()
  {
    return left;
  }
  
  public void setLeft(double l)
  {
    left = l;
  }
  
  public double getTop()
  {
    return top;
  }
  
  public void setTop(double t)
  {
    top = t;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public void setWidth(int w)
  {
    width = w;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public void setHeight(int h)
  {
    height = h;
  }
  
  public String getImage()
  {
    return image;
  }
  
  public void setImage(String i)
  {
    image = i;
  }
  
  public int getIndex(Sprite a, World world)
  {
    
    for(int i=0;i<world.getSprites().size();i++)
    {
      if(world.getSprites().get(i)==a)
      {
        return i;
      }
    }
    return -1;
  }
  
  public void step(World world)
  {
  }
  public boolean overlapCoord(double x, double y)
  {
    if((left<=x)&&(x<=(left+width))&&((top-height)<=x)&&(x<=top))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean overlap(Sprite a)
  {
    if (left<= a.getLeft()+a.getWidth()&&left>=a.getLeft())
    {
      if (top<=a.getTop()+a.getHeight()&&top>=a.getTop()||top+height>=a.getTop()&&top+height<=a.getTop()+a.getHeight())
      {
        return true
      }
      else
        return false;
    }
    else if (left+width>=a.getLeft()&&left+width<=a.getLeft()+a.getWidth())
    {   
      if (top<=a.getTop()+a.getHeight()&&top>=a.getTop()||top+height>=a.getTop()&&top+height<=a.getTop()+a.getHeight())
    {
      return true;
    }
    else
      return false;
    }
    else if (top<=a.getTop()+a.getHeight()&&top>=a.getTop())
    {
      if(left<= a.getLeft()+a.getWidth()&&left>=a.getLeft()||left+width>=a.getLeft()&&left+width<=a.getLeft()+a.getWidth())
        return true;
      else
        return false;
    }
    else if (top+height>=a.getTop()&&top+height<=a.getTop()+a.getHeight())
    {
      if(left<= a.getLeft()+a.getWidth()&&left>=a.getLeft()||left+width>=a.getLeft()&&left+width<=a.getLeft()+a.getWidth())
        return true;
      else
        return false;
    }
    else
    {
      return false;
    }
    
  }
}
