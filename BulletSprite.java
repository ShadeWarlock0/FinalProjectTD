public class BulletSprite extends MobileSprite
{
  double xDest;
  double yDest;
  public BulletSprite (double left, double top, int width, int height, String image,
                      double velocityX, double velocityY, double xCoordDest, double yCoordDest)
  {
    super (left, top, width, height, image, velocityX, velocityY);
    xDest=xCoordDest;
    yDest=yCoordDest;
  }
  public double centerHorizontal(double leftX)
  {
    return leftX+getWidth()/2;
  }
  public double centerVertical(double topY)
  {
    return topY-getHeight()/2;
  }
   public void step(World world)
  {
    super.step(world);
    if(overlapCoord(xDest,yDest))
    {
      world.getSprites().remove(getIndex(this,world));
    }
  }
  
}