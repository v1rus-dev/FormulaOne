package yegor.cheprasov.formulaone.core.domein_models.entities

data class Session(
    val meetingKey: Int,
    val sessionKey: Int,
    val location: String,
    val dateStart: String,
    val dateEnd: String,
    val sessionType: String,
    val sessionName: String,
    val countryKey: Int,
    val countryCode: String,
    val countryName: String,
    val circuitKey: Int,
    val circuitShortName: String,
    val gmtOffset: String,
    val year: Int
)

