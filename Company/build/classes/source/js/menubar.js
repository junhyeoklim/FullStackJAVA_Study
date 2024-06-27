document.addEventListener('DOMContentLoaded', function () {
    let userRole = document.getElementById('uname').textContent;
    console.log("User Role:", userRole);

    // adminMenuItem이 이미 추가되었는지 확인
    if (userRole === 'admin' && !document.getElementById('admin-menu-item')) {
        var adminMenuItem = document.createElement('li');
        adminMenuItem.className = 'nav-item';
        adminMenuItem.id = 'admin-menu-item';  // ID 추가
        adminMenuItem.innerHTML = '<a class="nav-link active" aria-current="page" href="../chart.do">Chart</a>';
        document.getElementById('main-menu').prepend(adminMenuItem);
    }
});