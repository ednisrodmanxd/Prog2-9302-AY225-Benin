// Customer Segmentation – Basic Data Science Logic
// Node.js Implementation

const fs = require('fs');
const readline = require('readline');
const path = require('path');

// readline interface for user input
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Class to represent a Customer
class Customer {
    constructor(id, name, totalPurchase) {
        this.id = id;
        this.name = name;
        this.totalPurchase = parseFloat(totalPurchase);
        this.segment = this.assignSegment();
    }

    assignSegment() {
        if (this.totalPurchase > 100000) return "Platinum";
        if (this.totalPurchase >= 50000) return "Gold";
        if (this.totalPurchase >= 10000) return "Silver";
        return "Bronze";
    }
}

// Function to ask for CSV file path
function askFilePath() {
    rl.question("Enter dataset file path: ", function(filePath) {
        try {
            if (!fs.existsSync(filePath)) {
                console.log("File does not exist. Try again.\n");
                return askFilePath();
            }
            if (!fs.lstatSync(filePath).isFile()) {
                console.log("Not a valid file. Try again.\n");
                return askFilePath();
            }
            if (path.extname(filePath).toLowerCase() !== ".csv") {
                console.log("File is not a CSV. Try again.\n");
                return askFilePath();
            }

            console.log("File found. Processing...\n");
            processCSV(filePath);

        } catch (err) {
            console.log("Error accessing file. Try again.\n");
            askFilePath();
        }
    });
}

// Function to read CSV and segment customers
function processCSV(filePath) {
    try {
        const data = fs.readFileSync(filePath, "utf8");
        const lines = data.trim().split("\n");

        // Assume first line is header
        const header = lines.shift().split(",");

        // Find relevant columns (case-insensitive)
        const idIndex = header.findIndex(h => h.toLowerCase().includes("id"));
        const nameIndex = header.findIndex(h => h.toLowerCase().includes("name"));
        const purchaseIndex = header.findIndex(h => h.toLowerCase().includes("purchase"));

        if (idIndex === -1 || nameIndex === -1 || purchaseIndex === -1) {
            console.log("CSV missing required columns: id, name, total purchase");
            rl.close();
            return;
        }

        const customers = lines.map(line => {
            const values = line.split(",");
            return new Customer(values[idIndex], values[nameIndex], values[purchaseIndex]);
        });

        // Segment grouping
        const segments = { Platinum: [], Gold: [], Silver: [], Bronze: [] };

        customers.forEach(c => segments[c.segment].push(c));

        // Output count per segment
        console.log("Customer Segmentation Summary:\n");
        for (let seg of ["Platinum", "Gold", "Silver", "Bronze"]) {
            console.log(`${seg}: ${segments[seg].length} customer(s)`);
        }

        console.log("\nDetailed List per Segment:\n");
        for (let seg of ["Platinum", "Gold", "Silver", "Bronze"]) {
            console.log(`--- ${seg} ---`);
            segments[seg].forEach(c => console.log(`${c.id} - ${c.name} - ${c.totalPurchase}`));
            console.log("");
        }

        rl.close();

    } catch (err) {
        console.log("Error reading CSV file. Make sure it's a valid CSV format.");
        askFilePath();
    }
}

// Start program
askFilePath();