package chapter11EX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//public class Exerciser11_10 {
//
//	public static void main(String[] args) {
//
//		Set<String> set = new HashSet<>();
//		int[][] board = new int[5][5];
//		for(int i=0; set.size() < 25; i++) {
//			set.add((int)(Math.random()*30)+1+"");
//		}
//		ArrayList<String> list = new ArrayList<>(set);
//		Collections.shuffle(list);
//
//		Iterator<String> it = list.iterator();
//
//		for(int i=0; i < board.length; i++) {
//			for(int j=0; j < board[i].length; j++) {
//				board[i][j] = Integer.parseInt((String)it.next());
//				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
//			}
//			System.out.println();
//		}
//		//		답 : HashSet은 중복을 허용하지 않고 순서를 유지하지 않기 때문에 발생하는 문제이
//		//		다. 아무리 임의의 순서로 저장을 해도, 해싱 (hashing) 알고리즘의 특성상 한 숫자가 고
//		//		정된 위치에 저장되기 때문이다.
//	}
//}


