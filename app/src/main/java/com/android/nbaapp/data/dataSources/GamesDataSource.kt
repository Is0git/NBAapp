package com.android.nbaapp.data.dataSources

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.services.GamesService
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import kotlinx.coroutines.*
import retrofit2.Retrofit
import javax.inject.Inject

@AllGamesScope
class GamesDataSource @Inject constructor(val retrofit:Retrofit) : PageKeyedDataSource<Int, GamesPojo.Data>() {
    lateinit var service:GamesService
    init {
        service = retrofit.create(GamesService::class.java)
    }
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GamesPojo.Data>
    ) {
       CoroutineScope(Dispatchers.IO).launch {
            service.getGames("2020", "0", params.requestedLoadSize.toString()).let {
                withContext(Dispatchers.Main) {  if(it.isSuccessful) callback.onResult(it.body()?.data?.toMutableList()!!, 0, params.requestedLoadSize, 0, 1)}
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GamesPojo.Data>) {
        CoroutineScope(Dispatchers.IO).launch {
            service.getGames("2020", params.key.toString(), params.requestedLoadSize.toString()).let {
                withContext(Dispatchers.Main) {   if(it.isSuccessful) callback.onResult(it.body()?.data!!, params.key)}

            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GamesPojo.Data>) {

    }

}