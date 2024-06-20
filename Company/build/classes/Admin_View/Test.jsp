<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawAxisTickColors);

      function drawAxisTickColors() {
        var data = google.visualization.arrayToDataTable([
          ['Month', 'New Hires', 'Resignations', 'Total Employees'],
          ['Jan', 10, 5, 100],
          ['Feb', 12, 7, 105],
          ['Mar', 14, 6, 113],
          ['Apr', 8, 9, 112],
          ['May', 10, 4, 118],
          ['Jun', 9, 5, 122],
          ['Jul', 7, 6, 123],
          ['Aug', 13, 8, 128],
          ['Sep', 11, 7, 132],
          ['Oct', 12, 6, 138],
          ['Nov', 8, 4, 140],
          ['Dec', 10, 5, 145]
        ]);

        var options = {
          title: 'Company Employee Dynamics',
          chartArea: {width: '50%'},
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
            }
          },
          seriesType: 'bars',
          series: {
            2: {type: 'line'}
          }
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>
