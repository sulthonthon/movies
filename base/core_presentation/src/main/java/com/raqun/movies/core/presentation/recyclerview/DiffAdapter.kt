package com.raqun.movies.core.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil

interface DiffAdapter {
    fun update(newItems: List<DisplayItem>)

    fun updateAllItems(newItems: List<DisplayItem>)

    fun updateOnlyChangedItems(newItems: List<DisplayItem>)

    fun updateItems(newItems: List<DisplayItem>)

    fun calculateDiff(newItems: List<DisplayItem>): DiffUtil.DiffResult

    fun updateWithOnlyDiffResult(result: DiffUtil.DiffResult)
}