package yegor.cheprasov.formulaone.core.domein_models.enums

enum class Driver(
    val firstName: String,
    val lastName: String,
    val command: Command,
    val number: Int
) {
    LandoNorris("Lando", "Norris", Command.McLaren, 4),
    OscarPiastri("Oscar", "Piastri", Command.McLaren, 81),

    GeorgeRussell("George", "Russell", Command.Mercedes, 63),
    KimiAntonelli("Kimi", "Antonelli", Command.Mercedes, 12),

    MaxVerstappen("Max", "Verstappen", Command.RedBullRacing, 1),
    YukiTsunoda("Yuki", "Tsunoda", Command.RedBullRacing, 22),

    CharlesLeclerc("Charles", "Leclerc", Command.Ferrari, 16),
    LewisHamilton("Lewis", "Hamilton", Command.Ferrari, 44),

    AlexanderAlbon("Alexander", "Albon", Command.Williams, 23),
    CarlosSainz("Carlos", "Sainz", Command.Williams, 55),

    LiamLawson("Liam", "Lawson", Command.RacingBulls, 30),
    IsackHadjar("Isack", "Hadjar", Command.RacingBulls, 6),

    FernandoAlonso("Fernando", "Alonso", Command.AstonMartin, 14),
    LanceStroll("Lance", "Stroll", Command.AstonMartin, 18),

    OliverBearman("Oliver", "Bearman", Command.Haas, 31),
    EstebanOcon("Esteban", "Ocon", Command.Haas, 87),

    NicoHulkenberg("Nico", "Hulkenberg", Command.Sauber, 27),
    GabrielBortoleto("Gabriel", "Bortoleto", Command.Sauber, 5),

    PierreGasly("Pierre", "Gasly", Command.Alpine, 10),
    FrancoColapinto("Franco", "Colapinto", Command.Alpine, 43);
}