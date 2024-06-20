document.addEventListener('DOMContentLoaded', function () {
    let userRole = document.getElementById('uname').textContent;
    console.log("User Role:", userRole);
    if (userRole === 'admin') {
        var adminMenuItem = document.createElement('li');
        adminMenuItem.className = 'nav-item';
        adminMenuItem.innerHTML = '<a class="nav-link active" aria-current="page" href="chart.do">Chart</a>';
        document.getElementById('main-menu').prepend(adminMenuItem);
    }
});
