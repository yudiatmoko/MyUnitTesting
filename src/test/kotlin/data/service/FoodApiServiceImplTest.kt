package data.service

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FoodApiServiceImplTest {

    @MockK
    lateinit var service: FoodApiService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        every {
            service.getFoods()
        } returns listOf(
            "Bakwan",
            "Siomay",
            "Fanta"
        )
    }

    @Test
    fun getMockFoods() {
        assertEquals(service.getFoods().size, 3)
        assertEquals(service.getFoods()[1], "Siomay")
        assertEquals(service.getFoods()[2], "Fanta")
    }

    @Test
    fun getActualFoods() {
        val service = FoodApiServiceImpl()

        assertTrue{service.getFoods().isNotEmpty()}
        assertEquals(service.getFoods().size, 5)
        assertEquals(service.getFoods()[1], "Babat Goreng")
    }
}