package data.datasource

import data.service.FoodApiService
import data.service.FoodApiServiceImpl

interface FoodDataSource {
    fun getFoods(): List<String>
}

class FoodDataSourceImpl(
    private val apiService: FoodApiService
): FoodDataSource{

    override fun getFoods(): List<String> {
        return apiService.getFoods()
    }
}