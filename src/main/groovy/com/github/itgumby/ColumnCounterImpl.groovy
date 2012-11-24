package com.github.itgumby;

public class ColumnCounterImpl implements ColumnCounter {
    def frequency = new HashMap<String, Integer>();
    long countRecords = 0
    long countBlanks = 0

    @java.lang.Override
    public long getRecordCount() {
        return countRecords
    }

    @java.lang.Override
    public long getBlankCount() {
        return countBlanks
    }

    @java.lang.Override
    public void readValue(String value) {
        countRecords++
        if (value.length() == 0) {
            countBlanks++
        } else {
            frequency.put(value, 1)
        }
    }
}
