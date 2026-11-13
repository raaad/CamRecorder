package com.salat.recorder.data.utils

import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class RecorderRepositoryUtilsTest {
    @Test
    fun segmentGroupKeyRecognizesCurrentSegmentsAndSidecars() {
        val expected = "12-34-56_07.11.26"

        assertEquals(expected, File("${expected}_120_20_F.ts").segmentGroupKeyOrNull())
        assertEquals(expected, File("${expected}_120_20_F.h264.idx").segmentGroupKeyOrNull())
    }

    @Test
    fun segmentGroupKeyRecognizesLegacySegments() {
        assertEquals(
            "26.11.07_12-34-56",
            File("26.11.07_12-34-56_front.ts").segmentGroupKeyOrNull(),
        )
    }

    @Test
    fun segmentGroupKeyRejectsUnrelatedFiles() {
        assertNull(File("notes_120_20_F.ts").segmentGroupKeyOrNull())
    }
}
