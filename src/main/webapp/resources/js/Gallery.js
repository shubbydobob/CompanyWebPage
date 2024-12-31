    document.getElementById("image").addEventListener("change", function (event) {
        const preview = document.createElement("img");
        preview.src = URL.createObjectURL(event.target.files[0]);
        preview.style.width = "100%";
        preview.style.height = "150px";
        preview.style.objectFit = "cover";

        const previewContainer = document.getElementById("preview-container");
        previewContainer.innerHTML = ""; // 기존 미리보기 제거
        previewContainer.appendChild(preview);
    });