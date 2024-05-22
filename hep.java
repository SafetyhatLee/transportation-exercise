import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

class Expmodel {
    // Both costs and distances should decline along the index, so cbl[0]>cbl[1]>cbl[2]>cbl[3], so does dbl
    double[] cbl = new double[4]; double[] dbl = new double[4];

    // Main functions
    public void addinfo(double[] costs, double[] distances) {
        int i = 0; for (double cost : costs) {cbl[i] = cost; i++;}
        i = 0; for (double dist : distances) {dbl[i] = dist; i++;}
    }
    public int[] randshare(int total, int nodes) {
        Random rand = new Random();
        int[] tmp = new int[nodes]; int i = total;
        for (int k=0; k<nodes; k++) {if (k != nodes-1) {tmp[k] = rand.nextInt(i); i -= tmp[k];} else {tmp[k] = i;}}
        // By the basic assumption for distance-based demand-decision, the farther the station is from, the more passengers there are.
        Arrays.sort(tmp); int[] tmp2 = new int[nodes]; for (int a=0; a<nodes; a++) {tmp2[a]=tmp[nodes-1-a];}
        return tmp2;
    }

    // Factor Selection and data implementation 
    public double[] efficiency(int nodes) {
        double[] tmp = new double[nodes];
        for (int k=0; k<nodes; k++) {tmp[k] = cbl[k]/dbl[k];} return tmp;
    }
    public double[] optimization() {addinfo({64.2, 50.0, 38.3, 17.9}, {183.0, 152.6, 120.3, 73.8});}

    // Standards & Constraints definition
    
    
}

public class hep { // HEP: Homogeneous Efficiency Problem 
    public static void main(String[] args) {
        Expmodel mod1 = new Expmodel();
        System.out.println(Arrays.toString(mod1.randshare(100,4)));
    }
}
