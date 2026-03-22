
    const apiUrl = "http://localhost:8080/employees";

    window.onload = loadEmployees;

    function loadEmployees() {
        fetch(apiUrl)
            .then(res => res.json())
            .then(data => {
                const table = document.getElementById("employeeTable");
                table.innerHTML = "";
                data.forEach(emp => {
                    table.innerHTML += `
                        <tr>
                            <td>${emp.id}</td>
                            <td>${emp.name}</td>
                            <td>${emp.department}</td>
                            <td>${emp.salary}</td>
                            <td>
                                <button class="btn-delete"
                                    onclick="deleteEmployee(${emp.id})">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    `;
                });
            });
    }

    function addEmployee(event) {
        event.preventDefault();

        const employee = {
            name: document.getElementById("name").value,
            department: document.getElementById("department").value,
            salary: document.getElementById("salary").value
        };

        fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(employee)
        }).then(() => {
            loadEmployees();
            document.querySelector("form").reset();
        });
    }

    function deleteEmployee(id) {
        if (!confirm("Are you sure you want to delete this employee?")) return;

        fetch(`${apiUrl}/${id}`, { method: "DELETE" })
            .then(() => loadEmployees());
    }
