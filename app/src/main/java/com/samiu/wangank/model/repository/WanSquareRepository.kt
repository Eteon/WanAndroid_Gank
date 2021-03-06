package com.samiu.wangank.model.repository

import com.samiu.wangank.global.NETWORK_ERROR
import com.samiu.wangank.model.http.BaseWanRepository
import com.samiu.wangank.model.http.WanClient

/**
 * @author Samiu 2020/3/5
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
class WanSquareRepository : BaseWanRepository() {

    suspend fun getSquareArticle(page: Int) = readyCall(
        call = {
            call(WanClient.service.getSquareArticleList(page))
        }, errorMessage = NETWORK_ERROR
    )
}