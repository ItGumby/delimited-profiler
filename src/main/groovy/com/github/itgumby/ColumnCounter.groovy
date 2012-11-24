package com.github.itgumby

public interface ColumnCounter {
    long getRecordCount()
    long getBlankCount()

    void readValue(String value)
    void readValues(List<String> values)

    long getValueCount(String value)
}