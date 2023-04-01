package com.springdata.mappings;

import com.springdata.mappings.Entity.*;
import com.springdata.mappings.Repository.CustomerRepository;
import com.springdata.mappings.Repository.LicenseRepository;
import com.springdata.mappings.Repository.ProgrammerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class MappingsApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProgrammerRepository prepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer(){
        Customer customer=new Customer();
        customer.setName("Siva Reddy");
       // HashSet<PhoneNumber> numbers=new HashSet<PhoneNumber>();
        PhoneNumber ph1=new PhoneNumber();
        ph1.setNumber("7288802617");
        ph1.setType("Personal");
       // ph1.setCustomer(customer);
       // numbers.add(ph1);

        PhoneNumber ph2=new PhoneNumber();
        ph2.setNumber("9652327132");
        ph2.setType("Home");
       // ph2.setCustomer(customer);
        //numbers.add(ph2);

       //customer.setNumbers(numbers);
        customer.addPhoneNumber(ph1);
        customer.addPhoneNumber(ph2);
        repository.save(customer);
    }

    @Test
    @Transactional
    public void testLoadCustomer(){
        Customer customer=repository.findById(102L).get();
        System.out.println(customer.getName());

        Set<PhoneNumber> numbers=customer.getNumbers();
        numbers.forEach(number -> System.out.println(number.getNumber()));
        numbers.forEach(type -> System.out.println(type.getType()));
    }

    @Test
    public void testUpdateCustomer(){
        Customer customer=repository.findById(102L).get();
        customer.setName("Anitha Reddy");

        Set<PhoneNumber> numbers= customer.getNumbers();
        numbers.forEach(number -> number.setType("Home"));
        repository.save(customer);
    }

    @Test
    public void testDelete(){
        repository.deleteById(2L);

    }

    @Test
    public void testmtomCreateProgrammer(){
        Programmer programmer=new Programmer();
        programmer.setName("Siva Reddy");
        programmer.setSal(10000);
        HashSet<Project> project=new HashSet<>();
        Project p1=new Project();
        p1.setName("Java");
        project.add(p1);

        Project p2=new Project();
        p2.setName("MicroService");
        project.add(p2);
        programmer.setProjects(project);
        prepository.save(programmer);
    }

    @Test
    @Transactional
    public void testmtomFindProgrammer(){
        Programmer programmer=prepository.findById(1).get();
        System.out.println(programmer);
        System.out.println(programmer.getProjects());

    }

    @Test
    public void testOneToOneCreateLicense(){
        License license=new License();
        license.setType("LR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        Person person=new Person();
        person.setFirstName("SivaReddy");
        person.setLastName("PeddiReddy");
        person.setAge(21);

        license.setPerson(person);

        licenseRepository.save(license);
    }

}
