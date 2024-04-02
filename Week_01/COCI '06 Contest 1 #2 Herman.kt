/**
 * 19세기 독일의 수학자 헤르멘은 유클리드 기하학이 아닌 taxicab 이라는 기하학(geometry)을 연구했다.
 * taxicab 기하학에서 두 점(T1(x1, y1) , T2(x2,y2))사이의 거리는
 * D(T1, T2) = |x1 - x2| + |y1 - y2| 로 정의된다.
 * 원의 정의를 포함한 다른 정의들은 유클리드 기하학에서 동일하다.
 * 원은 고정된 점(원의 중심)으로부터 고정된 거리(반지름)에 있는 평면의 모든 점들의 집합이다.
 * 우리는 반지름이 있는 두 원의 넓이의 차이에 관심이 있다.
 * 하나는 유클리드 기하학이고 다른 하나는 taxicab 기하학이다.
 * 이 어려운 문제의 해결은 당신에게 달려있다.
 *
 *
 * 풀이
 * 0,0 에서 21 까지의 거리로 따져서 거리를 구하면
 * 21 * 21 = 441 이다.
 * 441 * 2 = 882
 * */
fun main() {
  readln().toIntOrNull()?.let {
      println(String.format("%.6f",Math.round((it * it * Math.PI) * 1e6) / 1e6))
      println(String.format("%.6f",Math.round((it * it) * 2 * 1e6) / 1e6))
  }?:throw IllegalArgumentException("err")
}