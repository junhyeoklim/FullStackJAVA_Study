$(document).ready(function(){
    const movies = [
        { title: "인셉션", poster: "inception.jpg", pv: "vABfjuXZhYY", actors: [
            { name: "레오나르도 디카프리오", role: "도둑" },
            { name: "조셉 고든 레빗", role: "도둑의 친구" }
        ]},
        { title: "어벤져스", poster: "avengers.jpg", pv: "Z__gY6gDvSM", actors: [
            { name: "로버트 다우니 주니어", role: "아이언맨" },
            { name: "크리스 에반스", role: "캡틴 아메리카" }
        ]}
        // 원하는 만큼 영화를 추가할 수 있습니다.
    ];

    // Home 페이지를 업데이트하는 함수
    function updateHome() {
        $('#left-area').empty();
        movies.forEach((movie, index) => {
            // delay를 사용하여 각 요소가 왼쪽에서 순차적으로 나타나도록 설정
            const delay = index * 200; // 200ms 간격으로 나타나도록 설정
            const $movie = $(`
                <div class="movie">
                    <img src="images/${movie.poster}" alt="${movie.title}">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/${movie.pv}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
            `).css('opacity', 0).appendTo('#left-area').delay(delay).animate({opacity: 1}, 500);
        });
    }

    // 배우 정보를 업데이트하는 함수
    function updateActors() {
        $('#right-area').empty();
        movies.forEach((movie, index) => {
            movie.actors.forEach((actor, idx) => {
                // delay를 사용하여 각 요소가 왼쪽에서 순차적으로 나타나도록 설정
                const delay = index * 200 + idx * 100; // 100ms 간격으로 나타나도록 설정
                const $actor = $(`
                    <div class="actor">
                        <img src="images/${actor.name}.jpg" alt="${actor.name}">
                        <div class="info">
                            <p><strong>${actor.name}</strong></p>
                            <p>${actor.role} (${movie.title})</p>
                        </div>
                    </div>
                `).css('opacity', 0).appendTo('#right-area').delay(delay).animate({opacity: 1}, 500);
            });
        });
    }

    // 초기 화면 설정
    updateHome();

    // 메뉴 클릭 시 화면 변경
    $('#home-link').click(function(e) {
        e.preventDefault();
        $('#left-area').show().children().css('opacity', 0).each(function(index) {
            $(this).delay(index * 200).animate({opacity: 1}, 500);
        });
        $('#right-area').hide();
        $('#icon-left').hide();
        $('#icon-right').show();
    });

    $('#actor-link').click(function(e) {
        e.preventDefault();
        $('#left-area').hide();
        $('#right-area').show();
        updateActors();
        $('#icon-right').hide();
        $('#icon-left').show();
    });

    // 아이콘 클릭 시 화면 전환
    $('#icon-left').click(function() {
        $('#home-link').trigger('click');
    });

    $('#icon-right').click(function() {
        $('#actor-link').trigger('click');
    });

        // 메뉴 항목을 클릭할 때마다 실행되는 함수
    $('nav ul li a').click(function(e) {
            e.preventDefault(); // 링크 클릭 기본 동작 취소
            $('nav ul li a').removeClass('active'); // 모든 메뉴 항목에서 active 클래스 제거
            $(this).addClass('active'); // 클릭한 메뉴 항목에 active 클래스 추가
     });
});
