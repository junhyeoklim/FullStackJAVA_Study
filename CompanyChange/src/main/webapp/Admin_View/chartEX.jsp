<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <title>ERP 대시보드</title>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <link rel="icon" href="${contextPath}/assets/ico/company.ico" />
  <!--Load the AJAX API-->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawCharts);
    window.addEventListener('resize', drawCharts);

    function drawCharts() {
      drawGenderChart();
      drawHireResignChart();
      drawTotalEmployeesChart();
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

      var options = {
        'title':'부서별 성비', 
        'width': '100%',
        'height':300,
        'is3D': true,
        'animation': {
          'startup': true,
          'duration': 1000,
          'easing': 'inAndOut'
        },
        'pieSliceText': 'percentage',
        'slices': {
          0: {offset: 0.1},
          1: {offset: 0.1}
        }
      };
      var chart = new google.visualization.PieChart(document.getElementById('gender_chart'));
      chart.draw(data, options);
    }

    function drawHireResignChart() {
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Month');
      data.addColumn('number', 'New Hires');
      data.addColumn('number', 'Resignations');

      var hires = JSON.parse(document.getElementById('hires').textContent);
      var resignations = JSON.parse(document.getElementById('resignations').textContent);

      var rows = [];

      var months = Object.keys(hires).sort();

      for (var i = 0; i < months.length; i++) {
        var month = months[i];
        var hireCount = hires[month] || 0;
        var resignationCount = resignations[month] || 0;
        rows.push([month, hireCount, resignationCount]);
      }

      data.addRows(rows);

      var options = {
        title: 'Monthly New Hires and Resignations',
        chartArea: {width: '70%'},
        hAxis: {
          title: 'Number of Employees',
          minValue: 0,
          textStyle: {
            bold: true,
            fontSize: 12,
            color: '#4d4d4d'
          },
          titleTextStyle: {
            bold: true,
            fontSize: 18,
            color: '#4d4d4d'
          }
        },
        vAxis: {
          title: 'Month',
          textStyle: {
            fontSize: 14,
            bold: true,
            color: '#848484'
          },
          titleTextStyle: {
            fontSize: 14,
            bold: true,
            color: '#848484'
          },
          viewWindow: {
            min: 0
          },
          gridlines: {
            count: 10
          }
        },
        tooltip: { isHtml: true },
        height: 500,
        seriesType: 'bars',
        animation: {
          startup: true,
          duration: 1000,
          easing: 'inAndOut'
        }
      };

      var chart = new google.visualization.ComboChart(document.getElementById('hire_resign_chart'));
      chart.draw(data, options);
    }

    function drawTotalEmployeesChart() {
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Month');
      data.addColumn('number', 'Total Employees');

      var hires = JSON.parse(document.getElementById('hires').textContent);
      var resignations = JSON.parse(document.getElementById('resignations').textContent);
      var currentTotalEmployees = parseInt(document.getElementById('totalEmployees').textContent); // 현재 총 인원 수 가져오기
      var rows = [];

      var months = Object.keys(hires).sort().reverse();

      for (var i = 0; i < months.length; i++) {
        var month = months[i];
        var hireCount = hires[month] || 0;
        var resignationCount = resignations[month] || 0;
        rows.push([month, currentTotalEmployees]);
        currentTotalEmployees = currentTotalEmployees - hireCount + resignationCount;
      }

      rows.reverse();
      data.addRows(rows);

      var options = {
        title: 'Total Employees Over Time',
        chartArea: {width: '70%'},
        hAxis: {
          title: 'Number of Employees',
          minValue: 0,
          textStyle: {
            bold: true,
            fontSize: 12,
            color: '#4d4d4d'
          },
          titleTextStyle: {
            bold: true,
            fontSize: 18,
            color: '#4d4d4d'
          }
        },
        vAxis: {
          title: 'Month',
          textStyle: {
            fontSize: 14,
            bold: true,
            color: '#848484'
          },
          titleTextStyle: {
            fontSize: 14,
            bold: true,
            color: '#848484'
          },
          viewWindow: {
            min: 0
          },
          gridlines: {
            count: 10
          }
        },
        tooltip: { isHtml: true },
        height: 500,
        seriesType: 'line',
        animation: {
          startup: true,
          duration: 1000,
          easing: 'inAndOut'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('total_employees_chart'));
      chart.draw(data, options);
    }

    function drawDepartmentChart() {
      let departmentData = document.getElementById('departmentData').textContent;
      let departmentCounts = JSON.parse(departmentData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Department');
      data.addColumn('number', 'Employees');
      data.addRows(departmentCounts);

      var options = {
        'title':'부서별 인원 분포', 
        'width': '100%', 
        'height':300,
        'animation': {
          'startup': true,
          'duration': 1000,
          'easing': 'inAndOut'
        }
      };
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

      var options = {
        'title':'연도별 입사자 수', 
        'width': '100%', 
        'height':300,
        'animation': {
          'startup': true,
          'duration': 1000,
          'easing': 'inAndOut'
        }
      };
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

      var options = {
        'title':'부서별 평균 급여', 
        'width': '100%', 
        'height':300,
        'animation': {
          'startup': true,
          'duration': 1000,
          'easing': 'inAndOut'
        }
      };
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

      var options = {
        'title':'사원 연령대 분포', 
        'width': '100%', 
        'height':300,
        'animation': {
          'startup': true,
          'duration': 1000,
          'easing': 'inAndOut'
        }
      };
      var chart = new google.visualization.PieChart(document.getElementById('age_chart'));
      chart.draw(data, options);
    }
  </script>
</head>
<body>
  <c:import url="/assets/jsp/ChartMenubar.jsp"/>
  <div class="container-fluid mt-4">
    <div class="col-md-12">
      <div class="card mb-4">
        <div class="card-header">입/퇴사자 분포</div>
        <div class="card-body">
          <div id="hire_resign_chart" style="width: 100%; height: 500px; margin: 0 auto;"></div>
        </div>
      </div>
      <div class="card mb-4">
        <div class="card-header">총 사원수 변화</div>
        <div class="card-body">
          <div id="total_employees_chart" style="width: 100%; height: 500px; margin: 0 auto;"></div>
        </div>
      </div>
    </div>
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

  <c:set var="dataMap" value="${requestScope.dataMap}" />
  <c:set var="hires" value="${requestScope.hires }"/>
  <c:set var="resignations" value="${requestScope.resignations }"/>
  <c:set var="male" value="${dataMap.maleCount}" />
  <c:set var="female" value="${dataMap.femaleCount}" />
  <c:set var="totalEmployees" value="${dataMap.salaryCount}" />

  <span id="male" hidden>${male}</span>
  <span id="female" hidden>${female}</span>
  <span id="hires" hidden>${fn:escapeXml(hires)}</span>
  <span id="resignations" hidden>${fn:escapeXml(resignations)}</span>
  <span id="totalEmployees" hidden>${totalEmployees}</span>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
