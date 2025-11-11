package yegor.cheprasov.formulaone.core.design.extensions

import yegor.cheprasov.formulaone.core.design.R
import yegor.cheprasov.formulaone.core.domein_models.enums.Driver

fun Driver.getDriverMainImage(): Int =
    when(this) {
        Driver.LandoNorris -> R.drawable.driver_mclarenlannor01right
        Driver.OscarPiastri -> R.drawable.driver_mclarenoscpia01right
        Driver.GeorgeRussell -> R.drawable.driver_mercedesgeorus01right
        Driver.KimiAntonelli -> R.drawable.driver_mercedesandant01right
        Driver.MaxVerstappen -> R.drawable.driver_redbullracingmaxver01right
        Driver.YukiTsunoda -> R.drawable.driver_redbullracingyuktsu01right
        Driver.CharlesLeclerc -> R.drawable.driver_ferrarichalec01right
        Driver.LewisHamilton -> R.drawable.driver_ferrarilewham01right
        Driver.AlexanderAlbon -> R.drawable.driver_williamsalealb01right
        Driver.CarlosSainz -> R.drawable.driver_williamscarsai01right
        Driver.LiamLawson -> R.drawable.driver_racingbullslialaw01right
        Driver.IsackHadjar -> R.drawable.driver_racingbullsisahad01right
        Driver.FernandoAlonso -> R.drawable.driver_astonmartinferalo01right
        Driver.LanceStroll -> R.drawable.driver_astonmartinlanstr01right
        Driver.OliverBearman -> R.drawable.driver_haasolibea01right
        Driver.EstebanOcon -> R.drawable.driver_haasestoco01right
        Driver.NicoHulkenberg -> R.drawable.driver_kicksaubernichul01right
        Driver.GabrielBortoleto -> R.drawable.driver_kicksaubergabbor01right
        Driver.PierreGasly -> R.drawable.driver_alpinepiegas01right
        Driver.FrancoColapinto -> R.drawable.driver_alpinefracol01right
    }
