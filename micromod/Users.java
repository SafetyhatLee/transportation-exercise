import java.util.Random;

public abstract class Users {
  int userID; String cardNum;
  double[] costParam;
}

class Onedirect implements Users {
  public Onedirect() {
    userID = Random.randInt(0, 100000);
    costParam = [1.4, ]
  }
  public void onProcess(String card) {cardNum = card;}
  
}
