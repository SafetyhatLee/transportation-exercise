import java.util.Random;

class Expmodel {
    double[] cbl = new double[4]; double[] dbl = new double[4];

    public void addinfo(double[] costs, double[] distances) {
        int i = 0; for (double cost : costs) {cbl[i] = cost; i++;}
        i = 0; for (double dist : distances) {dbl[i] = dist; i++;}
    }
    public int[] randshare(int total, int nodes) {
        Random rand = new Random();
        int[] tmp = new int[nodes]; int i = total;
        for (int k=0; k<nodes; k++) {
            if (k != nodes-1) {tmp[k] = rand.nextInt(i); i -= tmp[k];} else {tmp[k] = i;}
        }
        return tmp;
    }

}

public class hep { //HEP: Homogeneous Efficiency Problem 
    public static void main(String[] args) {
        Expmodel mod1 = new Expmodel();
        System.out.println(mod1.randshare(100,4).toString());
    }
}
