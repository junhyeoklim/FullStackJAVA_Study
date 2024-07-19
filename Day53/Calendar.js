const week = ["일","월","화","수","목","금","토"];
const timeSet = document.getElementById("top");
let calendar ={ year:0, month:0, date:1, theDayOfTheWeek:0, lastDay:0, numOfWeeks:0};
let now = new Date();  
let curMonth = now.getMonth();            
let curYear =  now.getFullYear();
let curDate = now.getDate();    
let nowTemp = new Date(curYear,curMonth,1);
let startDate = nowTemp.getDay(); 






//openAPI를 사용하여 현재 위치를 찾아 날씨 정보 나타내기
function curentWeather(){
    const city = document.getElementById("city");
    const weather = document.getElementById("TodayWeathre");
    const temp = document.getElementById("temp");
    const wind = document.getElementById("wind");    
    const API_KEY = fireconfig.apiKey;


    const degToCompass = (num) =>{
        const val = Math.floor((num / 22.5) + 0.5);
        const arr = ['북', '북북동', '동북동', '동동북', '동', '동동남', '남동', 
        '남남동', '남', '남남서', '서남서', '서서남','서', '서북서', '북서', '북북서'];

    return arr[(val % 16)];
    }

function onGeoOk(position) {
    let lat = position.coords.latitude;
    let lon = position.coords.longitude;
    const lang = 'kr';
    const units = 'metric';
    const iconSection = document.getElementById("icon");
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&lang=${lang}&units=${units}&appid=${API_KEY}`;

        fetch(url)
        .then(response => response.json())
        .then(data=>{
            const temperature = Math.round(data.main.temp)
            const windDirection = degToCompass(data.wind.deg)
            
            const icon = data.weather[0].icon;
            const iconURL = `http://openweathermap.org/img/wn/${icon}@2x.png`;
            city.innerText = data.name
            weather.innerText = data.weather[0].description
            temp.innerText = `기온: ${temperature}℃`            
            wind.innerText = `바람 세기 : ${windDirection} ${data.wind.speed}m/s`            
            iconSection.setAttribute("src",iconURL)
            
        })
        
    }

    function onGeoError() {
        alert("위치를 찾을 수 없습니다.");
    }

    const position_options = {
        enableHighAccuracy:true,
        timeout:60000,
        maximumAge:0
    };

    navigator.geolocation.watchPosition(onGeoOk,onGeoError,position_options);
}





    // 달력
    function showCalendar(){            
        let cell = 0, date = 1, nextDate = 1;                         
        let table =  "";
        let clock = document.getElementById("clock");
        clock.setAttribute("src","clock.png");

        curentWeather();
        getTime();
        getCalendar();
        setInterval(getTime,1000);       
        setInterval(curentWeather,1000);
        
            
            table += "<table>";            
            table += `<caption>`;
            table += `<a href="#" onclick="nowDate()">${curYear}년 ${curMonth+1}월 ${curDate}일 ${week[weekIndex()]}요일</a>`
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
               
                for (let x = 0; x < 7; x++) {

                    if(y*7+x<calendar.theDayOfTheWeek )
                        // 공백 대신 전 달 마지막 주 부분을 보여준다
                        table += `<td id='firstLine' onclick='nextMonth(-1)'>${maxDate(curMonth-1)-calendar.theDayOfTheWeek+cell+1}</td>`;
                    else if(date <= calendar.lastDay)
                    {
                        
                        if(date == curDate && calendar.month == curMonth && calendar.year == curYear)
                        {
                            table += `<td id='today' class='active-color'>${date}</td>`;                           
                        }
                        else
                        {
                            if(x == 0)
                                table += `<td class='sunDay'>${date}</td>`;
                            else if(x == 6)
                                table += `<td class='saturDay'>${date}</td>`;
                            else
                                table += `<td>${date}</td>`;
                        }   
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
            // document.getElementById("top").innerHTML = timeSet;
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



    // 현재 달력 보여주기 함수
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
        table += `<caption>`;
        table += `<a href="#" onclick="nowDate()">${curYear}년 ${curMonth+1}월 ${curDate}일 ${week[weekIndex()]}요일</a>`
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
                        
                    }
                    else
                    {
                        if(x == 0)
                            table += `<td class='sunDay'>${date}</td>`;
                        else if(x == 6)
                            table += `<td class='saturDay'>${date}</td>`;
                        else
                            table += `<td>${date}</td>`;
                    }
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

function weekIndex() {
    let now = new Date();  
    let curMonth = now.getMonth();    
    let curDate = now.getDate()+1;   
    let showWeek = 0;    
    let date = 1;        
    let lastDay = maxDate(curMonth);
    for (let y = 0; y <6; y++) {
        for (let x = 0; x < 7; x++) {
            if(date <= lastDay)
            {          
                if(date == curDate)
                  return showWeek;

                date++;
            }
            showWeek++;
        }
        showWeek = 0;
    }
}

function getTime() {
    //date 값을 다시 받는 이유는 전역 변수로 선언된 now 값이 1번만 불러와져서 실시간 시간 계산을 하지 못 하기 때문에 이렇게 함
    const d = new Date();
    let hour =String(d.getHours());
    let minute = String(d.getMinutes()).padStart(2,"0");
    let second = String(d.getSeconds()).padStart(2,"0");
    let ampm;

          if (hour >= 12){
            hour -= 12;
            ampm = "오후";
          }
          else ampm = "오전";

          if(hour == 0)
            hour = 12;
          
        timeSet.innerText = `${ampm} ${hour}:${minute}:${second}`;
}























