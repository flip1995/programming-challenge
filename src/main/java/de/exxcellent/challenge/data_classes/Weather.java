package de.exxcellent.challenge.data_classes;

import com.opencsv.bean.CsvBindByName;

import de.exxcellent.challenge.queries.Diff;

public class Weather implements Diff<Weather> {
    @CsvBindByName(column = "Day")
    private Integer day;
    @CsvBindByName(column = "MxT")
    private Integer max_temp;
    @CsvBindByName(column = "MnT")
    private Integer min_temp;

    @Override
    public int cmp_diff(Weather other) {
        Integer this_diff = this.max_temp - this.min_temp;
        Integer other_diff = other.max_temp - other.min_temp;
        if (this_diff < other_diff)
            return -1;
        else if (this_diff == other_diff)
            return 0;
        else
            return 1;
    }

    public Integer getDay() {
        return this.day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Integer max_temp) {
        this.max_temp = max_temp;
    }

    public Integer getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Integer min_temp) {
        this.min_temp = min_temp;
    }
}