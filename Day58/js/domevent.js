document.getElementById("pic").addEventListener("mouseover",() => 
  {
    document.getElementById("pic").setAttribute("src","images/boy.png");
  }
);

document.querySelector("#pic").addEventListener("mouseout",() => 
  {
    document.querySelector("#pic").setAttribute("src","images/girl.png");
  }
);