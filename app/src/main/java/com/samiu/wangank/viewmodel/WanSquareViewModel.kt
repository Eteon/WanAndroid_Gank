package com.samiu.wangank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samiu.wangank.model.bean.Article
import com.samiu.wangank.model.http.WanResult
import com.samiu.wangank.model.repository.WanSquareRepository
import kotlinx.coroutines.launch

/**
 * @author Samiu 2020/3/5
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
class WanSquareViewModel(
    private val wanSquareRepository: WanSquareRepository
) : ViewModel() {

    val mArticles = MutableLiveData<List<Article>>()

    fun getArticles(page: Int) = viewModelScope.launch {
        val articleList = wanSquareRepository.getSquareArticle(page)
        if (articleList is WanResult.Success)
            mArticles.value = articleList.data.datas
    }
}