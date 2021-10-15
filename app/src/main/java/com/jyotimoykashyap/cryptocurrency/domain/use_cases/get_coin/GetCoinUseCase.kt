package com.jyotimoykashyap.cryptocurrency.domain.use_cases.get_coin

import com.jyotimoykashyap.cryptocurrency.common.Resource
import com.jyotimoykashyap.cryptocurrency.data.remote.dto.toCoin
import com.jyotimoykashyap.cryptocurrency.data.remote.dto.toCoinDetail
import com.jyotimoykashyap.cryptocurrency.domain.models.Coin
import com.jyotimoykashyap.cryptocurrency.domain.models.CoinDetail
import com.jyotimoykashyap.cryptocurrency.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =
        flow {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
                emit(Resource.Success(coin))
            }catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }catch (e: IOException){
                emit(Resource.Error(
                    "Couldn't reach server"
                ))
            }
        }
}