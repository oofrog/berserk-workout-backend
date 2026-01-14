function toggleSelection(id) {
    const item = document.getElementById('item-' + id);
    const checkbox = document.getElementById('check-' + id);

    // 1. 체크박스 상태 토글
    checkbox.checked = !checkbox.checked;

    // 2. UI 클래스 토글 (CSS 스타일 변경용)
    if (checkbox.checked) {
    item.classList.add('selected');
} else {
    item.classList.remove('selected');
}

    // 3. 하단 버튼 숫자 업데이트
    updateCount();
}

    function updateCount() {
    const checkedCount = document.querySelectorAll('.hidden-checkbox:checked').length;
    const badge = document.querySelector('#count-badge');
    badge.innerText = checkedCount;
}
