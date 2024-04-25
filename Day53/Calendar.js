const now = new Date();            
const curMonth = now.getMonth();            
const curYear =  now.getFullYear();
const curDate = now.getDate();
const nowTemp = new Date(curYear,curMonth,1);
const startDate = nowTemp.getDay();            
const week = ["일","월","화","수","목","금","토"];




          function showCalendar(){            
            let reSet;         
            let showWeek = 0;
            let cell = 0;
            let date = 1;  
            let nextDate = 1;          
            let lastDay = maxDate(curMonth);
            let numOfWeeks = Math.ceil((startDate+lastDay)/7);
            let table = "<table>";
            
            table += `<caption> ${curYear}년 ${curMonth+1}월</caption>`;

            table += `<tr>`;

            for (let x = 0; x < 7; x++) {     
                    table += `<td>${week[x]}</td>`;   
            }

            table += `</tr>`;
            for (let y = 0; y < numOfWeeks; y++) {
                table += `<tr>`;

                for (let x = 0; x < 7; x++) {

                    if(cell<startDate)
                        table += `<td id='firstLine'>${maxDate(curMonth-1)}</td>`;
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
                        table += `<td id='lastLine'>${nextDate++}</td>`;
      
                    showWeek++;
                    cell++;
                }
                table += `</tr>`;
                showWeek = 0;
            }
            table += `</table>`;          

            document.getElementById("now").innerHTML = reSet; 
            document.getElementById("calender").innerHTML = table;
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

        let showWeek = 0;
        let cell = 0;
        let date = 1;  
        let nextDate = 1;          
        let lastDay = maxDate(curMonth);
        let numOfWeeks = Math.ceil((startDate+lastDay)/7);                 

        let table = "<table>";
        
        table += `<caption> ${curYear}년 ${curMonth+1}월</caption>`;

        table += `<tr>`;

        for (let x = 0; x < 7; x++) {     
                table += `<td>${week[x]}</td>`;   
        }

        table += `</tr>`;
        for (let y = 0; y < numOfWeeks; y++) {
            table += `<tr>`;

            for (let x = 0; x < 7; x++) {

                if(cell<startDate)
                    table += `<td id='firstLine'>${maxDate(curMonth-1)}</td>`;
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
                    table += `<td id='lastLine'>${nextDate++}</td>`;
  
                showWeek++;
                cell++;
            }
            table += `</tr>`;
            showWeek = 0;
        }
        table += `</table>`;  
        document.getElementById("calender").innerHTML = table;
    }



        // $("td").click(function() {
    //     toggleClass(".active-color");
    // });