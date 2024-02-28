*
	1번 문제
	답 : static {}
	      BlockTest bt = new BlockTest(); 
	      {}
	     생성자
	     static {}
	     BlockTest bt2 = new BlockTest(); 
	     {}
	     생성자



	2번 문제
	답 : 우선 cv,iv에는 0으로 초기화가 되었다가 static { cv = 2;}로 인해 cv에는 2의 값이 초기화가 되고
	{ iv = 2;} 으로 인해 iv에는 2에 값이 초기화가 된다. 이 이후에 생성자가 호출이 되므로 iv 에는 3이 초기화 되고
	class InitTest 내부에 있는 static int cv , int iv 선언으로 인해 cv,iv에는 각각 1씩 초기화가 된다.
*/
