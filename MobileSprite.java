public class MobileSprite extends Sprite
{
  private double vx;
  private double vy;
  
  public MobileSprite(double left, double top, int width, int height, String image,
                      double velocityX, double velocityY)
  {
    super(left, top, width, height, image);
    vx = velocityX;
    vy = velocityY;

    //insert code here
  }
  
  public double getVY()
  {
    return vy;
    //insert code here
  }
  
  public void setVY(double velocityY)
  {
    vy = velocityY;
    //insert code here
  }
  
  public void step(World world)
  {
    if (getLeft() < 0)
      vx = Math.abs(vx);
    if (getLeft() + getWidth() > world.getWidth())
      vx = -Math.abs(vx);
    if (getTop() + getHeight() > world.getHeight())
      vy = -Math.abs(vy);
    
    super.setLeft(super.getLeft() + vx);
    super.setTop(super.getTop() + vy);
  }
}