package yegor.cheprasov.formulaone.core.domein_models.entities

import kotlinx.serialization.Serializable

@Serializable
data class Driver(
    val broadcastName: String,
    val countryCode: String?,
    val driverNumber: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val headshotUrl: String,
    val meetingKey: Int?,
    val nameAcronym: String,
    val sessionKey: Int?,
    val teamColour: String,
    val teamName: String
)
