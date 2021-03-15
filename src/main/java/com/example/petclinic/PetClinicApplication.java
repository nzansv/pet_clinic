package com.example.petclinic;

import com.example.petclinic.config.SpringConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.Payment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.services.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PetClinicApplication {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    public static Scanner in = new Scanner(System.in);
    public static PetOwnerService petOwnerService = context.getBean(PetOwnerService.class);
    public static PetService petService = context.getBean(PetService.class);
    public static VeterinarianService veterinarianService = context.getBean(VeterinarianService.class);
    public static AppointmentService appointmentService= context.getBean(AppointmentService.class);
    public static PaymentService paymentService = context.getBean(PaymentService.class);
    public static void main(String[] args) {
        int choice = -1;
        while (true) {

            System.out.println("1. View Information");
            System.out.println("2. Create PetOwner");
            System.out.println("3. Make An Appointment");
            System.out.println("4. Payment");
            System.out.println("0. Exit");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

                    int list;

                        System.out.println("1. View a list of veterinarians");
                        System.out.println("2. View a list of pet owners with pets");
                        System.out.println("3. View list of appointments");
                        System.out.println("4. View list of payments");


                    list = in.nextInt();
                        in.nextLine();

                        switch (list) {
                            case 1:
                                System.out.println(veterinarianService.getAll());
                                break;
                            case 2:
                                System.out.println(petService.getAll());
                                break;
                            case 3:
                                System.out.println(appointmentService.getAll());
                                break;
                            case 4:
                                System.out.println(paymentService.getAll());
                                break;
                        }
                        break;
                case 2:
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Email: ");
                    String email = in.nextLine();
                    System.out.println("Phone Number: ");
                    String phone_number = in.nextLine();

                    PetOwner newPetOwner = new PetOwner(name, email, phone_number);

                    petOwnerService.create(newPetOwner);
                    System.out.println(petOwnerService.getAll());
                    break;
                case 3:
                    System.out.println("Search Pet Owner by ID: ");
                    Long po_id = in.nextLong();
                    PetOwner petOwner = petOwnerService.getById(po_id);
                    System.out.println(petOwner.toString());

                    System.out.println("Search Veterinarian by ID: ");
                    Long vet_id = in.nextLong();
                    Veterinarian veterinarian = veterinarianService.getById(vet_id);
                    System.out.println(veterinarian.toString());

                    in.nextLine();

                    System.out.println("Input date: ");
                    String date = in.nextLine();

                    Appointment appointment = new Appointment(date, po_id, vet_id);
                    appointmentService.create(appointment);
                    long millis=System.currentTimeMillis();

                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    String strDate = dateFormat.format(millis);

                    Payment payment = new Payment("NOT DONE", strDate,appointment.getId(), po_id);
                    paymentService.create(payment);

                    System.out.println(appointmentService.getAll());
                    break;
                case 4:
                    System.out.println("Search Payment by ID: ");
                    Long payment_id = in.nextLong();
                    Payment payment1 = paymentService.getById(payment_id);
                    System.out.println(payment1.toString());
                    payment1.setStatus("PAID");
                    paymentService.update(payment_id,payment1);
                    System.out.println(payment1.toString());
                    break;
                    case 0:
                            System.out.println("Exit");
                            return;
            }
        }
    }
}
