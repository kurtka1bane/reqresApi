package reqres.tests

import org.junit.jupiter.api.Test
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import reqres.apiSteps.UserSteps
import org.hamcrest.Matchers.equalTo
import org.assertj.core.api.Assertions.assertThat
import org.apache.commons.lang3.RandomStringUtils


class GetUserTests {

    @Test
    fun `existing user returns 200 and valid body`(){
        UserSteps.getUserById(2)
            .then()
            .body(matchesJsonSchemaInClasspath("schema_validator/user_schema.json"))
    }

    @Test
    fun `non-existent user returns 404 and empty body`(){
        UserSteps.getUserById(15)
            .then()
            .statusCode(404)
            .body(equalTo("{}"))
    }

    @Test
    fun `list of users by page returns 200 and valid body` (){
        UserSteps.getListOfUsers(2)
            .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schema_validator/list_of_users.json"))
    }

    @Test
    fun `create new user and check data`() {

        val randomName = RandomStringUtils.randomAlphabetic(10)
        val randomJob = RandomStringUtils.randomAlphabetic(10)

        val response = UserSteps.createUser(randomName, randomJob)

        response.then()
            .statusCode(201)
            .body(matchesJsonSchemaInClasspath("schema_validator/create_user.json"))

        val user = UserSteps.lastUser ?: throw AssertionError("User not created")

        assertThat(user.job).isEqualTo(randomJob)
        assertThat(user.name).isEqualTo(randomName)
        assertThat(user.id.toString()).isNotBlank()

    }

    @Test
    fun `put new data in existing user and check data`(){
        val randomName = RandomStringUtils.randomAlphabetic(10)
        val randomJob = RandomStringUtils.randomAlphabetic(10)

        val response = UserSteps.updatePutUser(randomName, randomJob,3)

        response.then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schema_validator/put_and_patch_user.json"))

        val user = UserSteps.lastUser ?: throw AssertionError("User not created")


        assertThat(user.job).isEqualTo(randomJob)
        assertThat(user.name).isEqualTo(randomName)
    }

    @Test
    fun `update patch user and check data`(){
        val randomName = RandomStringUtils.randomAlphabetic(10)
        val randomJob = RandomStringUtils.randomAlphabetic(10)

        val response = UserSteps.updatePatchUser(randomName, randomJob,3)

        response.then().statusCode(200)

        val user = UserSteps.lastUser ?: throw AssertionError("User not created")

        assertThat(user.job).isEqualTo(randomJob)
        assertThat(user.name).isEqualTo(randomName)
    }
}

