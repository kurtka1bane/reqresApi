package reqres.models

import reqres.apiSteps.UserSteps

data class User(
    val name: String? = null,
    val job: String? = null,
    val id: Int? = null
)
