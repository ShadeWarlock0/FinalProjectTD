public class FetusTower extends SpawnSprite
{
  
  public FetusTower(double left, double top, int width, int height, String image,
                      double velocityX, double velocityY, int frequency, MobileSprite spawn)
  {
    super (left, top, width, height, image, velocityX, velocityY, frequency, spawn);
  }
  
  public void growUp(MobileSprite tower,World world)
  {
    world.set(tower,getIndex(this,world));
  }
public void step(World world)
  {
  //implement clicking;
  }
}
