document.getElementById('deleteEmployeeForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const employeeId = document.getElementById('employeeId').value;

    fetch(`/employee/${employeeId}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            alert('Employee deleted successfully!');
        } else {
            throw new Error('Failed to delete employee');
        }
    })
    .catch(error => {
        alert('Error: ' + error.message);
    });
});
