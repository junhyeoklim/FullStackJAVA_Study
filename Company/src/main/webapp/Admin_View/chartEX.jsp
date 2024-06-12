<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <head>
  <title>차트 표</title>
  <link rel="icon" href="../source/company.ico" />
<link rel="stylesheet" href="../source/css/defaultStyle.css?after">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
/*       google.charts.setOnLoadCallback(drawChart); */
      google.charts.setOnLoadCallback(drawChart2);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
/*       function drawChart() {

        // Create the data table.
        let mushrooms = document.getElementById('mushrooms').textContent;
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['남', parseInt(mushrooms)],
          ['여', 50]          
        ]);

        // Set chart options
        var options = {'title':'How Much Pizza I Ate Last Night',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      } */
      function drawChart2() {

          // Create the data table.
          let male = document.getElementById('male').textContent;
          let female = document.getElementById('female').textContent;
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Gender');
          data.addColumn('number', 'Percentage'); 
          data.addRows([
            ['남', parseInt(male)],
            ['여', parseInt(female)]          
          ]);

          // Set chart options
          var options = {'title':'남/여 성비',
                         'width':400,
                         'height':300};

          // Instantiate and draw our chart, passing in some options.
          var chart = new google.visualization.PieChart(document.getElementById('chart2_div'));
          chart.draw(data, options);
        }
    </script>
  </head>

  <body>
  <c:import url="Menubar.jsp" />
    <!--Div that will hold the pie chart-->
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
    <span id="male" hidden>${male}</span>
    <span id="female" hidden>${female}</span>
    <div id="chart_div"></div>
    <div id="chart2_div"></div>
  </body>
</html>