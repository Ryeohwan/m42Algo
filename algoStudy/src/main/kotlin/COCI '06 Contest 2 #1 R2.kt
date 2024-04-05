/**
 * 문제 해석
 * S 는 R1 과 R2 두 숫자들의 의미로 불린다.
 * 만일 S 가 (R1 + R2)/2 라면 Mirko의 Slavko에게  생일 선물은 R1 과 R2 두 개였다.
 *  S 와 R1 이 있지만 R2 가 사라져버렸다. Slavko 가 R2 를 복구하도록 도와줘라.
 * */
fun main() {
    val input:String = readln()
    val array = input.split(" ")
    if(array.size != 2) throw IllegalArgumentException("Invalid ipnut count")
    val R1 = array.get(0).toIntOrNull() ?: throw IllegalArgumentException("R1 is not Int")
    val S = array.get(1).toIntOrNull() ?: throw IllegalArgumentException("S is not Int")
    if(!((R1 in -1000..1000) && (S in -1000..1000))){
        throw IllegalArgumentException("check R1 or S value it must not be lower than -1000 or bigger than 1000")
    }
    // 예외 처리 완료
    println(S*2 - R1)
}