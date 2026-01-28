function openHelloPerpsWindow() {
    // Open a new browser window
    const win = window.open(
        "",
        "HelloPerpsWindow",
        "width=500,height=400"
    );

    // Safety check (popup blockers)
    if (!win) {
        alert("Popup blocked. Please allow popups for this site.");
        return;
    }

    // Write content into the new window
    win.document.write(`
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Java Programming</title>
            <style>
                body {
                    margin: 0;
                    height: 100vh;
                    display: flex;
                    flex-direction: column;
                    justify-content: space-between;
                    align-items: center;
                    font-family: Sans-Serif;
                }

                h1 {
                    margin-top: auto;
                    margin-bottom: auto;
                    font-size: 20px;
                    font-weight: bold;
                    text-align: center;
                }

                button {
                    margin-bottom: 20px;
                    padding: 10px 20px;
                    font-size: 16px;
                    cursor: pointer;
                }
            </style>
        </head>
        <body>
            <h1>Hello Perps to Java Game Programming!</h1>
            <button onclick="window.close()">PALDO</button>
        </body>
        </html>
    `);

    win.document.close();
}