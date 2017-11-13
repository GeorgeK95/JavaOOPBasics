package app.core;

import app.entities.Cell;
import app.entities.Organism;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return null;
    }

    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)) {
            this.organisms.put(name, OrganismFactory.createOrganism(name));
            return String.format("Created organism %s", name);
        } else {
            return String.format("Organism %s already exists", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).addCluster(ClusterFactory.createCluster(id, rows, cols))) {
                return String.format("Organism %s: Created cluster %s", organismName, id);
            }
        }

        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId,
                          int health, int positionRow, int positionCol, int additionalProperty) {
        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusterById(clusterId) != null) {
                if (positionRow <= this.organisms.get(organismName).getClusterById(clusterId).getRows() ||
                        positionCol <= this.organisms.get(organismName).getClusterById(clusterId).getCols()) {
                    Cell cell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
                    this.organisms.get(organismName).getClusterById(clusterId).addCell(cell);
                    return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
                }
            }
        }

        return null;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).activateNextClusterInOrder();
        }
        return null;
    }

}
