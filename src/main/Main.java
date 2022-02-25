package main;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	//global variable lounge
	Vector<Staff> staffs = new Vector<>();
	Vector<Manager> managers = new Vector<Manager>();
	Vector<Supervisor> supervisors = new Vector<>();
	Vector<Admin> admins = new Vector<>();
	String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	Scanner scan = new Scanner(System.in);
	int managerNow = 0, supervisorNow = 0, adminNow = 0;
	//global variable lounge
	
	void managerRise() {
		for(int i=0; i<managers.size()-1;i++) {
			for(int j=0; j<staffs.size();j++) {
				if(managers.get(i).getCode().equals(staffs.get(j).getCode())) {
					int salary = managers.get(i).getSalary();
					salary = salary + (salary*10/100);
					managers.get(i).setSalary(salary);
					staffs.get(j).setSalary(salary);
					System.out.print(managers.get(i).getCode() + " ");
				}
			}
		}
		System.out.println("");
	}
	
	void supervisorRise() {
		for(int i=0; i<supervisors.size()-1;i++) {
			 for(int j=0; j<staffs.size();j++) {
				if(supervisors.get(i).getCode().equals(staffs.get(j).getCode())) {
				   int salary = supervisors.get(i).getSalary();
				   salary = salary + (salary*75/1000);
				   supervisors.get(i).setSalary(salary);
				   staffs.get(j).setSalary(salary);
				   System.out.print(supervisors.get(i).getCode() + " ");
			    }
			 }
		}
		System.out.println("");
	}
	
	
	void adminRise() {
		for(int i=0; i<admins.size()-1;i++) {
			for(int j=0; j<staffs.size();j++) {
				if(admins.get(i).getCode().equals(staffs.get(j).getCode())) {
					int salary = admins.get(i).getSalary();
					salary = salary + (salary*5/100);
					admins.get(i).setSalary(salary);
					staffs.get(j).setSalary(salary);
					System.out.print(admins.get(i).getCode() + " ");
				}
			}
			
		}
		System.out.println("");
	}
	
	boolean compare(String one, String two) {
		int ascii1 = 0;
		int ascii2 = 0;
		
		for(int i=0; i<one.length();i++) {
			ascii1 = ascii1 + (int)one.charAt(i);
		}
		
		for(int i=0; i<two.length();i++) {
			ascii2 = ascii2 + (int)two.charAt(i);
		}
		
		if(ascii1 > ascii2) {
			return true;
		}else {
			return false;
		}
	}
	
	void swap() {
		for(int i=0; i<staffs.size();i++) {
			for(int j=0; j<staffs.size()-1-i;j++) {
				if(staffs.get(j).getName().compareTo(staffs.get(j+1).getName()) > 0) {
					Staff test = staffs.get(j);
					staffs.set(j, staffs.get(j+1));
					staffs.set(j+1, test);
					
				}
			}
		}
	}
	
	void insertStaff() {
		String code;
		String name;
		String gender;
		String position;
		Integer salary;
		boolean error;
		
		do {
			error = false;
			Random rand = new Random();
			int randAlf1 = rand.nextInt(26);
			int randAlf2 = rand.nextInt(26);
			int randNum1 = rand.nextInt(10);
			int randNum2 = rand.nextInt(10);
			int randNum3 = rand.nextInt(10);
			int randNum4 = rand.nextInt(10);
			String temp = (String)Array.get(alphabet, randAlf1);
			String temp2 = (String)Array.get(alphabet, randAlf2);
			code = (temp+temp2 +"-"+randNum1+randNum2+randNum3+randNum4);
			
			if(staffs.contains(code)) {
				error = true;
			}

		}while(error);
		
		do {
			error = false;
			System.out.print("Input nama karyawan [>=3] : ");
			name = scan.nextLine();
			
			if(name.length()<3) {
				error = true;
			}else {
				for(int i=0; i<name.length();i++) {
					if(Character.isDigit(name.charAt(i))) {
						error = true;
						break;
					}
				}
			}
		}while(error);
		
		do {
			error = true;
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
			gender = scan.nextLine();
			if(gender.equals("Laki-laki") || gender.equals("Perempuan")){
				error = false;
			}
			
		}while(error);
		
		do {
			error = true;
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			position = scan.nextLine();
			
			if(position.equals("Manager") || position.equals("Supervisor") || position.equals("Admin")){
				error = false;
			}
		}while(error);
		
		if(position.equals("Manager")) {
			salary = 8000000;
			Staff temp = new Staff(code,name,gender,position,salary);
			Manager temp2 = new Manager(code,name,gender,position,salary);
			staffs.add(temp);
			managers.add(temp2);
		}else if(position.equals("Supervisor")) {
			salary = 6000000;
			Staff temp = new Staff(code,name,gender,position,salary);
			Supervisor temp2 = new Supervisor(code,name,gender,position,salary);
			staffs.add(temp);
			supervisors.add(temp2);
		}else {
			salary = 4000000;
			Staff temp = new Staff(code,name,gender,position,salary);
			Admin temp2 = new Admin(code,name,gender,position,salary);
			staffs.add(temp);
			admins.add(temp2);
		}
		
		
		
		System.out.println("Berhasil menambahkan karyawan dengan ID " + code);
		if(managers.size()%3 == 1 && managers.size()!=1) {
			if(managerNow != managers.size()) {
				System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan ID : ");
				managerRise();
				managerNow = managers.size();
				//System.out.println(managerNow);
			}
		}else if(supervisors.size()%3 == 1 && supervisors.size()!=1) {
			if(supervisorNow != supervisors.size()) {
				System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan ID : ");
				supervisorRise();
				supervisorNow = supervisors.size();
			}
			
		}else if(admins.size()%3 == 1 && admins.size()!=1) {
			if(adminNow != admins.size()) {
				System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan ID : ");
				adminRise();
				adminNow = admins.size();
			}
			
		}
		swap();
		backToMenu();
	}
	
	void backToMenu() {
		System.out.println("Press enter to continue...");scan.nextLine();
		Menu();
	}
	
	void viewStaff() {
		if(staffs.size() == 0) {
			System.out.println("There is no staff");
			backToMenu();
		}else {										                                                                  
			System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
			System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
			for(int i=0; i<staffs.size();i++) {
				System.out.printf("|%-4d|%-17s|%-30s|%-15s|%-14s|%-13d|\n",i+1,staffs.get(i).getCode(),staffs.get(i).getName(),staffs.get(i).getGender(),staffs.get(i).getPosition(),staffs.get(i).getSalary());
			}
			System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		}
	}
	
	void updateStaff() {
		viewStaff();
		int choose;
		boolean error;
		String name;
		String gender;
		String position;
		int index;
		do {
			error=false;
			try {
				System.out.print("Input nomor urutan karyawan yang ingin diupdate : ");
				choose = scan.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input must be a number");
				choose = staffs.size()+10;
			}scan.nextLine();
			
			if(choose<1 || choose>staffs.size()) {
				error=true;
			}
		}while(error);
		

		do {
			error = false;
			System.out.print("Input nama karyawan [>=3]: ");
			name = scan.nextLine();
			
			if(name.length()<3 && !name.equals("0")) {
				error = true;
			}
		}while(error);
		
		if(name.equals("0")) {
			name = staffs.get(choose-1).getName();
		}
		
		do {
			error = true;
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
			if(gender.equals("Laki-laki") || gender.equals("Perempuan")){
				error = false;
			}
			if(gender.equals("0")) {
				error = false;
			}
		}while(error);
		
		if(gender.equals("0")) {
			gender = staffs.get(choose-1).getGender();
		}
		
		do {
			error = true;
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			position = scan.nextLine();
			
			if(position.equals("Manager") || position.equals("Supervisor") || position.equals("Admin")){
				error = false;
			}
			
			if(position.equals("0")) {
				error = false;
			}
		}while(error);
		
		
		if(position.equals("0")) {
			position = staffs.get(choose-1).getPosition();
		}
		
		if(staffs.get(choose-1).getPosition().equals("Manager")) {
			int managerIndex=0;
			for(int i=0; i<managers.size();i++) {
				if(staffs.get(choose-1).getCode().equals(managers.get(i).getCode())) {
					managerIndex = i;
					break;
				}
			}
			
			if(position.equals("Manager")) {
				managers.get(managerIndex).setName(name);
				managers.get(managerIndex).setGender(gender);
				managers.get(managerIndex).setPosition(position);
			}else {
				managers.removeElementAt(managerIndex);
				if(position.equals("Supervisor")) {
					Supervisor temp = new Supervisor(staffs.get(choose-1).getCode(), name, gender, position, 6000000);
					supervisors.add(temp);
					staffs.get(choose-1).setSalary(6000000);
				}else {
					Admin temp = new Admin(staffs.get(choose-1).getCode(), name, gender, position, 4000000);
					admins.add(temp);
					staffs.get(choose-1).setSalary(4000000);
				}
			}
			
		}else if(staffs.get(choose-1).getPosition().equals("Supervisor")) {
			int supervisorIndex=0;
			for(int i=0; i<supervisors.size();i++) {
				if(staffs.get(choose-1).getCode().equals(supervisors.get(i).getCode())) {
					supervisorIndex = i;
					break;
				}
			}
			
			if(position.equals("Supervisor")) {
				supervisors.get(supervisorIndex).setName(name);
				supervisors.get(supervisorIndex).setGender(gender);
				supervisors.get(supervisorIndex).setPosition(position);
			}else {
				supervisors.removeElementAt(supervisorIndex);
				if(position.equals("Manager")) {
					Manager temp = new Manager(staffs.get(choose-1).getCode(), name, gender, position, 8000000);
					managers.add(temp);
					staffs.get(choose-1).setSalary(8000000);
				}else {
					Admin temp = new Admin(staffs.get(choose-1).getCode(), name, gender, position, 4000000);
					admins.add(temp);
					staffs.get(choose-1).setSalary(400000);
				}
			}
			
		}else {
			int adminIndex=0;
			for(int i=0; i<admins.size();i++) {
				if(staffs.get(choose-1).getCode().equals(admins.get(i).getCode())) {
					adminIndex = i;
					break;
				}
			}
			
			if(position.equals("Admin")) {
				admins.get(adminIndex).setName(name);
				admins.get(adminIndex).setGender(gender);
				admins.get(adminIndex).setPosition(position);
			}else {
				admins.removeElementAt(adminIndex);
				if(position.equals("Manager")) {
					Manager temp = new Manager(staffs.get(choose-1).getCode(), name, gender, position, 8000000);
					managers.add(temp);
					staffs.get(choose-1).setSalary(8000000);
				}else {
					Supervisor temp = new Supervisor(staffs.get(choose-1).getCode(), name, gender, position, 6000000);
					supervisors.add(temp);
					staffs.get(choose-1).setSalary(6000000);
				}
			}
			
		}
		
		staffs.get(choose-1).setName(name);
		staffs.get(choose-1).setGender(gender);
		staffs.get(choose-1).setPosition(position);
		
		System.out.println("Berhasil mengupdate karyawan dengan id  " + staffs.get(choose-1).getCode());
		
		if(managers.size()%3 == 1 && managers.size()!=1) {
			if(managerNow != managers.size()) {
				System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan ID : ");
				managerRise();
				managerNow = managers.size();
//				System.out.println(managerNow);
			}
		}else if(supervisors.size()%3 == 1 && supervisors.size()!=1) {
			if(supervisorNow != supervisors.size()) {
				System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan ID : ");
				supervisorRise();
				supervisorNow = supervisors.size();
			}
			
		}else if(admins.size()%3 == 1 && admins.size()!=1) {
			if(adminNow != admins.size()) {
				System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan ID : ");
				adminRise();
				adminNow = admins.size();
			}
			
		}
		
		swap();
		backToMenu();
	}
	
	void deleteStaff() {
		viewStaff();
		int choose;
		boolean error;
		do {
			error=false;
			try {
				System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
				choose = scan.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input must be a number");
				choose = staffs.size()+10;
			}scan.nextLine();
			
			if(choose<1 || choose>staffs.size()) {
				error=true;
			}
		}while(error);
		
		System.out.println("Karyawan dengan kode " + staffs.get(choose-1).getCode() + " berhasil dihapus");
		
		if(staffs.get(choose-1).getPosition().equals("Manager")) {
			for(int i=0; i<managers.size();i++) {
				if(staffs.get(choose-1).getCode().equals(managers.get(i).getCode())) {
					managers.removeElementAt(i);
					staffs.removeElementAt(choose-1);
					break;
				}
			}
		}else if(staffs.get(choose-1).getPosition().equals("Supervisor")) {
			for(int i=0; i<supervisors.size();i++) {
				if(staffs.get(choose-1).getCode().equals(supervisors.get(i).getCode())) {
					supervisors.removeElementAt(i);
					staffs.removeElementAt(choose-1);
					break;
				}
			}
		}else {
			for(int i=0; i<admins.size();i++) {
				if(staffs.get(choose-1).getCode().equals(admins.get(i).getCode())) {
					admins.removeElementAt(i);
					staffs.removeElementAt(choose-1);
					break;
				}
			}
		}
		backToMenu();
	}
	
	
	void Menu() {
		int choose;
		boolean error;
		System.out.println("===Staff Manager 2022====");
		System.out.println("|| 1. Insert new staff ||");
		System.out.println("|| 2. view staff       ||");
		System.out.println("|| 3. Update staff     ||");
		System.out.println("|| 4. Delete staff     ||");
		System.out.println("=========================");
		
		do {
			error = false;
			try {
				System.out.print(">> ");
				choose = scan.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input must be a number");
				choose = 9999;
			}scan.nextLine();
			
			if(choose<1 || choose>5) {
				error = true;
			}
		}while(error);
		
		switch(choose) {
			case 1:
				insertStaff();
				break;
			case 2:
				viewStaff();
				backToMenu();
				break;
			case 3:
				updateStaff();
				break;
			case 4:
				deleteStaff();
				break;
//			case 5:
//				managerRise();
//				backToMenu();
//				break;
		}
	}
	
	public Main() {
		Menu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
