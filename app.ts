interface Article {
    title: string;
    content: string;
    category: string;
}

async function fetchArticles(): Promise<void> {
    try {
        let response = await fetch("articles.json");
        let articles: Article[] = await response.json();

        let container = document.querySelector(".news-container") as HTMLElement;
        container.innerHTML = "";

        articles.forEach(article => {
            let div = document.createElement("div");
            div.className = "news-item";
            div.innerHTML = `<h3>${article.title}</h3><p>${article.content}</p>`;
            container.appendChild(div);
        });
    } catch (error) {
        console.error("Error fetching articles", error);
    }
}

fetchArticles();
