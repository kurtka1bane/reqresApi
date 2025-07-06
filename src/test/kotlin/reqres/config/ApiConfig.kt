package reqres.config

import io.restassured.RestAssured
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


}
