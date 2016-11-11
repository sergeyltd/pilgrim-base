import edu.princeton.cs.algs4.QuickUnionUF;
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private QuickUnionUF grid;
    // control open closed sites
    private boolean[][] sites;
    private int siteSize;
    // n*n positions plus top and botton position
    // z
    // x x x
    // x x x
    // x x x
    // y
    // [z x.. y]

    private int gridSize;

    /**
     * NxN matrix: initial state all blocked
     */
    public Percolation(int N) {
        siteSize = N;
        gridSize = N * N + 2;
        sites = new boolean[N][N];
        grid = new QuickUnionUF(gridSize);
    }

    /**
     * Open site(i,j)
     */
    public void open(int i, int j) {
        validadeSite(i, j);
        if (!isOpen(i, j)) {
            setSite(i, j, true);
            unionAllNeighborsOpenSites(i, j);
            checkFullSiteConnectionsAndPercolates(i, j);
        }
    }

    private void checkFullSiteConnectionsAndPercolates(int i, int j) {
        if (isFull(i, j)) {
            for (int x = 1; x <= siteSize; x++) {
                if (getSite(siteSize, x) && isFull(siteSize, x)) {
                    grid.union(getIndexFromArgs(siteSize, x), gridSize - 1);
                }
            }
        }
    }

    private void unionAllNeighborsOpenSites(int i, int j) {
        int me = getIndexFromArgs(i, j);
        int top = getIndexFromArgs(i - 1, j);
        int bot = getIndexFromArgs(i + 1, j);
        int left = getIndexFromArgs(i, j - 1);
        int right = getIndexFromArgs(i, j + 1);

        // Union to all open sites around site
        if (i != 1 && getSite(i - 1, j))
            grid.union(me, top);
        if (i != siteSize && getSite(i + 1, j))
            grid.union(me, bot);
        if (j != 1 && getSite(i, j - 1))
            grid.union(me, left);
        if (j != siteSize && getSite(i, j + 1))
            grid.union(me, right);
        if (i == 1)
            grid.union(me, 0);
    }

    private void validadeSite(int i, int j) {
        if (i > siteSize || j > siteSize || i < 1 || j < 1) {

            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
    }

    public boolean isOpen(int i, int j) {
        validadeSite(i, j);
        return getSite(i, j);
    }

    public boolean isFull(int i, int j) {
        validadeSite(i, j);
        return isOpen(i, j) && isConnectedTopRow(i, j);
    }

    private boolean isConnectedTopRow(int i, int j) {
        return grid.connected(0, getIndexFromArgs(i, j));
    }

    public boolean percolates() {
        return grid.connected(0, gridSize - 1);
    }

    private int getIndexFromArgs(int i, int j) {
        return siteSize * (i - 1) + j;
    }

    private boolean getSite(int i, int j) {
        return sites[i - 1][j - 1];
    }

    private void setSite(int i, int j, boolean val) {
        sites[i - 1][j - 1] = val;
    }
}