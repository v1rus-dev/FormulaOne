package yegor.cheprasov.formulaone.core.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverEntity(
    @SerialName("broadcast_name")
    val broadcastName: String,
    @SerialName("country_code")
    val countryCode: String?,
    @SerialName("driver_number")
    val driverNumber: Int? = null,
    @SerialName("first_name")
    val firstName: String?,
    @SerialName("last_name")
    val lastName: String?,
    @SerialName("full_name")
    val fullName: String?,
    @SerialName("headshot_url")
    val headshotUrl: String?,
    @SerialName("meeting_key")
    val meetingKey: Int? = null,
    @SerialName("name_acronym")
    val nameAcronym: String,
    @SerialName("session_key")
    val sessionKey: Int? = null,
    @SerialName("team_colour")
    val teamColour: String?,
    @SerialName("team_name")
    val teamName: String?
)
