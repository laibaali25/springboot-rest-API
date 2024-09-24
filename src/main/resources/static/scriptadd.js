document.getElementById('employeeForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting the default way

    // Get the form data
    const formData = new FormData(this);
    const jsonData = JSON.stringify(Object.fromEntries(formData));

    // Send the form data to the server using Fetch API
    fetch('/employee', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
    .then(response => {
        if (response.ok) {
            alert('Employee added successfully!');
            this.reset(); // Reset the form fields
        } else {
            response.text().then(text => alert('Failed to add employee: ' + text));
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error adding employee. Please try again.');
    });
});
