package com.github.itgumby

import spock.lang.Specification

class TestFieldCounter extends Specification {
    ColumnCounter fc = new ColumnCounterImpl()

    def "counts when no reads"() {
        expect:
        fc.getRecordCount() == 0
        fc.getBlankCount() == 0
        fc.getValueCount("NOT_FOUND") == 0
    }

    def "count records for zero, 1, or more records"() {
        when:
        values.each() { it -> fc.readValue(it) }

        then:
        fc.getRecordCount() == numRecords

        where:
        numRecords | values
        0   | []
        1   | ["a"]
        3   | ["a", "b", "c"]
    }

    def "count blanks for zero, 1, or more blanks"() {
        when:
        fc.readValues(values)

        then:
        fc.getBlankCount() == blanks

        where:
        blanks | values
        0   | []
        1   | [""]
        3   | ["", "", "b", ""]
    }

    def "return number of ocurrences of values"() {
        when:   fc.readValues(["a", "b", "c", "b", "c", "c"])
        then:   fc.getValueCount(value) == count

        where:
        value | count
        "a" | 1
        "b" | 2
        "c" | 3
        "NOT_FOUND" | 0
    }

    def "return number of ocurrences of repeated values"() {
        when:   fc.readValues(["a", "b", "b", "c", "c", "c"])
        then:   fc.getValueCount(value) == count

        where:
        value | count
        "a" | 1
        "b" | 2
        "c" | 3
        "NOT_FOUND" | 0
    }
}
