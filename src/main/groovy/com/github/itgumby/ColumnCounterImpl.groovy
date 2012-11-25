package com.github.itgumby;

public class ColumnCounterImpl implements ColumnCounter {
    def frequency = new HashMap<String, Integer>();
    long countRecords = 0
    long countBlanks = 0

    String prevValue = null
    long prevCount = 0

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
        if ( prevValue.equals(value) ) {
            prevCount++
        } else {
            lazyUpdateMap(value)
        }
    }

    private void lazyUpdateMap(String newVal) {
        // minimize updates
        if (prevValue != null) {
            def count = frequency.get(prevValue) ?: 0
            frequency.put(prevValue, count+prevCount)
        }

        prevValue = newVal
        prevCount = newVal==null ? 0 : 1
    }

    @java.lang.Override
    void readValues(List<String> values) {
        values.each { it -> readValue(it) }
    }

    @java.lang.Override
    long getValueCount(String value) {
        if ( prevValue.equals(value) ) {
            lazyUpdateMap(null)
        }
        frequency.get(value)?.toLong() ?: 0
    }

}
