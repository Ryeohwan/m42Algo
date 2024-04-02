import java.util.*

/**
 * 사악한 황제 선인장은 마법의 통을 소유하고 있고 마법에 걸린 숲을 물에 잠기게 했다.
 * 화가와 세 마리의 작은 고슴도치들은 이제 비버의 소굴로 가능한 빨리 도망쳐야 한다.
 * 마법의 숲의 지도는 열과 행으로 구성되어 있다.
 * 빈 땅은 . 으로 표시된다.
 * 물에 잠긴 땅은 *로 돌은 X로 표시되고 비버의 소굴은 D로 표시되고
 * 화가와 작은 고슴도치들은 S로 표시된다.
 *
 * 매 분마다 상하좌우로 이웃한 칸을 이동할 수 있고 매 분마다 물이 확장되어
 * 인접한 땅이 물에 잠긴다.
 * 물과 화가와 고슴도치는 바위를 통과할 수 없고
 * 화가와 고슴도치는 물을 통과할 수 없고
 * 물은 비버의 소굴에 범람할 수 없다.
 *
 * 최단 시간을 출력하는 프로그램을 작성하라.
 * 화가와 고슴도치는 동일 시간에 물에 잠길 땅으로 이동할 수 없다.
 *
 * 각각의 큐에 물과 화가의 위치를 받아서
 * 물을 먼저 범람시킨다. -> 이게 중요한게 물이 먼저 범람해야 문제에서 말하는 범람할 곳으로 화가가 이동하지 않게 한다.
 * 네 방향으로 전부 이동시키며 각 위치를 큐에 삽입해서 그 위치에서 또 가능한 위치로 이동시킨다. -> bfs 너비 우선 탐색
 * */
fun main() {
    var map: Array<CharArray>  // 숲
    var pos: Pair<Int, Int>   // 좌표
    var dx = listOf(-1, 1, 0, 0)  // 상하좌우
    var dy = listOf(0, 0, -1, 1)
    var water: Queue<Pair<Int, Int>> = LinkedList() // 물의 위치 후보
    var beaver: Queue<Pair<Int, Int>> = LinkedList() // 고슴도치의 위치 후보

    val inp = readln()
    val st = StringTokenizer(inp)
    var R = st.nextToken().toInt()
    var C = st.nextToken().toInt()
    map = Array(R){CharArray(C)}
    var temp : String
    for (i in 0..< R) {
        temp = readln()
        for (j in 0..< C) {
            if (temp[j] == '*') water.add(Pair(i, j))  // 물의 위치
            if (temp[j] == 'S') beaver.add(Pair(i, j))  // 시작 위치
            map[i][j] = temp[j]
        }
    }

    var day = 0
    while (true) {
        day++ // 날짜 체크
        var ax : Int
        var ay : Int
        for (i in 0..< water.size) {
            pos = water.poll()
            for (j in 0..< 4) {  // 사방탐색
                ax = pos.first + dx[j]
                ay = pos.second + dy[j]
                if(ax >= 0 && ax < R && ay >= 0 && ay < C && map[ax][ay] == '.'){  // 맵의 범위 안에 있으면서 물이 범람할 수 있는 곳
                    map[ax][ay] = '*'  // 물로 채워주고
                    water.add(Pair(ax, ay))  // 다시 큐에 넣는다.
                }
            }
        }

        if (beaver.size == 0) {  // 도달 가능한 경우가 없다.
            println("KAKTUS")
            return
        }

        for (i in 0..< beaver.size) {
            pos = beaver.poll()
            for (j in 0..< 4) {
                ax = pos.first + dx[j]
                ay = pos.second + dy[j]
                if(ax >= 0 && ax < R && ay >= 0 && ay < C){
                    if (map[ax][ay] == 'D') {
                        println(day)
                        return  // 바로 종료해도 되는 이유는 먼저 도착한 애가 바로 끝낼 테니까
                    }
                    if(map[ax][ay] == '.'){  // 갈 수 있는 위치로 이동했다면
                        map[ax][ay] = 'S'  // 그 위치를 화가와 두더지로 설정한다.
                        beaver.add(Pair(ax, ay))
                    }
                }
            }
        }
    }
}
