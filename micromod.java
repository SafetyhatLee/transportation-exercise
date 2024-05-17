import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Micromod {

    class User {
        String username; int usercode;
        boolean isMember;
    }

    class Vehicle {

        int vhc; int[] loc; String currentuser;
        double battery; double[][] ptag = new double[2][3];
        ArrayList<Map> chain;

        public Vehicle (int vhc, int[] loc) {
            this.vhc = vhc; this.loc = loc;
            initialPrice();
            
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("HashCode", 0x000000);
            tmp.put("Location", loc);
            tmp.put("Battery", 100.0);
            chain.add(tmp);
        }

        private void initialPrice() {
            ptag[0] = new double[]{800.0, 100.0, 2.5};
            ptag[1] = new double[]{750.0, 90.0, 3.5};
            ptag = new double[][]{ptag[0], ptag[1]}
        }

        private void addBlock(int[] loc, User user, boolean isLogout) {
            this.loc = loc; this.currentuser = user.username;
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("HashCode", chain.get(-1).hashCode());
            tmp.put("Location", loc);
            tmp.put("User", user);
            if (isLogout) {
                tmp.put("Distance", usedDistance());
                tmp.put("Cost", cost(user));
                tmp.remove("User");
            }
            chain.add(tmp);
        }

        private double usedDistance() {return 2.82;}
        private int cost(User user) {
            if (user.isMember) {
                return (int)(ptag[0][0]+ptag[0][1]*(usedDistance()-ptag[0][2]));
            } else {
                return (int)(ptag[1][0]+ptag[1][1]*(usedDistance()-ptag[1][2]));
            }
        }

        public void login(int[] loc, User user) {addBlock(loc, user, false);}
        public void logout(int[] loc, User user) {addBlock(loc, user, true);}
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}