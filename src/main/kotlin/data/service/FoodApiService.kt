package data.service

interface FoodApiService {
    fun getFoods(): List<String>
}

class FoodApiServiceImpl(): FoodApiService{
    override fun getFoods(): List<String>  = listOf(
        "Nasi Goreng",
        "Babat Goreng",
        "Mie Goreng",
        "Bakso",
        "Bebek Goreng"
    )
}