let imgageIndex = 1;

function changeImg(num){
    
    if(num == 1)
    {
        imgageIndex ++;

        if(imgageIndex == 10)
        imgageIndex = 9;
    }
    else
    {
        imgageIndex --;

        if(imgageIndex == 0)
            imgageIndex = 1;
    }

    let change = document.getElementById("img");

    change.setAttribute("src","images/pic_"+imgageIndex+".jpg");
    
}