package com.github.itgumby

public interface ColumnCounter {
    void readValue(String value)
    long getRecordCount()
    long getBlankCount()
}