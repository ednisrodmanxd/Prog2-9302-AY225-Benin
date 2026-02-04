// Load CSV and display in table
async function loadCSV() {
    try {
        const response = await fetch('MOCK_DATA.csv'); // CSV in same folder
        const csvText = await response.text();

        const rows = csvText.trim().split('\n'); // Split by line
        const tableBody = document.getElementById('tableBody');

        // Optional: clear table before loading
        tableBody.innerHTML = '';

        rows.forEach((row, index) => {
            const cols = row.split(',');

            // Skip header if first row contains non-numeric ID
            if (index === 0 && isNaN(cols[0])) return;

            const tr = document.createElement('tr');

            cols.forEach(col => {
                const td = document.createElement('td');
                td.textContent = col;
                tr.appendChild(td);
            });

            // Add delete button
            const actionTd = document.createElement('td');
            const deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Delete';
            deleteBtn.onclick = () => tr.remove();
            actionTd.appendChild(deleteBtn);
            tr.appendChild(actionTd);

            tableBody.appendChild(tr);
        });
    } catch (error) {
        console.error('Error loading CSV:', error);
        alert('Failed to load CSV. Make sure you are running this on a local server.');
    }
}

// Add student manually
function addStudent() {
    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const grade = document.getElementById('grade').value;

    if (!id || !name || !grade) return alert('Fill all fields');

    const tableBody = document.getElementById('tableBody');
    const tr = document.createElement('tr');

    [id, name, grade].forEach(value => {
        const td = document.createElement('td');
        td.textContent = value;
        tr.appendChild(td);
    });

    const actionTd = document.createElement('td');
    const deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.onclick = () => tr.remove();
    actionTd.appendChild(deleteBtn);
    tr.appendChild(actionTd);

    tableBody.appendChild(tr);

    // Clear inputs
    document.getElementById('id').value = '';
    document.getElementById('name').value = '';
    document.getElementById('grade').value = '';
}

// Load CSV when page opens
window.onload = loadCSV;
