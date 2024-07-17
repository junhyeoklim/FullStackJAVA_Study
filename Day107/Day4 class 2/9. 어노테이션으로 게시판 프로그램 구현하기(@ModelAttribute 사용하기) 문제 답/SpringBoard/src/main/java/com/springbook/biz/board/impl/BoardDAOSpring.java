package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		final String SQL = "INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?,?,?)";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		final String SQL = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		final String SQL = "DELETE FROM BOARD WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getSeq());
	}
	
	// 글 상세 조회
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
//		final String SQL = "SELECT * FROM BOARD WHERE SEQ=?";
//		return getJdbcTemplate().queryForObject(SQL, new BoardRowMapper(), vo.getSeq());
//	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		final String SQL = "SELECT * FROM BOARD WHERE SEQ=?";
		return jdbcTemplate.queryForObject(SQL, args, new BoardRowMapper());
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		final String SQL = "SELECT * FROM BOARD ORDER BY SEQ DESC";
		return jdbcTemplate.query(SQL, new BoardRowMapper());
	}
}

/*
	스프링 JDBC 개념
	JDBC는 가장 오랫동안 자바 개발잗들이 사용한 DB 연동 기술이다. JDBC를 이용하여 DB 연동 프로그램을 개발하면
	데이터베이스에 비종속적인 DB 연동 로직을 구현할 수 있다. 그런데 JDBC 프로그램은 이용하려면 개발자가 작성해야
	할 코드가 너무 많다.
	더 심각한 문제는 이런 JDBC 관련 코드들은 다른 메소드를 구현할 때마다 반복해서 작성해야 한다는 것이다.
	BoardDAO클래스에 insertBoard()와 updateBoard() 메소드는 실행되는 SQL 구문과 ?에 설정하는 값만 다를 뿐,
	JDBC에 해당하는 자바 코드는 거의 같다.
	
	이런 환경에서 새로운 기능의 메소드를 개발하려면, 결국 기존 메소드를 복사하여 SQL만 수정하는 방법뿐이다. 그런데
	만약 DB 연동에 필요한 자바 코드를 누군각가 대신 처리해주고 개발자는 실행되는 SQL 구문만 관리한다면 개발과
	유지 보수는 훨씬 편해질 것이다. 스프링은 JDBC 기반의 DB 연동 프로그램을 쉽게 개발할 수 있도록 JdbcTemplate
	클래스를 지원한다.
	
	JdbcTemplate 클래스
	JdbcTemplate은 GoF 디자인 패턴 중 템플릿 메소드 패턴이 적용된 클래스이다. 템플릿 메소드 패턴은 복작하고
	반복되는 알고리즘을 캡슐화해서 재사용하는 패턴으로 정의할 수 있다. 템플릿 메소드 패턴을 이용하면 반복해서
	사용도는 알고리즘을 템플릿 메소드로 샙슐화할 수 있어서 JDBC처럼 코딩 순서가 정형화된 기술에서 유용하게
	사용할 수 있다. 따라서 반복되는 DB 연동 로직은 JdbcTemplate 클래스의 템플릿 메소드가 제공하고,
	개발자는 달라지는 SQL 구문과 설정값만 신경 쓰면 된다.
	JdbcTemplate은 JDBC의 반복적인 코드를 제거하기 위해 제공하는 클래스다. 따라서 DAO 클래스에서는
	JdbcTemplate 클래스가 제공하는 템플릿 메소드를 호출하여 DB 연동을 간단하게 처리할 수 있다. 그러면
	JdbcTemplate 클래스는 내부적으로 JDBC API를 이용하여 실제 DB 연동 작업을 처리한다. 하지만 JdbcTemplate
	클래스가 어떻게 JDBC API를 이용하는지 DAO 클래스 개발자는 전형 신경 쓸 필요가 없다.
	
	JdbcTemplate 메소드
	스프링 JDBC를 위한 기본 설정이 마무리됐으면 이제 JdbcTemplate 객체를 이용하여 DB 연동을 간단하게 처리할 수
	있다.
	
	update() 메소드
	INSERT, UPDATE, DELETE 구문을 처리하려면 JdbcTemplate 클래스의 update() 메소드를 사용한다. update()
	메소드의 사용법은 "?"에 값을 설정하는 방식에 따라 크게 두 가지 형태가 있다.
	첫 번째는 SQL 구문에 설정된 "?" 수만큼 값들을 차례대로 나열하는 방식이다.
	
	첫 번째는 SQL 구문에 설정된 "?" 수만큼 값들을 차례대로 나열하는 방식이다.
	
	메소드 
	int update(String sql, Object ... args)
	
	사용 예
	// 글 수정
	public void updateBoard(BoardVO vo) {
		final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		int cnt = jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		System.out.println(cnt +"건 데이터 수정");
	}
	
	두 번째는 Object 배열 객체에 SQL 구문에 설정된 "?" 수만큼의 값들을 세팅하여 배열 객체를 두 번째 인자로
	전달하는 방식이다.
	
	메소드
	int update(String sql, Object[] args)
	
	사용 예
	// 글 수정
	public void updateBoard(BoardVO vo){
		final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		int cnt = jdbcTemplate.update(BOARD_UPDATE, args);
		System.out.println(cnt + "건 데이터 수정");
	}	
	
	queryForInt() 메소드
	SELECT 구문으로 검색된 정숫값을 리턴받으려면 queryForInt() 메소드를 사용한다. 매개변수의 의미는
	앞에서 살펴본 update() 메소드와 같다.
	
	SELECT 구문으로 검색된 정숫값을 리턴받으려면 queryForInt() 메소드를 사용한다. 매개변수의 의미는
	앞에서 살펴본 update() 메소드와 같다.
	
	메소드
	int queryForInt(String sql)
	int queryForInt(String sql, Object... args)
	int queryForInt(String sql, Object[] args)
	
	사용 예
	// 전체 게시글 수 조회
	public int getBoardTotalCount(BoardVO vo){
		String BOARD_TOT_COUNT="select count(*) from board";
		int count = jdbcTemplate.queryForInt(BOARD_TOT_COUNT);
		System.out.println("전체 게시글 수 : " + count + "건");
	}
	 
	queryForObject() 메소드
	queryForObject() 메소드는 SELECT 구문의 실행 결과를 특정 자바 객체(Value Object)로 매핑하여
	리턴받을 때 사용한다. queryForObject() 메소드는 검색 결과가 없거나 검색 결과가 두 개 이상이면
	예외(IncorrectResultSizeDataAccessException)를 발생시킨다.
	
	그리고 중요한 것은 검색 결과를 자바 객체(Value Object)로 매핑할 RowMapper 객체를 반드시
	지정해야 한다.
	
	메소드
	int queryForObject(String sql)
	int queryForObject(String sql, RowMapper<T> rowMapper)
	int queryForObject(String sql, Object[] args, RowMapper<T> rowMapper)
	
	사용 예
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo){
		String BOARD_GET = "select * from board where seq=?";
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	검색 결과를 특정 VO(Value Object) 객체에 매핑하여 리턴하려면 RowMapper 인터페이스를 구현한
	RowMapper 클래스가 필요하다. 결국, RowMapper 클래스는 테이블당 하나씩은 필요하다는 말이다.
	RowMapper 인터페이스에는 mapRow() 메소드가 있어서 검색 결과로 얻어낸 Row 정보를 어떤 VO에
	어떻게 매핑할 것인지를 구현해주면 된다.
	RowMapper 객체를 queryForObject() 메소드의 매개변수로 넘겨주면, 스프링 컨테이너는
	SQL 구문을 수행한 후 자동으로 RowMapper 객체의 mapRow() 메소드를 호출한다.
	
	query() 메소드
	queryForObject()가 SELECT 문으로 객체 하나를 검색할 때 사용하는 메소드라면, query() 메소드는
	SELECT 문의 실행 결과가 목록일 때 사용한다. 기본 사용법은 queryForObject() 메소드와 같다. 따라서
	query() 메소드에서도 검색 결과를 VO 객체에 매핑하려면 RowMapper 객체를 사용한다.
	
	메소드
	int query(String sql)
	int query(String sql, RowMapper<T> rowMapper)
	int query(String sql, Object[] args, RowMapper<T> rowMapper)
	
	사용 예
	// 글 목록 조회
	public List(BoardVO> getBoardList(BoardVO vo) {
		String BOARD_LIST = "select * from board order by seq desc";
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
	
	query() 메소드가 실행되면 여러 건의 ROW 정보가 검색되며, 검색된 데이터 ROW 수만큼 RowMapper 객체의
	mapRow() 메소드가 실행된다. 그리고 이렇게 ROW 정보가 매핑된 VO 객체 여러 개가 List 컬렉션에
	저장되어 리턴된다.
	
	DAO 클래스 구현
	DAO 클래스에서 JdbcTemplate 객체를 얻는 방법은 두 가지이다.
	
	첫 번째 방법 : JdbcDaoSupport 클래스 상속
	
	DAO 클래스를 구현할 때, JdbcDaoSupport 클래스를 부모 클래스로 지정하면 getJdbcTemplate() 메소드를
	상속받을 수 있다. 그리고 getJdbcTemplate() 메소드를 호출하면 JdbcTemplate 객체가 리턴되어
	모든 메소드를 JdbcTemplate 객체로 구현할 수 있다.
	그런데 문제는 getJdbcTemplate() 메소드가 JdbcTemplate 객체를 리턴하려면 DataSource 객체를
	가지고 있어야 한다. 따라서 반드시 부모 클래스인 JdbcDaoSupport 클래스의 setDataSource() 메소드를
	호출하여 데이터소스 객체를 의존성 주입해야 한다.
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	@Autowired 어노테이션은 주로 변수 위에 선언하는데 메소드 우에 선언해도 동작한다. 메소드 위에 @Autowired를
	붙이면 해당 메소드를 스프링 컨테이너가 자동으로 호출해주며, 이때 메소드 매개변수 타입을 확인하고 해당 타입의
	객체가 메모리에 존재하면 그 객체를 인자로 넘겨준다.
	수정된 모든 파일들을 저장하고 BoardServiceClient 프로그램을 실행하여 결과를 확인한다.
	
	두 번째 방법 : JdbcTemplate 클래스 <bean> 등록, 의존성 주입
	DAO 클래스에서 JdbcTemplate 객체를 얻는 두 번째 방법은 JdbcTemplate 클래스를 <bean> 등록하고,
	의존성 주입으로 처리하는 것이다. 일반적으로 이 방법을 사용한다. 먼저 스프링 설정 파일에 JdbcTemplate 클래스를
	<bean> 등록한다.
	<!-- DataSource 설정 -->
	<context:property-placeholder location="classpath:config/database.properties"/>
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="${jdbc.driver}"></property>
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
	</bean>
	
	<!-- Spring JDBC 설정 -->
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="dataSource"/>
	</bean>
	
	이때 반드시 JdbcTemplate 객체에 DataSource 객체를 의존성 주입해야 한다. 그리고 나서 DAO 클래스에서는 @Autowired
	어노테이션을 이용하여 JdbcTemplate 타입의 객체를 의존성 주입 처리하면 된다.
	
	// DAO(Data Access Object)
@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	JdbcDaoSupport 클래스를 상속하여 구현하는 것보다 좀 더 깔끔해진 것을 확인할 수 있다.
	
	JdbcTemplate 객체를 이용하여 BoardDAOSpring 클래스를 구형했으면 이제 BoardServiceImple 클래스가 BoardDAOSpring
	객체를 이용하여 DB 연동을 처리하도록 수정하자. 앞에서 작성했던 BoardServiceImple 클래스에서 boardDAO 변수의 타입을
	BoardDAO에서 BoardDAOSpring으로만 수정하면 된다.
	
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOSpring boardDAO;
	
	수정된  소스를 모두 저장하고 다시 한 번 BoardServiceClient 프로그램을 실행해보자. 기존에 JDBC 기반으로 동작했던
	BoardDAO가 아닌 스프링 JDBC 기반의 BoardDAOSpring 으로 DB 연동이 처리된다는 점만 다르고 실행 결과는 같다.
*/