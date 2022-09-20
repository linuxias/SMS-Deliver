package com.linuxias.smsdeliver

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.linuxias.smsdeliver.data.FilterDao
import com.linuxias.smsdeliver.data.FilterDatabase
import com.linuxias.smsdeliver.data.FilterEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FilterDaoTest {
    private lateinit var database: FilterDatabase
    private lateinit var dao: FilterDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FilterDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.filterDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertFilterTest() = runTest {
        val entity = FilterEntity(
            id = 1,
            receiverNumber = "010-1234-5678",
            filterRegex = "RegexTest"
        )

        dao.insertFilter(entity)

        val allFilterEntities = dao.getAllFilters()
        assertThat(allFilterEntities).contains(entity)
    }

    @Test
    fun deleteFilterTest() = runTest {
        val entity = FilterEntity(
            id = 1,
            receiverNumber = "010-1234-5678",
            filterRegex = "RegexTest"
        )

        dao.insertFilter(entity)
        dao.deleteFilter(entity)

        val allFilterEntities = dao.getAllFilters()
        assertThat(allFilterEntities).doesNotContain(entity)
    }
}