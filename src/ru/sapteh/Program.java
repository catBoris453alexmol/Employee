package ru.sapteh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length ==0){
            System.out.println("Введите данные");
            return;
        }

        String fileName = "Employee.txt";
        List<Employee> employees = new ArrayList<>();

        //reading from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                Employee employee = getEmployee(reader.readLine()) ;
                employees.add(employee);
            }
        }

        //input data
        if (args[0].equals("-c")){
            int id = 0;
            for (Employee employee:employees) {
                if (employee.getId() > id){
                    id = employee.getId();
                }
            }
            String fio = args[1];
            String position = args[2];
            int paycheck = Integer.parseInt(args[3]);
            String organization = args[4];
            Employee employee = new Employee(++id,fio,position,paycheck,organization);
            employees.add(employee);
        }
        if (args[0].equals("-u")){
            int id = Integer.parseInt(args[1]);
            for (Employee employee: employees) {
                if (id ==employee.getId()){
                    employees.set(id-1,new Employee(id,args[2],args[3],Integer.parseInt(args[4]),args[5]));
                }

            }
        }
        if (args[0].equals(("-d"))){
            int id = Integer.parseInt(args[1]);
            employees.removeIf(employee -> id == employee.getId());
            }

        System.out.println(employees);


        //writing in file
        try (FileWriter fw = new FileWriter(fileName)){
            for (Employee employee:employees) {
                fw.write(employee.toString());
                fw.write("\n");
            }
        }
    }

    public static Employee getEmployee(String stringLine){
        String[] employees = stringLine.split(" ");

        int id = Integer.parseInt(employees[0].trim());
        String fio = employees[1].trim();
        String position = employees[2].trim();
        int paycheck = Integer.parseInt(employees[3].trim());
        String organization = employees[4].trim();
        return new Employee(id, fio,position,paycheck,organization);
    }
}




