package reqres.models

/**
 * data class User, используется для хранения данных во время выполнения тестов,
 * которые возвращаются в ответе
 */

data class User(
    val name: String? = null,
    val job: String? = null,
    val id: Int? = null
)
