package app.entities;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Organism {
    private String name;
    private Deque<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayDeque<>();
    }

    public boolean addCluster(Cluster cluster) {
        if (this.getClusterById(cluster.getId()) == null) {
            this.clusters.add(cluster);
            return true;
        }
        return false;
    }

    public String activateNextClusterInOrder() {
        if (!this.clusters.isEmpty()) {
            Cluster poll = this.clusters.poll();
            poll.activateCluster();
            this.clusters.addLast(poll);
            return String.format("Organism %s: Activated cluster %s. Cells left: %s", this.name, poll.getId(), poll.getCells().size());
        }
        return null;
    }

    //GETTERS

    public Deque<Cluster> getClusters() {
        return clusters;
    }

    public Cluster getClusterById(String id) {
        for (Cluster cluster : this.clusters) {
            if (cluster.getId().equals(id)) {
                return cluster;
            }
        }
        return null;
    }

    private int getClusterTotalCellsCount() {
        int result = 0;
        for (Cluster cluster : this.clusters) {
            result += cluster.getCells().size();
        }
        return result;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Organism - %s", this.name));
        builder.append(System.lineSeparator());
        builder.append(String.format("--Clusters: %d", this.clusters.size()));
        builder.append(System.lineSeparator());
        builder.append(String.format("--Cells: %d", getClusterTotalCellsCount()));
        builder.append(System.lineSeparator());
        for (Cluster cluster : this.clusters) {
            builder.append(cluster.toString());
            builder.append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        return builder.toString().trim();
    }
}
