package springMVC.controllers;

import org.junit.Before;
import org.junit.*;
import springMVC.domain.Address;
import springMVC.domain.Customer;
import springMVC.services.CustomerService;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testList() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.listAll()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/list"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }


    @Test
    public void testShow() throws Exception {
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/show"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception {
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testNewCustomer() throws Exception {
        verifyZeroInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Integer id = 1;
        Customer returnCustomer = new Customer();
        String firstName = "Micheal";
        String lastName = "Weston";
        String addressLine1 = "1 Main St";
        String addressLine2 = "Apt 301";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "micheal@burnnotice.com";
        String phoneNumber = "305.333.0101";

        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setBillingAddress(new Address());
        returnCustomer.getBillingAddress().setAddressLine1(addressLine1);
        returnCustomer.getBillingAddress().setAddressLine2(addressLine2);
        returnCustomer.getBillingAddress().setCity(city);
        returnCustomer.getBillingAddress().setState(state);
        returnCustomer.getBillingAddress().setZipCode(zipCode);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(Matchers.<Customer>any())).thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
                        .param("id", "1")
                        .param("firstName", firstName)
                        .param("lastName", lastName)
                        .param("addressLine1", addressLine1)
                        .param("addressLine2", addressLine2)
                        .param("city", city)
                        .param("state", state)
                        .param("zipCode", zipCode)
                        .param("email", email)
                        .param("phoneNumber", phoneNumber))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("addressLine1", is(addressLine1))))
                .andExpect(model().attribute("customer", hasProperty("addressLine2", is(addressLine2))))
                .andExpect(model().attribute("customer", hasProperty("city", is(city))))
                .andExpect(model().attribute("customer", hasProperty("state", is(state))))
                .andExpect(model().attribute("customer", hasProperty("zipCode", is(zipCode))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();

        assertEquals(id, boundCustomer.getId());
        assertEquals(firstName, boundCustomer.getFirstName());
        assertEquals(lastName, boundCustomer.getLastName());
        assertEquals(addressLine1, boundCustomer.getBillingAddress().getAddressLine1());
        assertEquals(addressLine2, boundCustomer.getBillingAddress().getAddressLine2());
        assertEquals(city, boundCustomer.getBillingAddress().getCity());
        assertEquals(state, boundCustomer.getBillingAddress().getState());
        assertEquals(zipCode, boundCustomer.getBillingAddress().getZipCode());
        assertEquals(email, boundCustomer.getEmail());
        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());
    }
}