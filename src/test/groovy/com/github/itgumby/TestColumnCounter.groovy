package com.github.itgumby

import spock.lang.Specification

class TestFieldCounter extends Specification {
    ColumnCounter fc = new ColumnCounterImpl()

    def "zero counts on no records"() {
        when:
        def records = fc.getRecordCount()
        def blanks = fc.getBlankCount()

        then:
        records == 0
        blanks == 0
    }

    def "counts on a single field"() {
        when:
        fc.readValue("a")

        then:
        fc.getRecordCount() == 1
        fc.getBlankCount() == 0
    }

    def "counts on a single empty field"() {
        when:
        fc.readValue("")

        then:
        fc.getRecordCount() == 1
        fc.getBlankCount() == 1
    }
}
