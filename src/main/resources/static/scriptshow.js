document.addEventListener('DOMContentLoaded', function() {
    fetch('/employee', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to fetch employee data');
        }
    })
    .then(employees => {
        const tableBody = document.getElementById('employeeTableBody');
        employees.forEach(employee => {
            const row = document.createElement('tr');

            row.innerHTML = `
                <td>${employee.employeeId}</td>
                <td>${employee.employeeName}</td>
                <td>${employee.dateOfJoining}</td>
                <td>${employee.mobile}</td>
                <td>${employee.email}</td>
                <td>${employee.salary}</td>
                <td>${employee.designation}</td>
                <td>${employee.alternativeMobile}</td>
            `;

            tableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to load employee data');
    });
});
