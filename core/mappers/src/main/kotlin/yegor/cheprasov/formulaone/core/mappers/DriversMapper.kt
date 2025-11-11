package yegor.cheprasov.formulaone.core.mappers

import yegor.cheprasov.formulaone.core.api.entities.DriverEntity
import yegor.cheprasov.formulaone.core.domein_models.entities.Driver

fun DriverEntity.toDomainOrNull(): Driver? {

    if (
        firstName == null ||
        lastName == null ||
        fullName == null ||
        headshotUrl == null ||
        teamColour == null ||
        teamName == null ||
        driverNumber == null
    )
        return null

    return Driver(
        broadcastName = this.broadcastName,
        countryCode = this.countryCode,
        driverNumber = this.driverNumber!!,
        firstName = this.firstName!!,
        lastName = this.lastName!!,
        fullName = this.fullName!!,
        headshotUrl = this.headshotUrl!!,
        meetingKey = this.meetingKey,
        nameAcronym = this.nameAcronym,
        sessionKey = this.sessionKey,
        teamColour = this.teamColour!!,
        teamName = this.teamName!!
    )
}