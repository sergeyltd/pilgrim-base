import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private Percolation p;
    private int t;

    /**
     * Constructor for PercolationStats
     */
    public PercolationStats(int N, int T) {
        t = T;
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        thresholds = new double[T];

        for (int i = 0; i < T; i++) {
            p = new Percolation(N);
            int count = 0;
            while (!p.percolates()) {
                int x = StdRandom.uniform(N) + 1;
                int y = StdRandom.uniform(N) + 1;
                if (!p.isOpen(x, y)) {
                    p.open(x, y);
                    count++;
                }
            }
            thresholds[i] = Integer.valueOf(count).doubleValue() / (N * N);
        }
    }

    public double confidenceLo() {
        double lowConf = mean() - (1.96 * stddev() / Math.sqrt(t));
        return lowConf;
    }

    public double confidenceHi() {
        double highConf = mean() + (1.96 * stddev() / Math.sqrt(t));
        return highConf;
    }

    /**
     * Returns the sample mean
     */
    public double mean() {
        return StdStats.mean(thresholds);
    }

    /**
     * Returns the sample standard deviation
     */
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public static void main(String[] args) {
        Out out = new Out();
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, t);

        double mean = ps.mean();
        double stddev = ps.stddev();
        double lowConf = ps.confidenceLo();
        double highConf = ps.confidenceLo();

        out.printf("mean                    = %f\n", mean);
        out.printf("stddev                  = %f\n", stddev);
        out.printf("95%% confidence interval = %f, %f\n", lowConf, highConf);
        out.close();
    }
}
