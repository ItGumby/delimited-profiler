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
            updateFrequency(value)
        }
    }

    private void updateFrequency(String value) {
        def count = frequency.get(value) ?: 0
        frequency.put(value, count+1)
    }

    @java.lang.Override
    void readValues(List<String> values) {
        values.each { it -> readValue(it) }
    }

    @java.lang.Override
    long getValueCount(String value) {
        frequency.get(value)?.toLong() ?: 0
    }

}
