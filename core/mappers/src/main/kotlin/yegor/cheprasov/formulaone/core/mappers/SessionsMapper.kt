package yegor.cheprasov.formulaone.core.mappers

import yegor.cheprasov.formulaone.core.api.entities.SessionEntity
import yegor.cheprasov.formulaone.core.domein_models.entities.Session

fun SessionEntity.toDomain(): Session =
    Session(
        meetingKey = meetingKey,
        sessionKey = sessionKey,
        location = location,
        dateStart = dateStart,
        dateEnd = dateEnd,
        sessionType = sessionType,
        sessionName = sessionName,
        countryKey = countryKey,
        countryCode = countryCode,
        countryName = countryName,
        circuitKey = circuitKey,
        circuitShortName = circuitShortName,
        gmtOffset = gmtOffset,
        year = year
    )