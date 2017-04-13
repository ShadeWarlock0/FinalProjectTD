public class LivingSprite extends MobileSprite
{
  boolean alive;
  public LivingSprite(double left, double top, int width, int height, String image,
                      double velocityX, double velocityY)
  {
    super(left, top, width, height, image, velocityX, velocityY);
    alive = true;
  }
  public boolean isAlive()
  {
    return alive;
  }
  public void kill()
  {
    alive = false;
  }
}