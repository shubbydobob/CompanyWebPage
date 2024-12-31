 let currentSlide = 0;

    function showSlide(index) {
        const slides = document.querySelector('.slides');
        const totalSlides = document.querySelectorAll('.slide').length;
        if (index >= totalSlides) currentSlide = 0;
        else if (index < 0) currentSlide = totalSlides - 1;
        else currentSlide = index;
        slides.style.transform = `translateX(-${currentSlide * 100}%)`;
    }

    function nextSlide() {
        showSlide(currentSlide + 1);
    }

    function prevSlide() {
        showSlide(currentSlide - 1);
    }

    setInterval(nextSlide, 5000);
    
      function showImageGallery() {
        window.location.href = "#Gallery"; // Redirect to gallery section
    }

    function goToInquiryPage() {
        window.location.href = "inquiry"; // Redirect to inquiry page
    }
    

// 갤러리 컨테이너 선택
const galleryGrid = document.getElementById('galleryGrid');

// 동적으로 갤러리 생성
function createGallery(data) {
    data.forEach(item => {
        // 각 갤러리 항목 생성
        const galleryItem = document.createElement('div');
        galleryItem.classList.add('gallery-item');

        // 이미지 태그 생성
        const img = document.createElement('img');
        img.src = item.src;
        img.alt = item.description;

        // 설명 태그 생성
        const description = document.createElement('p');
        description.textContent = item.description;

        // 항목에 이미지와 설명 추가
        galleryItem.appendChild(img);
        galleryItem.appendChild(description);

        // 그리드에 항목 추가
        galleryGrid.appendChild(galleryItem);
    });
}

  // 이미지 데이터 배열
const galleryData = [
    { src: '/resources/images/kb국민은행 데스크 시공1.jpg', description: '이미지 설명 1' },
    { src: '/resources/images/kb국민은행 데스크 시공2.jpg', description: '이미지 설명 2' },
    { src: '/resources/images/kb국민은행 조명박스 시공1.jpg', description: '이미지 설명 3' },
    { src: '/resources/images/까르띠에 외부 철제 조형물 제작.jpg', description: '이미지 설명 4' },
    { src: '/resources/images/미즈노 본사 dp용 폴리싱 체어 제작.jpg', description: '이미지 설명 5' },
    { src: '/resources/images/미즈노 본사 dp용 폴리싱 체어 제작2.jpg', description: '이미지 설명 6' },
    { src: '/resources/images/미즈노 본사 dp용 폴리싱 체어 제작4.jpg', description: '이미지 설명 7' },
    { src: '/resources/images/밀양꽃도서관 책장 시공3.jpg', description: '이미지 설명 8' },
    { src: '/resources/images/밀양꽃도서관 책장 시공4.jpg', description: '이미지 설명 9' },
    { src: '/resources/images/밀양꽃도서관 책장 시공5.jpg', description: '이미지 설명 10' },
    { src: '/resources/images/밀양꽃도서관 책장 시공7.jpg', description: '이미지 설명 11' },
    { src: '/resources/images/수원스타필드 탑텐 마네킹스테이지 시공6.jpg', description: '이미지 설명 12' },
    { src: '/resources/images/수원스타필드 탑텐키즈 내부 조형물 시공9.jpg', description: '이미지 설명 13' },
    { src: '/resources/images/수원스타필드 탑텐키즈 외부 게이트 시공11.jpg', description: '이미지 설명 14' },
    { src: '/resources/images/여주아울렛 미즈노 헤어라인 벽 시공사진.jpg', description: '이미지 설명 15' },
    { src: '/resources/images/종로 와인바 선반제작.jpg', description: '이미지 설명 16' },
    { src: '/resources/images/탑텐 명동 벽 거울장 프레임시공.jpg', description: '이미지 설명 17' },
    { src: '/resources/images/행거제작사진1.jpg', description: '이미지 설명 18' },
    
];

// 갤러리 생성 함수 호출
createGallery(galleryData);