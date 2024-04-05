/**
 *  A,B 그리고 C 가 주어진다. 그 숫자들은 정확안 순서에 의해 주어지지 않는다.
 *  그러나 우리는 A 는 B 보다 작고 B는 C 보다 작은 것은 알 수 있다.
 *  더 보기 좋게 만들기 위해 우리는 주어진 순서를 재배치하길 원한다.
 * */
fun main() {
    val inputNums = readln()
    val inputOrder = readln()
    val numberArray = inputNums.split(" ")
    if(numberArray.size != 3) throw IllegalArgumentException("You must input three numbers and All three numbers must be Integer type that less than or equal to 100")
    val oneVal = numberArray[0].toIntOrNull() ?: throw IllegalArgumentException("You Entered wrong value A")
    val twoVal = numberArray[1].toIntOrNull() ?: throw IllegalArgumentException("You Entered wrong value B")
    val threeVal = numberArray[2].toIntOrNull() ?: throw IllegalArgumentException("You Entered wrong value C")
    val numSet = listOf(oneVal, twoVal, threeVal).map {
        if(it !in Int.MIN_VALUE .. 100) throw IllegalArgumentException("not valid int it must be Integer type that less than or equal to 100")
    }
    if(inputOrder.length != 3) throw IllegalArgumentException("You must Enter 3 char in (ABC)")
    val one = inputOrder[0].uppercaseChar()
    val two = inputOrder[1].uppercaseChar()
    val three = inputOrder[2].uppercaseChar()
    listOf(one, two, three).map {
        if(it !in 'A'..'C') throw IllegalArgumentException("not valid character it must be a or b or c")
    }
    // vali 완료


}