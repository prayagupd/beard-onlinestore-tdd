package com.beard

import spock.lang.Specification

interface Deps {
    String doSomethingDeps(String a, String b)
    String playWithMap(String a, Map<String, String> map)
}

class Dependency {

    String doSomethingDeps(String a, String b) {
        a +"-"+ b + "-" + UUID.randomUUID()
    }

    String playWithMap(String a, Map<String, String> map) {
        a +"-"+ b + "-" + UUID.randomUUID()
    }

}
class Subject {

    def dependency = new Dependency()

    String doSomethng(String a, String b){
        dependency.doSomethingDeps(a, b)
    }

    String doSomethngMap(String a){
        dependency.playWithMap(a, new HashMap<String, String>(){{
            put("a", "b")
        }})
    }

}

class MockMockFockSpecs extends Specification {

    def "returns a+b"() {

        def subject = new Subject()
        subject.dependency = Mock(Deps)

        when:
        def result = subject.doSomethng("a", "b")

        then:
        1 * subject.dependency.doSomethingDeps(_, _) >> "whatever"
        result == "whatever"
    }

    def "returns a+b map"() {

        def subject = new Subject()
        subject.dependency = Mock(Deps)

        when:
        def result = subject.doSomethngMap("a")

        then:
        1 * subject.dependency.playWithMap(_, _) >> "i am mockng things"
        result == "i am mockng things"
    }
}
