package de.exxcellent.challenge.data_classes;

import com.opencsv.bean.CsvBindByName;

import de.exxcellent.challenge.queries.Diff;

public class Football implements Diff<Football> {
    @CsvBindByName(column = "Team")
    private String team;
    @CsvBindByName(column = "Goals")
    private Integer goals;
    @CsvBindByName(column = "Goals Allowed")
    private Integer goals_allowed;

    @Override
    public int cmp_diff(Football other) {
        Integer this_diff = Math.abs(this.goals - this.goals_allowed);
        Integer other_diff = Math.abs(other.goals - other.goals_allowed);
        if (this_diff < other_diff)
            return -1;
        else if (this_diff == other_diff)
            return 0;
        else
            return 1;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoals_allowed() {
        return goals_allowed;
    }

    public void setGoals_allowed(Integer goals_allowed) {
        this.goals_allowed = goals_allowed;
    }
}