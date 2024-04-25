const week = ["일","월","화","수","목","금","토"];
let calendar ={ year:0, month:0, date:1, theDayOfTheWeek:0, lastDay:0, numOfWeeks:0};
let now = new Date();  
let curMonth = now.getMonth();            
let curYear =  now.getFullYear();
let curDate = now.getDate();    
let nowTemp = new Date(curYear,curMonth,1);
let startDate = nowTemp.getDay(); 


    function showCalendar(){            
        let reSet, cell = 0, date = 1, nextDate = 1;                         
        let table =  "";
        getCalendar();           



        table += "<table>";
            
            table += `<caption> ${calendar.year}년 ${calendar.month+1}월`;
            table += "<div class = 'month'>";
            table += "<ul>";
            table += "<li class='prev'><a href='#' onclick='nextMonth(-1)'>&#10094;</a></li>";
            table += "<li class='next'><a href='#' onclick='nextMonth(1)'>&#10095;</a></li>";
            table += "<li class='showDate'>";
            table +=  calendar.year+"년<br>";        
            table += "<span>" +(calendar.month+1)  + "월</span>";
            table += "</li>";
            table += "</ul>";
            table += "</div>";
            table += `</caption>`;

            table += `<tr>`;

            for (let x = 0; x < 7; x++) {     
                    table += `<td>${week[x]}</td>`;   
            }

            table += `</tr>`;
            for (let y = 0; y <6; y++) {
                
                table += `<tr>`;
                reSet = `<a href="#" onclick="nowDate()">${curYear}년 ${curMonth+1}월 ${curDate}일 ${week[calendar.theDayOfTheWeek]}요일</a>`
                for (let x = 0; x < 7; x++) {

                    if(y*7+x<calendar.theDayOfTheWeek )
                        // 공백 대신 전달 마지막 주 부분을 보여준다
                        table += `<td id='firstLine' onclick='nextMonth(-1)'>${maxDate(curMonth-1)-calendar.theDayOfTheWeek+cell+1}</td>`;
                    else if(date <= calendar.lastDay)
                    {
                        
                        if(date == curDate && calendar.month == curMonth && calendar.year == curYear)
                        {
                            table += `<td id='today' class='active-color'>${date}</td>`;                           
                        }
                        else
                            table += `<td class='active-color'>${date}</td>`;
                        date++; 
                    }
                    else        
                    // 공백 대신 다음달 첫 주에서 2번째 주 까지 보여준다  
                        table += `<td id='lastLine' onclick='nextMonth(1)'>${nextDate++}</td>`;
      
                    // showWeek++;
                    cell++;
                }
                table += `</tr>`;
                showWeek = 0;
            }
            table += `</table>`;          

            document.getElementById("now").innerHTML = reSet; 
            document.getElementById("calender").innerHTML = table;
    }

    function getCalendar()
{
    let date = null;
    if(calendar.year==0)
    {
        date = new Date();
        calendar.year = date.getFullYear();
        calendar.month = date.getMonth();
        calendar.date = date.getDate();
    }

    getLastDayOfTheMonth();
    getNumberOfWeeks();
}
            

    function getNumberOfWeeks()
    {   
        calendar.theDayOfTheWeek = new Date(calendar.year, calendar.month, 1).getDay();
        calendar.numOfWeeks = Math.ceil((calendar.theDayOfTheWeek+calendar.lastDay)/7);   
    }

    function getLastDayOfTheMonth()
    {

        let lastDay = maxDate(calendar.month);
 
        calendar.lastDay = lastDay;
    }



    
    function leapYear(dateYear) {
        let check = true;
        
        if(dateYear%4 == 0 && dateYear%100 != 0)
            check = true;
        else if(dateYear%400 == 0)
            check = true;
        else 
            check = false;

        return check ? 29 : 28;
    }

    function maxDate(date) {
        let checkDate = date+1;                
        switch(checkDate){
         case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:                 
         case 12:                 
            return 31;
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         case 2:
            // return leapYear(2024);
            return leapYear(curYear);
        }
    }   




    function nowDate() {   
        let now = new Date();  
        let curMonth = now.getMonth();            
        let curYear =  now.getFullYear();
        let curDate = now.getDate();   
        let showWeek = 0;
        let cell = 0;
        let date = 1;  
        let nextDate = 1;          
        let lastDay = maxDate(curMonth);        
        let table = "";
        calendar.year = curYear;
        calendar.month = curMonth;
        calendar.theDayOfTheWeek = new Date(calendar.year, calendar.month, 1).getDay();
        
        table = "<table>";

        table += `<caption> ${calendar.year}년 ${calendar.month+1}월`;
        table += "<div class = 'month'>";
        table += "<ul>";
        table += "<li class='prev'><a href='#' onclick='nextMonth(-1)'>&#10094;</a></li>";
        table += "<li class='next'><a href='#' onclick='nextMonth(1)'>&#10095;</a></li>";
        table += "<li class='showDate'>";
        table +=  calendar.year+"년<br>";        
        table += "<span>" +(calendar.month+1)  + "월</span>";
        table += "</li>";
        table += "</ul>";
        table += "</div>";
        table += `</caption>`;


        
        table += `<tr>`;

        for (let x = 0; x < 7; x++) {     
            table += `<td>${week[x]}</td>`;   
    }
        table +=`</td>`;

        for (let y = 0; y <6; y++) {            
            table += `<tr>`;
          
            for (let x = 0; x < 7; x++) {

                if(cell<startDate )
                    table += `<td id='firstLine' onclick='nextMonth(-1)'>${maxDate(curMonth-1)-calendar.theDayOfTheWeek+cell+1}</td>`;
                else if(date <= lastDay)
                {
                    
                    if(date == curDate)
                    {
                        table += `<td id='today' class='active-color'>${date}</td>`;
                        reSet = `<a href="#" onclick="nowDate()">${curYear}년 ${curMonth+1}월 ${curDate}일 ${week[showWeek]}요일</a>`
                    }
                    else
                        table += `<td class='active-color'>${date}</td>`;
                    date++; 
                }
                else          
                    table += `<td id='lastLine' onclick='nextMonth(1)'>${nextDate++}</td>`;
  
                showWeek++;
                cell++;
            }
            table += `</tr>`;
            showWeek = 0;
        }
        table += `</table>`;  
        document.getElementById("calender").innerHTML = table;
    }


    function nextMonth(num)
{
    calendar.month += num;

    if(calendar.year==0)
    {
        date = new Date();
        calendar.year = date.getFullYear();
        calendar.month = date.getMonth();        
    }


    if(calendar.month == -1)
    {
        calendar.month = 11;
        calendar.year--;
    }
    else if(calendar.month == 12)
    {
        calendar.month = 0;
        calendar.year++;
    }
    showCalendar();
}


        // $("td").click(function() {
    //     toggleClass(".active-color");
    // });