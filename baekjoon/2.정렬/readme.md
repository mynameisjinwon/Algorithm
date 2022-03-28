| 문제            | 코드                                                         | 링크                                          |
| --------------- | ------------------------------------------------------------ | --------------------------------------------- |
| 국영수        | [링크](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon10825.java) | [링크](https://www.acmicpc.net/problem/10825) |
| 수열정렬      | [링크1](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon1015.java)  [링크2](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon1015_2.java)               | [링크](https://www.acmicpc.net/problem/1015)  |
| 카드          | [링크](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon11652.java) | [링크](https://www.acmicpc.net/problem/11652) |
| 화살표 그리기  | [링크1](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon15970.java)  [링크2](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon15970_2.java)              | [링크](https://www.acmicpc.net/problem/15970)
| 단어 정렬      | [링크](https://github.com/mynameisjinwon/TIL/blob/main/Java/Algorithm/baekjoon/2.%EC%A0%95%EB%A0%AC/baekjoon1181.java) | [링크](https://www.acmicpc.net/problem/1181) |


#### 정렬 문제를 풀 때 중요한 것

정렬의 특성을 이해하고 정렬이 필요한 문제인지를 파악한다.



##### 어떤 문제든지 문제를 풀기전에

1. 정답의 최대치를 계산해 적절한 자료형을 선택한다.
2. 시간복잡도를 계산해 해당 풀이가 가치가 있는 풀이인지를 판단한다.

위의 두가지 과정이 필요하다.



#### 정렬의 특성

1. 같은 정보들은 인접해 있다.
2. 각 원소마다 가장 가까운 원소는 자신의 양 옆에있다.

#### 시간 복잡도 

java의 정렬 알고리즘은 primitive 원소를 정렬할 때는 "Dual Pivot Quick Sort"를 사용한다. 

Dual Pivot Quick Sort는 최악의 경우 O(N^2)의 시간복잡도를 갖는다. 평균 시간 복잡도는 O(NlogN) 이다.

Object 원소를 정렬할 때는 "Tim Sort"를 사용한다. 

Tim sort는 선택정렬과 병합정렬을 합친 정렬 알고리즘이며 최악의 경우와 평균이 동일한 O(NlogN)의 시간복잡도를 갖는다.



