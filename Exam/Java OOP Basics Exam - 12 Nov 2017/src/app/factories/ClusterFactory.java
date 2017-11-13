package app.factories;

import app.entities.Cluster;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class ClusterFactory {
    public static Cluster createCluster(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }
}
