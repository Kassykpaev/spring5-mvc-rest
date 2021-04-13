package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        loadCategories();
        loadCustomers();
    }

    public void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );
    }

    public void loadCustomers() {
        Customer anna = new Customer();
        anna.setFirstName("Anna");
        anna.setLastName("Kappa");

        Customer boris = new Customer();
        boris.setFirstName("Boris");
        boris.setLastName("Horis");

        Customer chad = new Customer();
        chad.setFirstName("Chad");
        chad.setLastName("Lol");

        Customer dmitriy = new Customer();
        dmitriy.setFirstName("Dmitriy");
        dmitriy.setLastName("Roflan");

        Customer eva = new Customer();
        eva.setFirstName("Eva");
        eva.setLastName("Kek");

        customerRepository.save(anna);
        customerRepository.save(boris);
        customerRepository.save(chad);
        customerRepository.save(dmitriy);
        customerRepository.save(eva);

        System.out.print("Customer loaded: " + customerRepository.count());
    }
}
