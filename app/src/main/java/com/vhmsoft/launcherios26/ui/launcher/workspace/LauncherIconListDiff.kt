package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherIconListDiff {
    fun between(
        oldItems: List<LauncherHomeItemUiModel>,
        newItems: List<LauncherHomeItemUiModel>
    ): Result {
        if (oldItems.size != newItems.size) {
            return Result(
                requiresFullRefresh = true,
                changedIndices = emptyList()
            )
        }

        val move = singleMoveBetween(oldItems, newItems)
        if (move != null) {
            val reorderedOldItems = oldItems.toMutableList().apply {
                val movedItem = removeAt(move.fromPosition)
                add(move.toPosition, movedItem)
            }
            return Result(
                requiresFullRefresh = false,
                changedIndices = reorderedOldItems.indices.filter { index ->
                    reorderedOldItems[index] != newItems[index]
                },
                move = move
            )
        }

        return Result(
            requiresFullRefresh = false,
            changedIndices = oldItems.indices.filter { index ->
                oldItems[index] != newItems[index]
            }
        )
    }

    private fun singleMoveBetween(
        oldItems: List<LauncherHomeItemUiModel>,
        newItems: List<LauncherHomeItemUiModel>
    ): Move? {
        val oldIds = oldItems.map { item -> item.stableId }
        val newIds = newItems.map { item -> item.stableId }
        if (oldIds == newIds) return null
        if (oldIds.toSet() != newIds.toSet()) return null

        oldIds.forEachIndexed { fromPosition, stableId ->
            val toPosition = newIds.indexOf(stableId)
            if (toPosition == -1 || toPosition == fromPosition) return@forEachIndexed

            val movedIds = oldIds.toMutableList().apply {
                val movedId = removeAt(fromPosition)
                add(toPosition, movedId)
            }
            if (movedIds == newIds) {
                return Move(fromPosition, toPosition)
            }
        }
        return null
    }

    data class Result(
        val requiresFullRefresh: Boolean,
        val changedIndices: List<Int>,
        val move: Move? = null
    )

    data class Move(
        val fromPosition: Int,
        val toPosition: Int
    )
}
