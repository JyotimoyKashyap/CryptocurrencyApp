package com.jyotimoykashyap.cryptocurrency.domain.respository

import com.jyotimoykashyap.cryptocurrency.data.remote.dto.CoinDetailDto
import com.jyotimoykashyap.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}