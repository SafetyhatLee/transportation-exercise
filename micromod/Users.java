import java.util.Random;

public abstract class Users {
  int userID; String cardNum;
  double[] costParam;
}

class Onedirect implements Users {
  public Onedirect() {
    userID = Random.randInt(0, 100000);
    costParam = {800.0, 100.0, 2.5};
  }
  public void onProcess(String card) {cardNum = card;}
  
}

class Member implements Users {

  static String membershipcard;
  ArrayList<HashMap<String, Object>> badges;
  String nickname; double mileage;
  
  public Onedirect(String card, boolean invited) {
    userID = Random.randInt(0, 100000);
    costParam = {800.0, 100.0, 2.5};
    membershipcard = card;
    badges = new ArrayList<>();
    mileage = invited ? 1500.0 : 500.0;
  }

  public void setNickname(String nickname) {this.nickname = nickname;}
  public void hangBadge(Badge bad) {
    checkBadge(userID, bad) ? badges.add(bad) : System.err.println("This badge is not available for you");
  }  
}

// Badge bad = new HashMap<String, Object>(); -> Like a dictionary
// bad.get("imageURL", "--a certain image direction--")
// bad.get("name", "--a certain badge name about a certain achievement--")
// bad.get("date", datetime.datetime.now())
