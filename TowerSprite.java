public class TowerSprite extends SpawnSprite
{
  private int fireRate;
  private double range;
  private int damage;
  private int counter;
  
  public TowerSprite (double left, double top, int width, int height, String image,
                      double velocityX, double velocityY, int frequency, MobileSprite spawn, int fireRate, double range, int damage)
  {
    super (left, top, width, height, image, velocityX, velocityY, frequency, spawn);
    this.fireRate=fireRate;
    this.range=range;
    this.damage=damage;
    counter=0;
  }
  
  public double centerHorizontal(double leftX)
  {
    return leftX+getWidth()/2;
  }
  public double centerVertical(double topY)
  {
    return topY-getHeight()/2;
  }
  public boolean shoot(World world)
  {
    double centerX=centerHorizontal(getLeft());
    double centerY=centerVertical(getTop());

    int ind=closestSprite(world);
    if (ind==-1)
    {
    }
    else
    {
      killSprite(ind, world);
      double velocityX=(world.getSprite(ind).getLeft()-getLeft())/(world.getSprite(ind).getTop()-getTop());
      double velocityY=(world.getSprite(ind).getTop()-getTop())/(world.getSprite(ind).getLeft()-getLeft());
      spawnBullet(world.getSprite(ind).getLeft(),world.getSprite(ind).getTop(),5,5,"hippo.png",velocityX,velocityY,world);
      return true;
    }
    
    return false;
    
   
  }
  public void spawnBullet(double xCoord, double yCoord, int w,int h, String image,double xVeloc,double yVeloc, World world)
  {
    Sprite a= new BulletSprite(getLeft(),getTop(),w,h,image,xVeloc,yVeloc,xCoord,yCoord);
    world.add(a);
  }
  public double findDistance(int index, World world)
  {
    Sprite a=world.getSprite(index);
    return Math.sqrt(Math.pow(this.getLeft()-a.getLeft(),2)+Math.pow(this.getTop()-a.getTop(),2));
      
  }
  
  public int closestSprite(World world)
  {
    double minDistance=range;
    int closestSprite=-1;
    for(int i=0;i<world.getSprites().size();i++)
    {
      Sprite a=world.getSprite(i);
      if (a instanceof EnemySprite)
      {
          if(findDistance(i,world)<minDistance)
          {
            closestSprite=i;
          }
      }
    }
    return closestSprite;
  }
  
  public boolean killSprite(int a,World world)
  {
    
    return world.remove(a);
    
  }  
  public void step(World world)
  {
    if(counter<50)
    {
      counter++;
    }
    else
    {
      shoot(world);
    }
  }
}