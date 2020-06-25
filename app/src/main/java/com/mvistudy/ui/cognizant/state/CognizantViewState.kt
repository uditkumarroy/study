package com.mvistudy.ui.cognizant.state

import com.mvistudy.models.CognizantPost

data class CognizantViewState(
    var cognizantFelds: CognizantFields = CognizantFields()
) {
    data class CognizantFields(
        var cognizantPostList: List<CognizantPost> = ArrayList<CognizantPost>(),
        var searchQuery: String = ""
    )
}