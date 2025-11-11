package yegor.cheprasov.formulaone.core.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionEntity(
    @SerialName("meeting_key")
    val meetingKey: Int,
    @SerialName("session_key")
    val sessionKey: Int,
    @SerialName("location")
    val location: String,
    @SerialName("date_start")
    val dateStart: String,
    @SerialName("date_end")
    val dateEnd: String,
    @SerialName("session_type")
    val sessionType: String,
    @SerialName("session_name")
    val sessionName: String,
    @SerialName("country_key")
    val countryKey: Int,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("circuit_key")
    val circuitKey: Int,
    @SerialName("circuit_short_name")
    val circuitShortName: String,
    @SerialName("gmt_offset")
    val gmtOffset: String,
    @SerialName("year")
    val year: Int
)

