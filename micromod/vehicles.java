import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Vehicles {

    class Container {
        
        static double[] location; static int capacity;
        Vehicle[] inContainer;
        int vehicleIn;

        public Container(double[] location, int capacity, Vehicle[] first) {
            this.location = location, this.capacity = capacity;
            inContainer = new Vehicle[capacity];
            vehicleIn = capacity;
            try {
                initial(first);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("The vehicles ready for registration exceeds the capacity of this container");
                System.out.println("This container opens for vehicles within capacity only");
                for (int k=0; k<capacity; k++) {inContainer[k]=first[k];}
            } finally {
                System.out.println("Registration complete");
            }
        }

        public void initial(Vehicle[] first) {
            int k=0; for (Vehicle veh : first) {inContainer[k] = veh; k++;}
        }
        
        public Vehicle openVehicle() {
            Random rand = new Random(); boolean isopened = false;
            int[] able = new int[vehicleCapacity-1]; int ind = 0;
            Vehicle veh;
            while (!isopened) {
                i = rand.randInt(0, vehicleCapacity-1);
                if (!Arrays.asList(unable).contains(i) && inContainer[i] != null) {
                    if (inContainer[i].battery >= 30.0) {
                        System.out.println("Container Opened. Your vehicle is ready.");
                        veh = inContainer[i]; isOpened = true; 
                    } else {
                        unable[ind] = i; ind++;
                    }
                } else if (!Arrays.asList(unable).contains(i) && inContainer[i] == null) {
                    unable[ind] = i; ind++;
                }
            }
            return veh;
        }

        public void store(Vehicle veh) {
            Random rand = new Random(); boolean isopened = false;
            int[] unable = new int[vehicleCapacity-1]; int ind = 0;
            Vehicle veh;
            while (!isopened) {
                i = rand.randInt(0, vehicleCapacity-1);
                if (!Arrays.asList(unable).contains(i) && inContainer[i] != null) {
                    if (inContainer[i].battery >= 30.0) {
                        System.out.println("Container Opened. Your vehicle is ready.");
                        veh = inContainer[i]; isOpened = true; 
                    } else {
                        unable[ind] = i; ind++;
                    }
                } else if (!Arrays.asList(unable).contains(i) && inContainer[i] == null) {
                    unable[ind] = i; ind++;
                }
            }
        }
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
