package com

import org.junit.Test

/**
 * Created by prayagupd
 * on 2/8/16.
 */


class PackagePickTests {

    @Test
    void "should remove all white spaces pick the package"() {

        String.metaClass.removeAllSpacesBetweenTags = {
            delegate.replaceAll(">\\s+<", "><")
        }

        String body = """<PackageToPick>
                          <Where>Floor2</Where>


                        </PackageToPick>"""

        assert "<PackageToPick><Where>Floor2</Where></PackageToPick>" == body.removeAllSpacesBetweenTags()
    }
}
