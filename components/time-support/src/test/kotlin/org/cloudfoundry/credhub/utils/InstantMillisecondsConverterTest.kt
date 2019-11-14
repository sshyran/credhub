package org.cloudfoundry.credhub.utils

import java.time.Instant

import org.cloudfoundry.credhub.util.InstantMillisecondsConverter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat

@RunWith(JUnit4::class)
class InstantMillisecondsConverterTest {

    private var subject = InstantMillisecondsConverter()

    @Test
    fun canConvertAnInstantToTheDBRepresentation() {
        val now = Instant.ofEpochMilli(234234123)
        assertThat<Long>(subject.convertToDatabaseColumn(now), equalTo(234234123L))
    }

    @Test
    fun canConvertADBRepresentationIntoAnInstant() {
        assertThat(subject.convertToEntityAttribute(234234321L),
            equalTo(Instant.ofEpochMilli(234234321L)))
    }
}