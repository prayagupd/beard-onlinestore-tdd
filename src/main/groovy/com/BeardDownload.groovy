package com
/**
 * Created by prayagupd
 * on 1/5/16.
 */

class BeardDownload {

    private List<Person> persons

    def count(def few) {
        if (few.equals("all")) {
            Long.MAX_VALUE
        } else {
            persons.size()
        }
    }

    public def setPersons(def p) {
        this.persons = p
    }
}
