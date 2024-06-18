        $(document).ready(function(){
            $("#submitBtn").click(function(){
                if($("#title").val().trim() === "" || $("#content").val().trim() === ""){
                    alert("제목과 내용을 입력해주세요.");
                    return false;
                }
                return true;
            });
    const editor = document.querySelector('.se-components-wrap');
    const imageUpload = document.getElementById('imageUpload');
    const imageUploadButton = document.getElementById('imageUploadButton');

    imageUploadButton.addEventListener('click', function () {
        imageUpload.click();
    });

    function updatePlaceholder() {
        const paragraphs = editor.querySelectorAll('.se-text-paragraph');
        paragraphs.forEach(paragraph => {
            const span = paragraph.querySelector('span');
            const placeholder = paragraph.querySelector('.se-placeholder');
            if (span.innerText.trim() === '' && !placeholder) {
                const spanPlaceholder = document.createElement('span');
                spanPlaceholder.className = 'se-placeholder __se_placeholder se-ff-system se-fs15 se-placeholder-focused';
                spanPlaceholder.innerText = '내용을 입력하세요.';
                paragraph.appendChild(spanPlaceholder);
            } else if (span.innerText.trim() !== '' && placeholder) {
                placeholder.remove();
            }
        });

        if (paragraphs.length === 0) {
            editor.innerHTML = `<div class="se-component-content">
                                    <div class="se-drop-indicator">
                                        <p class="se-text-paragraph se-text-paragraph-align-left" style="line-height: 1.6;">
                                            <span class="se-ff-system se-fs15" style="color: rgb(0,0,0);"></span>
                                            <span class="se-placeholder __se_placeholder se-ff-system se-fs15 se-placeholder-focused">내용을 입력하세요.</span>
                                        </p>
                                    </div>
                                </div>`;
            setCaret(editor.querySelector('span'));
        }
    }

    editor.addEventListener('input', function (event) {
        const placeholder = event.target.closest('.se-text-paragraph').querySelector('.se-placeholder');
        if (placeholder) {
            placeholder.remove();
        }
        updatePlaceholder();
    });

    editor.addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            const newParagraph = document.createElement('p');
            newParagraph.className = 'se-text-paragraph se-text-paragraph-align-left';
            newParagraph.style.lineHeight = '1.6';
            const newSpan = document.createElement('span');
            newSpan.className = 'se-ff-system se-fs15';
            newSpan.style.color = 'rgb(0,0,0)';
            newParagraph.appendChild(newSpan);

            const lastDropIndicator = editor.querySelector('.se-drop-indicator:last-child');
            if (lastDropIndicator) {
                lastDropIndicator.appendChild(newParagraph);
            } else {
                const newDropIndicator = document.createElement('div');
                newDropIndicator.className = 'se-drop-indicator';
                newDropIndicator.appendChild(newParagraph);
                const newComponentContent = document.createElement('div');
                newComponentContent.className = 'se-component-content';
                newComponentContent.appendChild(newDropIndicator);
                editor.appendChild(newComponentContent);
            }

            setCaret(newSpan);
            updatePlaceholder();
        }
    });

    imageUpload.addEventListener('change', function (event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                const img = document.createElement('img');
                img.src = e.target.result;
                img.alt = '';
                img.className = 'se-image-resource';
                img.width = 800;
                const imageWrapper = document.createElement('div');
                imageWrapper.className = 'se-component se-image se-l-default';
                const imageContent = document.createElement('div');
                imageContent.className = 'se-component-content se-component-content-extend';
                const dropIndicator = document.createElement('div');
                dropIndicator.className = 'se-drop-indicator';
                const section = document.createElement('div');
                section.className = 'se-section se-section-image se-l-default se-section-align-left';
                const module = document.createElement('div');
                module.className = 'se-module semodule-image __se-unit';
                module.appendChild(img);
                section.appendChild(module);
                dropIndicator.appendChild(section);
                imageContent.appendChild(dropIndicator);
                imageWrapper.appendChild(imageContent);
                editor.appendChild(imageWrapper);
                updatePlaceholder();
            };
            reader.readAsDataURL(file);
        }
    });

    function setCaret(el) {
        const range = document.createRange();
        const sel = window.getSelection();
        range.setStart(el, 0);
        range.collapse(true);
        sel.removeAllRanges();
        sel.addRange(range);
        el.focus();
    }

    // Initialize the placeholder
    updatePlaceholder();
    setCaret(editor.querySelector('span'));
});