package data.datasource

import data.service.FoodApiService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class FoodDataSourceImplTest {

    @MockK
    lateinit var service: FoodApiService

    lateinit var dataSource: FoodDataSource

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        every {
            service.getFoods()
        } returns listOf(
            "Bakso",
            "Nasi Goreng"
        )
        dataSource = FoodDataSourceImpl(service)
    }

    @Test
    fun `is Food List not empty`(){
        assertTrue { dataSource.getFoods().isNotEmpty() }
    }

    @Test
    fun `is Food List size equals 2`(){
        assertEquals(dataSource.getFoods().size, 2)
    }

    @Test
    fun `is Food number 2 is "Nasi Goreng"`(){
        assertEquals(dataSource.getFoods()[1], "Nasi Goreng")
    }
}