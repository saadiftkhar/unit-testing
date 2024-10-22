package com.unittesting.android

import android.content.Context
import androidx.core.content.ContextCompat.getString
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class MockedContextTest {

    @Mock
    private lateinit var mMockedContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        val mockContext = mock<Context> {
            on { getString(R.string.app_name) } doReturn FAKE_STRING
        }
    }
}