const express = require("express");
const cors = require("cors");
const path = require("path");
const fs = require("fs");

const app = express();
const PORT = 3000;
const COMMENTS_FILE = "comments.json"; // File to store comments

// Enable CORS
app.use(cors());
app.use(express.json()); // Enable JSON parsing

// Serve static files (HTML, CSS, JS)
app.use(express.static(path.join(__dirname)));

// Serve index.html for root URL
app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "index.html"));
});

// Get all comments
app.get("/comments", (req, res) => {
    fs.readFile(COMMENTS_FILE, (err, data) => {
        if (err) return res.status(500).json({ error: "Error reading comments" });
        res.json(JSON.parse(data || "[]")); // Return empty array if file is empty
    });
});

// Save new comment
app.post("/comments", (req, res) => {
    const newComment = req.body.comment;

    if (!newComment) {
        return res.status(400).json({ error: "Comment cannot be empty" });
    }

    fs.readFile(COMMENTS_FILE, (err, data) => {
        let comments = [];
        if (!err && data.length > 0) {
            comments = JSON.parse(data);
        }

        // Add new comment with timestamp
        comments.push({ text: newComment, timestamp: new Date().toISOString() });

        fs.writeFile(COMMENTS_FILE, JSON.stringify(comments, null, 2), (err) => {
            if (err) return res.status(500).json({ error: "Error saving comment" });
            res.json({ success: true, message: "Comment added!" });
        });
    });
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
