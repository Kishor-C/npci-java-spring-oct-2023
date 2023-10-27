
export function EmployeeItem(props) {
    // employee will have id, name, salary, url
    let employee = props.employee;
    return (<>
        <td>
        <Picture url = {employee.url} />
        </td>
       <td>{employee.id}</td><td>{employee.name}</td><td>{employee.salary}</td>
    </>);
}
export function EmployeesList(props) {
    let employees = props.employees;
    return (<div className = 'w-50'>
        <table className = 'table table-striped'>
            <thead>
                <tr>
                    <th>Image</th><th>Id</th><th>Name</th><th>Salary</th>
                </tr>
            </thead>
            <tbody>
                {employees.map((value, index)=><tr key = {index}>
                    <EmployeeItem employee = {value} />
                </tr>)}
            </tbody>
        </table>
    </div>);
}
function Picture(props) {
    let imageUrl = props.url;
    return (<>
        <img className = "roundImage" src = {imageUrl} width = "100" height="100" />
    </>);
}