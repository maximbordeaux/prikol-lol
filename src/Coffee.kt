 open class Coffee (var size: Size = Size.SMALL, var price: Int = 100, var nameCaffee: NameCaffee = NameCaffee.OTHER_COFFEE) {
     init{
         when (nameCaffee){
             NameCaffee.RAF -> price + 50
             NameCaffee.OTHER_COFFEE -> price
         }
     }
     init {
         when (size) {
             Size.SMALL -> price
             Size.LARGE -> price + 20
         }
     }
 }

