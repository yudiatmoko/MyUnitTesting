package data.repository

import data.datasource.FoodDataSource

interface FoodRepository {
    fun getFoods(): Result<List<String>>
}

class FoodRepositoryImpl(
    private val dataSource: FoodDataSource
): FoodRepository{
    override fun getFoods(): Result<List<String>> {
        return try {
            Result.success(dataSource.getFoods())
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}