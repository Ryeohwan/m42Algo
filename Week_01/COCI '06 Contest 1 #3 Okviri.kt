/**
 * 피터팬 프레임은 모든 문자가 다이아몬드 모양의 프레임으로 둘러쌓인 프레임이다.
 * 하지만 이런 프레이밍은 지루할 수 있기에 우리는 매 세 번째 글자마다 웬디 프레임을 사용할 것이다.
 * 웬디 프레임이 피터팬 프레임과 맞물릴 때 웬디 프레임은 그 위에 올라갑니다.
 *
 * 전부 스트링으로 설정해서
 * 맨 처음 5길이씩의 문자열 만든 후 입력받은 길이에 따라서 4자씩 추가한다.
 * 그리고 3으로 나눈 나머지가 2일 때 웬디패턴이 들어가야 하니까 그 부분은 . 으로 추가해서 그려준다.
 * */
fun main() {
    val inp = readln()
    val map = arrayOfNulls<String>(5)

    // 맨 윗줄과 아랫줄은 모양이 같다.
    map[0] = "..#.."
    map[4] = "..#.."
    for (i in 1..< inp.length) { // 이쪽이 추가로 붙일 4개씩이 되는 것이다.
        if (i % 3 == 2) {  // 웬디
            map[0] += ".*.."  // 4개
            map[4] += ".*.."
        } else {
            map[0] += ".#.."
            map[4] += ".#.."
        }
    }

    map[1] = ".#.#."
    map[3] = ".#.#."
    for (i in 1..< inp.length) {
        if (i % 3 == 2) {
            map[1] += "*.*."
            map[3] += "*.*."
        } else {
            map[1] += "#.#."
            map[3] += "#.#."
        }
    }

    map[2] = "#." + inp[0] + ".#"  // 가운데에 입력받은 문자
    for (i in 1..< inp.length) {
        if (i % 3 == 1) {
            map[2] += "." + inp[i]
            if (i == inp.length - 1) map[2] += ".#" else map[2] += ".*"
        } else if (i % 3 == 2) {
            map[2] += "." + inp[i] + ".*"
        } else {
            map[2] += "." + inp[i] + ".#"
        }
    }

    for (i in map.indices) {
        println(map[i])
    }
}