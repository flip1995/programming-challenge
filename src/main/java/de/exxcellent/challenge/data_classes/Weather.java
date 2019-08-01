package de.exxcellent.challenge.data_classes;

import com.opencsv.bean.CsvBindByName;

public class Weather {
    @CsvBindByName(column = "Day")
    private Integer day;
    @CsvBindByName(column = "MxT")
    private Integer max_temp;
    @CsvBindByName(column = "MnT")
    private Integer min_temp;

    public Integer temp_diff() {
        return this.max_temp - this.min_temp;
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