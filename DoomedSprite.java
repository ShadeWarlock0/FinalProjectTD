public class DoomedSprite extends LivingSprite
{
  private int lifespan;
  
  public DoomedSprite(double left, double top, int width, int height, String image,
                      double velocityX, double velocityY, int lifespan)
  {
    super(left, top, width, height, image, velocityX, velocityY);
    this.lifespan = lifespan;
  }
}