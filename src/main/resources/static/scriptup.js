document.getElementById('fetchEmployeeForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const employeeId = document.getElementById('employeeId').value;
    
    fetch(`/employee/${employeeId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Employee not found');
        }
    })
    .then(employee => {
        document.getElementById('employeeName').value = employee.employeeName;
        document.getElementById('dateOfJoining').value = employee.dateOfJoining;
        document.getElementById('mobile').value = employee.mobile;
        document.getElementById('email').value = employee.email;
        document.getElementById('salary').value = employee.salary;
        document.getElementById('designation').value = employee.designation;
        document.getElementById('alternativeMobile').value = employee.alternativeMobile;

        document.getElementById('updateSection').style.display = 'block';
    })
    .catch(error => {
        alert('Error: ' + error.message);
    });
});

document.getElementById('updateEmployeeForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const employeeId = document.getElementById('employeeId').value;
    const employeeData = {
        employeeId: employeeId,
        employeeName: document.getElementById('employeeName').value,
        dateOfJoining: document.getElementById('dateOfJoining').value,
        mobile: document.getElementById('mobile').value,
        email: document.getElementById('email').value,
        salary: document.getElementById('salary').value,
        designation: document.getElementById('designation').value,
        alternativeMobile: document.getElementById('alternativeMobile').value
    };

    fetch(`/employee/${employeeId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employeeData)
    })
    .then(response => {
        if (response.ok) {
            alert('Employee updated successfully!');
            document.getElementById('updateSection').style.display = 'none';
        } else {
            throw new Error('Failed to update employee');
        }
    })
    .catch(error => {
        alert('Error: ' + error.message);
    });
});
