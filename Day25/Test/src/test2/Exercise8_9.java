package test2;

public class Exercise8_9 {

	public static void main(String[] args) throws Exception {
		//Test2 5번문제
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);

	}

}

class UnsupportedFuctionException extends RuntimeException {

	private final int ERR_CODE = 100;



	UnsupportedFuctionException(String msg, int errCode) { // 생성자

		super(msg);    //조상의 생성자 RuntimeException(String msg)를 호출

		//ERR_CODE = errCode;

	}



	UnsupportedFuctionException(String msg) {

		this(msg, 100); // ERR_CODE를 100(기본값)으로 초기화한다.

	}



	public int getErrCode() { // 에러코드를 얻을 수 있는 메서드

		return ERR_CODE;

	}



	public String getMessage() { // Exception의 getMessage()를 오버라이딩 한다.

		return "[" + getErrCode() + "]" + super.getMessage();

	}
}
