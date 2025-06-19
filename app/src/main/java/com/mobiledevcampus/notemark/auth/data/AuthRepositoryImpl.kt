import com.mobiledevcampus.notemark.auth.data.LoginRequest
import com.mobiledevcampus.notemark.auth.data.LoginResponse
import com.mobiledevcampus.notemark.auth.data.RegisterRequest
import com.mobiledevcampus.notemark.auth.domain.AuthRepository
import com.mobiledevcampus.notemark.core.data.networking.post
import com.mobiledevcampus.notemark.core.domain.AuthInfo
import com.mobiledevcampus.notemark.core.domain.SessionStorage
import com.mobiledevcampus.notemark.core.domain.util.DataError
import com.mobiledevcampus.notemark.core.domain.util.EmptyResult
import com.mobiledevcampus.notemark.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient
import com.mobiledevcampus.notemark.core.domain.util.Result

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(username: String, email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/api/auth/login",
            body = LoginRequest(
                username = username,
                email = email,
                password = password
            )
        )
        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                )
            )
        }
        return result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/api/auth/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}