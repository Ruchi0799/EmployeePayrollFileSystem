package com.bridgelabz.employeepayrollusingfile;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum I0Service {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private static List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {}

    public EmployeePayrollService (List<EmployeePayrollData>
                                           employeePayrollList) {
        this.employeePayrollList=employeePayrollList;

    }

    public static void main(String[] args) {

        employeePayrollList = new ArrayList<>();

        EmployeePayrollService employeePayrollService = new EmployeePayrollService (employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService. readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);


    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {

        System.out.println("Enter Employee ID: ");
        int id= consoleInputReader.nextInt();

        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();

        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));

    }

    public void writeEmployeePayrollData(IOService ioService) {

        //System.out.println("\nwriting Employee Payroll Roaster to Console\n" + employeePayrollList);
        if (ioService.equals(com.bridgelabz.employeepayrollusingfile.IOService.CONSOLE_IO)) {
            System.out.println(employeePayrollList);
        } else if (ioService.equals(com.bridgelabz.employeepayrollusingfile.IOService.FILE_IO)) {

            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }





    }

    public void printData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public long countEntries (IOService ioService){
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;

    }

}
