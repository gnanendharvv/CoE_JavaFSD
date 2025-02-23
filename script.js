document.getElementById("comment-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const comment = document.getElementById("index-comment").value.trim();
    const statusDiv = document.getElementById("comment-status");

    if (!comment) {
        statusDiv.innerHTML = "<p style='color: red;'>Comment cannot be empty!</p>";
        return;
    }

    fetch("http://localhost:3000/comments", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ comment })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            statusDiv.innerHTML = "<p style='color: green;'>Comment added successfully!</p>";
            document.getElementById("index-comment").value = ""; // Clear input
            loadComments(); // Refresh comments list
        } else {
            statusDiv.innerHTML = "<p style='color: red;'>Error saving comment!</p>";
        }
    })
    .catch(error => {
        statusDiv.innerHTML = "<p style='color: red;'>Server error!</p>";
    });
});

// Function to load comments
function loadComments() {
    fetch("http://localhost:3000/comments")
    .then(response => response.json())
    .then(comments => {
        const commentsDiv = document.getElementById("comments-list");
        commentsDiv.innerHTML = ""; // Clear old comments
        comments.forEach(comment => {
            const p = document.createElement("p");
            p.textContent = `[${new Date(comment.timestamp).toLocaleString()}] ${comment.text}`;
            commentsDiv.appendChild(p);
        });
    })
    .catch(error => console.error("Error loading comments:", error));
}

// Load comments when the page loads
document.addEventListener("DOMContentLoaded", loadComments);
