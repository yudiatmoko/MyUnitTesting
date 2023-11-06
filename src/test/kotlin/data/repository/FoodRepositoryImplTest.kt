package data.repository

import data.datasource.FoodDataSource
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FoodRepositoryImplTest {

    @MockK
    lateinit var dataSource: FoodDataSource

    lateinit var repository: FoodRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        repository = FoodRepositoryImpl(dataSource)
    }

    @Test
    fun `get data success`(){
        every { dataSource.getFoods() } returns listOf("Bakso", "Mie Goreng")

        val result = repository.getFoods()

        assertEquals(result.isSuccess, true)

        assertEquals(result.getOrNull()?.size, 2)

        verify { dataSource.getFoods() }
    }

    @Test
    fun `get data failed`(){
        every { dataSource.getFoods() } throws IllegalStateException("Get Foods Failed")

        val result = repository.getFoods()

        assertEquals(result.isSuccess, false)

        assertEquals(result.isFailure, true)

        assertInstanceOf(IllegalStateException::class.java, result.exceptionOrNull())

        verify { dataSource.getFoods() }
    }
}