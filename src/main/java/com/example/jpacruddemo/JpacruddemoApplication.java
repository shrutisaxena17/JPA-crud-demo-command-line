package com.example.jpacruddemo;

import com.example.jpacruddemo.dao.GenricDAO;
import com.example.jpacruddemo.entity.Address;
import com.example.jpacruddemo.entity.Department;
import com.example.jpacruddemo.entity.Employee;
import com.example.jpacruddemo.service.AddressService;
import com.example.jpacruddemo.service.DepartmentService;
import com.example.jpacruddemo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpacruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeService employeeService, AddressService addressService, DepartmentService departmentService){
		return runner->{
			Scanner sc = new Scanner(System.in);
			boolean running = true;

			while (running) {
				System.out.println("Employee Management System");
				System.out.println("1. Create Employee");
				System.out.println("2. Retrieve All Employees");
				System.out.println("3. Retrieve Employee by ID");
				System.out.println("4. Update Employee");
				System.out.println("5. Delete Employee");
				System.out.println("6. Create new Department");
				System.out.println("7. Retrieve All Departments");
				System.out.println("8. Retrieve Department by Department ID");
				System.out.println("9. Update Department");
				System.out.println("10. Delete Department");
				System.out.println("11. Create Address of the Employee");
				System.out.println("12. Retrieve All Addresses");
				System.out.println("13. Retrieve Address by Employee ID");
				System.out.println("14. Update Address of the Employee");
				System.out.println("15. Delete Address of the Employee");
				System.out.println("16. Exit");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
					case 1:
						createEmployee(sc, employeeService);
						break;
					case 2:
						listAllEmployees(employeeService);
						break;
					case 3:
						retrieveEmployeeById(sc, employeeService);
						break;
					case 4:
						updateEmployee(sc, employeeService);
						break;
					case 5:
						deleteEmployee(sc, employeeService);
						break;
					case 6:
						createDepartment(sc, departmentService);
						break;
					case 7:
						listAllDepartments(departmentService);
						break;
					case 8:
						retrieveDepartmentById(sc, departmentService);
						break;
					case 9:
						updateDepartment(sc, departmentService);
						break;
					case 10:
						deleteDepartment(sc, departmentService);
						break;
					case 11:
						createAddress(sc, addressService);
						break;
					case 12:
						listAllAddress(addressService);
						break;
					case 13:
						retrieveAddressById(sc, addressService);
						break;
					case 14:
						updateAddress(sc, addressService);
						break;
					case 15:
						deleteAddress(sc, addressService);
						break;
					case 16:
						running = false;
						System.out.println("Exiting the program.");
						break;
					default:
						System.out.println("Invalid choice! Please select a valid option.");
				}
			}
			sc.close();
		};

	}

	private static void createEmployee(Scanner sc,EmployeeService employeeService) {
		System.out.println("Enter the first name of the employee:");
		String firstName = sc.nextLine();
		System.out.println("Enter the last name of the employee:");
		String lastName = sc.nextLine();
		System.out.println("Enter the email of the employee:");
		String email = sc.nextLine();
		System.out.println("Enter the date of birth of the employee (yyyy-mm-dd):");
		Date sqlDate = parseDate(sc.nextLine());
		System.out.println("Enter your Phone Number:");
		Long phone = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your Gender:");
		String gender = sc.nextLine();
		System.out.println("Enter your Job Role:");
		String jobRole = sc.nextLine();
		System.out.println("Enter your Salary:");
		double salary = sc.nextDouble();
		System.out.println("\n Enter the number for your department \n 1. Java \n 2. Python \n 3. Magneto");
		int deptId = sc.nextInt();
		sc.nextLine();

		Employee employee = new Employee();
		employee.setFirst_name(firstName);
		employee.setLast_name(lastName);
		employee.setEmail(email);
		employee.setDate_of_birth(sqlDate);
		employee.setPhone(phone);
		employee.setGender(gender);
		employee.setJob_role(jobRole);
		employee.setSalary(salary);
		employee.setDepartment_id(deptId);

		employeeService.saveEmployee(employee);
		System.out.println("Employee created successfully.");
	}

	private static Date parseDate(String dateString) {
		try {
			return Date.valueOf(dateString);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid date format. Please use yyyy-mm-dd.");
			return null;
		}
	}

	private static void listAllEmployees(EmployeeService employeeService) {
		System.out.println("List of Employees:");
		List<Employee> employeeList = employeeService.findAllEmployee();
		for (Employee e : employeeList) {
			System.out.println("ID: " + e.getEmployee_id() +
					" Name: " + e.getFirst_name() + " " + e.getLast_name() +
					" Email: " + e.getEmail() +
					" Date of Birth: " + e.getDate_of_birth() +
					" Phone: " + e.getPhone() +
					" Gender: " + e.getGender() +
					" Job Role: " + e.getJob_role() +
					" Salary: " + e.getSalary() +
					" Department ID: " + e.getDepartment_id());
		}
	}

	private static void retrieveEmployeeById(Scanner sc,EmployeeService employeeService) {
		System.out.println("Enter the employee ID:");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			Employee newEmployee = employeeService.findEmployeeById(id);
			System.out.println("Employee Information: ID: " + newEmployee.getEmployee_id() +
					", Name: " + newEmployee.getFirst_name() + " " + newEmployee.getLast_name() +
					" Email: " + newEmployee.getEmail() +
					" Date of Birth: " + newEmployee.getDate_of_birth() +
					" Phone: " + newEmployee.getPhone() +
					" Gender: " + newEmployee.getGender() +
					" Job Role: " + newEmployee.getJob_role() +
					" Salary: " + newEmployee.getSalary() +
					" Department ID: " + newEmployee.getDepartment_id());
		} catch (Exception e) {
			System.out.println("Employee not found.");
		}
	}

	private static void updateEmployee(Scanner sc,EmployeeService employeeService) {
		System.out.println("Enter the employee ID you want to update:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the updated first name of the employee:");
		String firstName = sc.nextLine();
		System.out.println("Enter the updated last name of the employee:");
		String lastName = sc.nextLine();
		System.out.println("Enter the updated email of the employee:");
		String email = sc.nextLine();
		System.out.println("Enter the updated date of birth of the employee (yyyy-mm-dd):");
		Date sqlDate = parseDate(sc.nextLine());
		System.out.println("Enter your updated Phone Number:");
		Long phone = sc.nextLong();
		sc.nextLine();
		System.out.println("Update your Gender:");
		String gender = sc.nextLine();
		System.out.println("Enter your updated Job Role:");
		String jobRole = sc.nextLine();
		System.out.println("Enter your updated Salary:");
		double salary = sc.nextDouble();
		System.out.println("\n Enter the number for your updated department \n 1. Java \n 2. Python \n 3. Magneto");
		int deptId = sc.nextInt();
		sc.nextLine();

		Employee employee = new Employee();
		employee.setEmployee_id(id);
		employee.setFirst_name(firstName);
		employee.setLast_name(lastName);
		employee.setEmail(email);
		employee.setDate_of_birth(sqlDate);
		employee.setPhone(phone);
		employee.setGender(gender);
		employee.setJob_role(jobRole);
		employee.setSalary(salary);
		employee.setDepartment_id(deptId);

		employeeService.updateEmployee(employee);
		System.out.println("Employee updated successfully.");
	}

	private static void deleteEmployee(Scanner sc,EmployeeService employeeService) {
		System.out.println("Enter the ID of the employee you want to delete:");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline
		employeeService.deleteEmployee(id);
		System.out.println("Employee deleted successfully.");
	}

	private static void createDepartment(Scanner sc,DepartmentService departmentService) {
		System.out.println("Enter the new Department Name");
		String dept_name=sc.nextLine();
		Department department = new Department();
		department.setDepartment_name(dept_name);
		departmentService.saveDepartment(department);
		System.out.println("Department created successfully.");
	}

	private static void listAllDepartments(DepartmentService departmentService) {
		System.out.println("List of Departments:");
		List<Department> departmentList = departmentService.findAllDepartment();
		for (Department d : departmentList) {
			System.out.println("ID: " + d.getDepartment_id() +
					" Name: " + d.getDepartment_name());
		}
	}

	private static void retrieveDepartmentById(Scanner sc, DepartmentService departmentService) {
		System.out.println("Enter the department ID:");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			Department department = departmentService.findDepartmentById(id);
			System.out.println("ID: " + department.getDepartment_id() +
					" Name: " + department.getDepartment_name());
		} catch (Exception e) {
			System.out.println("Department not found.");
		}
	}

	private static void updateDepartment(Scanner sc, DepartmentService departmentService) {
		System.out.println("Enter the department ID you want to update:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the updated name of the department:");
		String deptName = sc.nextLine();
		Department department = new Department();
		department.setDepartment_id(id);
		department.setDepartment_name(deptName);
		departmentService.updateDepartment(department);
		System.out.println("Department updated successfully.");
	}

	private static void deleteDepartment(Scanner sc,DepartmentService departmentService) {
		System.out.println("Enter the ID of the department you want to delete:");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline
		departmentService.deleteDepartment(id);
		System.out.println("Department deleted successfully.");
	}

	private static void createAddress(Scanner sc,AddressService addressService) {
		System.out.println("Enter the id of the employee ");
		int employee_id= sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the street name");
		String street= sc.nextLine();
		System.out.println("Enter the city name");
		String city= sc.nextLine();
		System.out.println("Enter the state name");
		String state= sc.nextLine();
		System.out.println("Enter the pincode");
		String pincode= sc.nextLine();

		Address address= new Address();
		address.setEmployee_id(employee_id);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setPin_code(pincode);
		addressService.saveAddress(address);
		System.out.println("Address created successfully.");
	}

	private static void listAllAddress(AddressService addressService) {
		System.out.println("List of Address:");
		List<Address> addressList = addressService.findAllAddress();
		for (Address a: addressList) {
			System.out.println("Address ID: " + a.getAddress_id()+" Employee ID: "+a.getEmployee_id()+" Street: "+a.getStreet()+" City "+a.getCity()+" State "+a.getState()+" Pincode "+a.getPin_code());
		}
	}

	private static void retrieveAddressById(Scanner sc,AddressService addressService) {
		System.out.println("Enter the Employee ID:");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			Address a = addressService.findAddressById(id);
			System.out.println("Address ID: " + a.getAddress_id()+" Employee ID: "+a.getEmployee_id()+" Street: "+a.getStreet()+" City "+a.getCity()+" State "+a.getState()+" Pincode "+a.getPin_code());
		} catch (Exception e) {
			System.out.println("Address not found.");
		}

	}
	private static void updateAddress(Scanner sc,AddressService addressService) {
		System.out.println("Enter the Address ID you want to update:");
		int addressId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the updated street:");
		String street = sc.nextLine();
		System.out.println("Enter the updated city:");
		String city = sc.nextLine();
		System.out.println("Enter the updated state:");
		String state = sc.nextLine();
		System.out.println("Enter the updated pin code:");
		String pinCode = sc.nextLine();
		Address address = new Address();
		address.setAddress_id(addressId);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setPin_code(pinCode);
		addressService.updateAddress(address);
		System.out.println("Address updated successfully.");
	}

	private static void deleteAddress(Scanner sc,AddressService addressService) {
		System.out.println("Enter the ID of the address you want to delete:");
		int addressId = sc.nextInt();
		sc.nextLine();
		addressService.deleteAddress(addressId);
		System.out.println("Address deleted successfully.");
	}
}
