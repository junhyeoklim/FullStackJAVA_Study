document.addEventListener('DOMContentLoaded', function () {
    let userRole = document.getElementById('uname').textContent;
    console.log("User Role:", userRole);
    if (userRole === 'admin' && !document.getElementById('admin-menu-item')) {
        var adminMenuItem = document.createElement('a');
        adminMenuItem.className = 'dropdown-item';
        adminMenuItem.id = 'admin-menu-item';  // ID 추가
        adminMenuItem.href = '/biz/chart.do';
        adminMenuItem.textContent = 'ERP 시스템';
        document.getElementById('user-dropdown-menu').prepend(adminMenuItem);
    }
});
