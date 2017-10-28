package footballTeamGenerator;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Player {
    private String name;
    private int enduranceSkillLevel;
    private int sprintSkillLevel;
    private int dribbleSkillLevel;
    private int passingSkillLevel;
    private int shootingSkillLevel;

    public Player(String name, int enduranceSkillLevel, int sprintSkillLevel, int dribbleSkillLevel, int passingSkillLevel, int shootingSkillLevel) {
        this.setName(name);
        this.setEnduranceSkillLevel(enduranceSkillLevel);
        this.setSprintSkillLevel(sprintSkillLevel);
        this.setDribbleSkillLevel(dribbleSkillLevel);
        this.setPassingSkillLevel(passingSkillLevel);
        this.setShootingSkillLevel(shootingSkillLevel);
    }

    public double getOverallSkillLevel() {
        return (this.getDribbleSkillLevel() + this.getEnduranceSkillLevel() + this.getPassingSkillLevel()
                + this.getShootingSkillLevel() + this.getSprintSkillLevel()) / 5.0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private int getEnduranceSkillLevel() {
        return enduranceSkillLevel;
    }

    private void setEnduranceSkillLevel(int enduranceSkillLevel) {
        if (enduranceSkillLevel < 0 || enduranceSkillLevel > 100) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.enduranceSkillLevel = enduranceSkillLevel;
    }

    private int getSprintSkillLevel() {
        return sprintSkillLevel;
    }

    private void setSprintSkillLevel(int sprintSkillLevel) {
        if (sprintSkillLevel < 0 || sprintSkillLevel > 100) {
            throw new IllegalArgumentException("Spring should be between 0 and 100.");
        }
        this.sprintSkillLevel = sprintSkillLevel;
    }

    private int getDribbleSkillLevel() {
        return dribbleSkillLevel;
    }

    private void setDribbleSkillLevel(int dribbleSkillLevel) {
        if (dribbleSkillLevel < 0 || dribbleSkillLevel > 100) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribbleSkillLevel = dribbleSkillLevel;
    }

    private int getPassingSkillLevel() {
        return passingSkillLevel;
    }

    private void setPassingSkillLevel(int passingSkillLevel) {
        if (passingSkillLevel < 0 || passingSkillLevel > 100) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passingSkillLevel = passingSkillLevel;
    }

    private int getShootingSkillLevel() {
        return shootingSkillLevel;
    }

    private void setShootingSkillLevel(int shootingSkillLevel) {
        if (shootingSkillLevel < 0 || shootingSkillLevel > 100) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shootingSkillLevel = shootingSkillLevel;
    }
}
