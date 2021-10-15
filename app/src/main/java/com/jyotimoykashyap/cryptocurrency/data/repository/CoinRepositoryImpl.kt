package com.jyotimoykashyap.cryptocurrency.data.repository

import com.jyotimoykashyap.cryptocurrency.data.remote.CoinPaprikaApi
import com.jyotimoykashyap.cryptocurrency.data.remote.dto.CoinDetailDto
import com.jyotimoykashyap.cryptocurrency.data.remote.dto.CoinDto
import com.jyotimoykashyap.cryptocurrency.domain.respository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> =
        api.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto =
        api.getCoinById(coinId = coinId)
}