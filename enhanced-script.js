document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchBar");
    const articles = document.querySelectorAll(".news-item");

    searchInput.addEventListener("input", function () {
        let query = searchInput.value.toLowerCase();

        articles.forEach(article => {
            let title = article.querySelector("h3").innerText.toLowerCase();
            article.style.display = title.includes(query) ? "block" : "none";
        });
    });
});
