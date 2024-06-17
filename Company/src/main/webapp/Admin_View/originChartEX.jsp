<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <title>ERP 대시보드</title>
  <link rel="icon" href="../source/ico/company.ico" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="../source/css/erpStyle.css">
  <!--Load the AJAX API-->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawCharts);

    function drawCharts() {
      drawGenderChart();
      drawDepartmentChart();
      drawJoinYearChart();
      drawSalaryChart();
      drawAgeChart();
    }

    function drawGenderChart() {
      let male = document.getElementById('male').textContent;
      let female = document.getElementById('female').textContent;
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Gender');
      data.addColumn('number', 'Count');
      data.addRows([
        ['남', parseInt(male)],
        ['여', parseInt(female)]
      ]);

      var options = {'title':'성비', 'width':400, 'height':300};
      var chart = new google.visualization.PieChart(document.getElementById('gender_chart'));
      chart.draw(data, options);
    }

    function drawDepartmentChart() {
      let departmentData = document.getElementById('departmentData').textContent;
      let departmentCounts = JSON.parse(departmentData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Department');
      data.addColumn('number', 'Employees');
      data.addRows(departmentCounts);

      var options = {'title':'부서별 인원 분포', 'width':400, 'height':300};
      var chart = new google.visualization.ColumnChart(document.getElementById('department_chart'));
      chart.draw(data, options);
    }

    function drawJoinYearChart() {
      let joinData = document.getElementById('joinData').textContent;
      let joinCounts = JSON.parse(joinData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Year');
      data.addColumn('number', 'New Employees');
      data.addRows(joinCounts);

      var options = {'title':'연도별 입사자 수', 'width':400, 'height':300};
      var chart = new google.visualization.LineChart(document.getElementById('join_year_chart'));
      chart.draw(data, options);
    }

    function drawSalaryChart() {
      let salaryData = document.getElementById('salaryData').textContent;
      let salaryCounts = JSON.parse(salaryData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Department');
      data.addColumn('number', 'Average Salary');
      data.addRows(salaryCounts);

      var options = {'title':'부서별 평균 급여', 'width':400, 'height':300};
      var chart = new google.visualization.BarChart(document.getElementById('salary_chart'));
      chart.draw(data, options);
    }

    function drawAgeChart() {
      let ageData = document.getElementById('ageData').textContent;
      let ageCounts = JSON.parse(ageData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Age Range');
      data.addColumn('number', 'Count');
      data.addRows(ageCounts);

      var options = {'title':'사원 연령대 분포', 'width':400, 'height':300};
      var chart = new google.visualization.PieChart(document.getElementById('age_chart'));
      chart.draw(data, options);
    }
  </script>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">ERP 시스템</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">대시보드</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">사원 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">부서 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">급여 관리</a>
        </li>
      </ul>
    </div>
  </nav>


	    <c:forEach var="dto" items="${sessionScope.list }">
    	<c:choose>
    		<c:when test="${dto.s_gender == 'male' }">
    			<c:set var="male" value="${male+1 }"/>
    		</c:when>
    		<c:otherwise>
    			<c:set var="female" value="${female+1 }"/>
    		</c:otherwise>
    	</c:choose>
    </c:forEach>

  <div class="container-fluid mt-4">
    <div class="row">
      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-header">성비</div>
          <div class="card-body">
            <div id="gender_chart"></div>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-header">부서별 인원 분포</div>
          <div class="card-body">
            <div id="department_chart"></div>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-header">연도별 입사자 수</div>
          <div class="card-body">
            <div id="join_year_chart"></div>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-header">부서별 평균 급여</div>
          <div class="card-body">
            <div id="salary_chart"></div>
          </div>
        </div>
      </div>
      <div class="col-md-12">
        <div class="card mb-4">
          <div class="card-header">사원 연령대 분포</div>
          <div class="card-body">
            <div id="age_chart"></div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <span id="male" hidden>${male}</span>
  <span id="female" hidden>${female}</span>
  <span id="departmentData" hidden>${fn:escapeXml(departmentCounts)}</span>
  <span id="joinData" hidden>${fn:escapeXml(joinYearCounts)}</span>
  <span id="salaryData" hidden>${fn:escapeXml(averageSalaries)}</span>
  <span id="ageData" hidden>${fn:escapeXml(ageCounts)}</span>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
