public class Game
{
  private int lives;
  private boolean winner;
  private int wave;
  private int lastWave;
  private int level;
  private String title;
  
  public Game(int mode)
  {
    title = "Last Stand: ";
    if (mode == 0)
    {
      lives = 200;
      title += "Easy";
      lastWave = 30;
    }
    else if (mode == 1)
    {
      lives = 150;
      title += "Hard";
      lastWave = 50;
    }
    else
    {
      lives = 100;
      title += "Lunatic";
      lastWave = 70;
    }
  }
}