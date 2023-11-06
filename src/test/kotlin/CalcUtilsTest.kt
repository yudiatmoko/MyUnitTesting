import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CalcUtilsTest {

    private lateinit var calcUtils: CalcUtils

    @BeforeEach
    fun setUp() {
        calcUtils = CalcUtils()
    }

    @Test
    fun calculateSuccess() {
        // 2 + 1 = 3
        assertEquals(calcUtils.calculate(2,1), 3)
        assertEquals(calcUtils.calculate(3,5), 8)
        assertInstanceOf(Number::class.java, calcUtils.calculate(3,5))
    }
}