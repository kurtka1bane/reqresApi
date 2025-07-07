package reqres.apiSteps


import io.restassured.RestAssured.given
import io.restassured.response.Response
import reqres.config.ApiConfig
import reqres.models.User

object UserSteps {
    // кастомный given(), что бы не повторятся в коде
    private fun given() = given(ApiConfig.baseSpec)

    var lastUser: User? = null

    fun getUserById(id: Int): Response {

        return given()
            .`when`()
            .get("/users/$id")
            .then()
            .extract()
            .response()
    }

    fun getListOfUsers(page: Int? = null): Response {
        return given()
            .apply {
                if (page != null) {
                    queryParam("page", page)
                }
            }
            .get("/users")
            .then()
            .statusCode(200)
            .extract()
            .response()

    }

    fun createUser(name: String, job: String): Response {
        return given()
            .body("""{"name":"$name", "job":"$job"}""")
            .post("/users")
            .then()
            .statusCode(201)
            .extract()
            .response()
            .also { response ->
                // Сохраняем пользователя в переменную класса
                lastUser = User(
                    name = response.path<String>("name"),
                    job = response.path<String>("job"),
                    id = response.path<Any>("id").toString().toInt() // Безопасное приведение
                )
            }
    }


    fun updatePutUser(name: String, job: String, id: Int): Response {
        return given()
            .body("""{"name":"$name", "job":"$job"}""")
            .`when`()
            .put("/users/$id")
            .then()
            .extract()
            .response()
            .also { response ->
                lastUser = User(
                    name = response.path<String>("name"),
                    job = response.path<String>("job")
                )
            }
    }

    fun updatePatchUser(name: String, job: String, id: Int): Response {
        return given()
            .body("""{"name":"$name", "job":"$job"}""")
            .`when`()
            .put("/users/$id")
            .then()
            .extract()
            .response()
            .also { response ->
                lastUser = User(
                    name = response.path<String>("name"),
                    job = response.path<String>("job")
                )
            }
    }
}




