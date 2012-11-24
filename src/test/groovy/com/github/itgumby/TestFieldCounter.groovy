package com.github.itgumby

import spock.lang.Specification

class TestFieldCounter extends Specification {
    FieldCounter fc = new FieldCounterImpl()

    def "zero counts on no records"() {
        when:
        def records = fc.getRecordCount()
        def blanks = fc.getBlankCount()

        then:
        records == 0
        blanks == 0
    }

}
