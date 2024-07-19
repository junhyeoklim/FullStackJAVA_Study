let imgageIndex = 1;

function changeImage(num)
{
    

    if(num == 1)
    {
        if(imgageIndex >= 9)
            return;
        imgageIndex ++;
    }
    else
    {
        if(imgageIndex == 1)
            return;
        imgageIndex --;
    }


    

    let imageTag = document.getElementById("img");
    imageTag.setAttribute("src","pic_"+imgageIndex+".jpg");
}