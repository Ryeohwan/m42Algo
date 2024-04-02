/**
 * 두 정수가 주어진다. A modulo B 는 A를 B로 나눴을 때의 나머지이다.
 * 예를 들어서 7, 14, 27 그리고 38 이라는 수들은 modulo 3을 하면 1, 2, 0 그리고 2가 된다.
 * 10개의 수를 받아서 입력을 받고 출력으로
 * modulo 42를 했을 때를 고려해서
 * 그 입력받은 수들의 나머지 중 중복을 제외한 몇 개의 수가 있는지를 출력하는 프로그램을 작성하라.
 * */
fun main() {
    println((1..10).fold(mutableSetOf<Int>()){ sett, _ ->  // mutableSet으로 중복제거
        sett.add(readln().toIntOrNull()?.let {  // null 처리
            if(it < 0 || it > 1000) throw Throwable("invalid Range")  // 예외처리
            it % 42// 42의 나머지
        }?: throw Throwable("invalid range"))
        sett
    }.size)
}