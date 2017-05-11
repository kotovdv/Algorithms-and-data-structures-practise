package com.kotovdv.algorithms.various.string.characters.uniqueness

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(DataProviderRunner::class)
abstract class UniqueCharactersCheckTest(val implementation: UniqueCharactersCheck) {

    companion object Scenarios {
        @DataProvider
        @JvmStatic
        fun scenarios(): Array<Array<Any>> {
            return arrayOf(
                    arrayOf("abcde", true),
                    arrayOf("AbcDE", true),
                    arrayOf("aA", true),
                    arrayOf("aa", false),
                    arrayOf("abcabc", false),
                    arrayOf("AbcdeA", false)
            )
        }
    }


    @Test
    @UseDataProvider("scenarios")
    fun testUniqueCharactersCheck(inputString: String, expectedResult: Boolean) {
        assertThat(implementation.checkCharactersUniqueness(inputString)).isEqualTo(expectedResult)
    }
}

class FirstUniqueCharactersCheckTest : UniqueCharactersCheckTest(FirstUniqueCharactersCheck())
class SecondUniqueCharactersCheckTest : UniqueCharactersCheckTest(SecondUniqueCharactersCheck())
class ThirdUniqueCharactersCheckTest : UniqueCharactersCheckTest(ThirdUniqueCharactersCheck())