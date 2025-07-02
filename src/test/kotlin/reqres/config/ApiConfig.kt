package reqres.config

import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.response.ValidatableResponse
import io.restassured.specification.RequestSpecification

/** Устанавливаем конфигурацию при помощи обьекта типа RequestSpecification из
 * библиотеки RESTAssured, для сокращения повторяющегося кода в тестах */

object ApiConfig {

    val baseSpec: RequestSpecification by lazy {
        RestAssured.baseURI = "https://reqres.in/api"
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

        RestAssured.given()
            .header("x-api-key", "reqres-free-v1")
            .contentType("application/json")
    }

    /** Создаем верификацию, для тестов, в которых 404 это ожидаемый ответ */

//    fun Response.verifySuccessOrPrintOn404(): ValidatableResponse {
//        return when (this.statusCode) {
//            200 -> this.then()
//            404 -> {
//                println("⚠️ 404 Not Found. Response: ${this.body.asString()}")
//                this.then() // Продолжаем цепочку без ошибки
//            }
//            else -> this.then()
//                .statusCode(200) // Упадёт здесь с подробной ошибкой
//        }
//    }
}
