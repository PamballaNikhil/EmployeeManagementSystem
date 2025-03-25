





document.getElementById("addEmployeeForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    // Get form data
    let firstName = document.getElementById("first_name").value;
    let lastName = document.getElementById("last_name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let department = document.getElementById("department").value;
    let hireDate = document.getElementById("hire_date").value;

    // Validate fields
    if (!firstName || !lastName || !email || !hireDate) {
        alert("Please fill in all required fields.");
        return;
    }

    // Prepare data for submission (use AJAX or a form submission)
    let formData = new FormData();
    formData.append("first_name", firstName);
    formData.append("last_name", lastName);
    formData.append("email", email);
    formData.append("phone", phone);
    formData.append("department", department);
    formData.append("hire_date", hireDate);

    // Example: Use fetch or AJAX to send data to backend
    fetch('/addEmployee', {
        method: 'POST',
        body: formData
    }).then(response => response.json())
      .then(data => alert("Employee added successfully!"))
      .catch(error => console.error("Error:", error));
});
