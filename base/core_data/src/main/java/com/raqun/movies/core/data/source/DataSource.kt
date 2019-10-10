package com.raqun.movies.core.data.source

import io.reactivex.Single

interface DataSource {

    interface RetrieveRemoteDataSource<Req, Res : Any> : DataSource {
        fun getResult(request: Req): Single<Res>
    }

    interface Local<K, V> : DataSource {
        fun get(key: K): V?

        fun get(page: Int): List<V>

        fun getAll(): List<V>

        fun put(key: K?, data: V): Boolean

        fun putAll(data: List<V>)

        fun remove(value: V): Boolean

        fun removeByKey(key: K): Boolean

        fun clear()
    }

    interface Cache<KEY, VALUE> : DataSource {
        fun get(key: KEY): VALUE?

        fun put(key: KEY, value: VALUE): Boolean

        fun drop()
    }
}
