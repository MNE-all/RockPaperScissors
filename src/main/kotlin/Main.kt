val answers = arrayOf("камень", "ножницы", "бумага")

fun main() {
    do {
        println("\u001b[0mИгра камень ножницы бумага")
        val comPlayer = computerChoice()
        val manPlayer = playerChoice("Выберите предмет:\n1. Камень \n2. Ножницы \n3. Бумага\nВаш выбор: ")
        val result = result(comPlayer, manPlayer)
        print("\u001b[32m$result\n")
    } while (result == "Ничья")
}

fun computerChoice(): Int{
    return answers.indexOf(answers.random()) + 1
}

fun playerChoice(message: String): Int{
    print(message)
    val userInput = readln()
    return when (userInput.lowercase()){
        "1", "камень" -> 1
        "2", "ножницы" -> 2
        "3", "бумага" -> 3
        else -> {
            println("Ошибка ввода!\nДля корректного ввода введите либо название, либо цифру предмета")
            playerChoice(message)
        }
    }
}

fun result(player1: Int, player2: Int): String{
    var result = ""
    val results = arrayOf("Бумага обёртывает камень", "Камень затупляет или ломает ножницы", "Ножницы разрезают бумагу")
    if (player1 == player2){
        return "Ничья"
    }
    else if (player1 == 1 && player2 == 2 || player2 == 1 && player1 == 2) {
        result = results[1]
    }
    else if (player1 == 2 && player2 == 3 || player2 == 2 && player1 == 3) {
        result = results[2]
    }
    else if (player1 == 3 && player2 == 1 || player2 == 3 && player1 == 1) {
        result = results[0]
    }
    return if (player1 == 1 && player2 == 2 || player1 == 2 && player2 == 3 || player1 == 3 && player2 == 1) {

        "\u001b[31m$result\nПобеждает компьютер"
    }
    else {
        "$result\nВы победили!"
    }
}