fun main() {
    println(
        """На улице сегодня отличная погодка! 
        |Именно сегодня ты решил посетить кофейню, которую тебе рекомендовали давным давно.
        |Ты заходишь в EBANIY CLASHROYAL, и тебя встречает вежливый бариста.
        |Он говорит: "Здравствуйте, что для вас приготовим?"
        |Представься.""".trimMargin()
    )
    val you = User("иисус", 200)
    val coffee = Coffee()
    val urname = readLine()!!.toString().lowercase()
    you.name = urname
    println("""${you.name}! Твой счёт:${you.cash}.Что будешь брать?
            |Ты смотришь на меню : капучино, латте, раф, американо.""".trimMargin()
    )
    askForCoffee(coffee)
    askForVolume(coffee)
    println("Вам что-нибудь добавить в кофе?")
    askForDaNet()
    println("""Все готово. Ваш заказ стоит: ${coffee.price}  С вашего счета будет списаны средства автоматически.
            |Хорошего дня $urname!""".trimMargin())
    val minus = you.cash?.minus(coffee.price)
    println("Ваш счет: $minus")
}

fun askForCoffee(coffee: Coffee): Coffee {
    val nameCoffee = listOf("капучино", "латте", "раф", "американо")
    val answer1 = readLine()?.lowercase()
    if (answer1 !in nameCoffee) {
        println("Повторите пожалуйста...")
        return askForCoffee(coffee)
    }
    if (answer1 == "раф"){
        coffee.nameCaffee = NameCaffee.RAF
    }
    return coffee
}

fun askForVolume(coffee: Coffee): Coffee {
    val nameVolume = listOf("большой", "маленький")
    println("Большой или маленький?")
    val answer2 = readLine()?.lowercase()
    if (answer2 !in nameVolume) {
        println("Повторите пожалуйста...")
        return askForVolume(coffee)
    }
    if (answer2 == "большой"){
        coffee.size = Size.LARGE
    }
    return coffee
}

fun askForDaNet() {
    val nameDaNet = listOf("да", "нет")
    val nameAdd = listOf("сахар", "сироп", "корица")
    println("Да или нет?")
    val answer3 = readLine()?.lowercase()
    if (answer3 !in nameDaNet) {
        println("Повторите пожалуйста...")
        return askForDaNet()
    } else if (answer3 == "да") {
        askForAdd(nameAdd)
    }

}

fun askForAdd(nameAdd: List<String>) {
    println("Сахар, сироп, корица?")
    val answer4 = readLine()!!.split(" ").map { it.lowercase() }
    if (!nameAdd.containsAll(answer4)) {
        return askForAdd(nameAdd)
    }
}

//fun askForName(nameName: List<String>) {
//    println("Ваш заказ будет готов в течении 2-3 минут. Назовите ваше имя")
//    var answer5 = readLine()?.lowercase()
//    if (answer5 in nameName) {
//        println("Отче наш! Да светится имя Твое!")
//    } else {
//        println("А это ты тот самый пидор! Катись отсюда нахуй!")
//    }
//}


