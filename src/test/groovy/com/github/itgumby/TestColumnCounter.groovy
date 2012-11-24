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
        values << [ [], ["a"], ["a", "b", "c"]]
        numRecords << [0, 1, 3]
    }

    def "count blanks for zero, 1, or more blanks"() {
        when:
        fc.readValues(values)

        then:
        fc.getBlankCount() == blanks

        where:
        values << [ [], [""], ["", "", ""]]
        blanks << [0, 1, 3]
    }

    def "return number of ocurrences of values"() {
        when:   fc.readValues(["a", "b", "c", "b", "c", "c"])
        then:   fc.getValueCount(value) == count

        where:
        value << ["a", "b", "c", "NOT_FOUND"]
        count << [1, 2, 3, 0]

    }
}
