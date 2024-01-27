package cucumber.steps;

import com.aula1pratica1.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;


import java.util.List;
import java.util.ArrayList;

@CucumberContextConfiguration
public class StoreProductsSteps {
    @Given("I have more than {int} products is a CellPhone")
    public void iHaveMoreThanProductsIsACellPhone(int productNumber) {

        ProductController products = new ProductController();
        assertTrue("I have more than {int} products in my store",
        products.getAllProducts().size()>productNumber);

    }

    @And("One of these products is a CellPhone")
    public void oneOfTheseProductsIsACellPhone() {
        ProductController products = new ProductController();
        assertTrue("One of these products is a CellPhone",
                products.getAllProducts().contains("CellPhone"));
    }

    @Then("All product should be returned successfully")
    public void allProductShouldBeReturnedSuccessfully() {
       //Arrange
        List<String> productToBeVerified = new ArrayList<String>();

        productToBeVerified.add("Mouse");
        productToBeVerified.add("Keyboard");
        productToBeVerified.add("Pen");
        productToBeVerified.add("Screen");
        productToBeVerified.add("Notebook");
        productToBeVerified.add("CellPhone");

        //Act
        ProductController products = new ProductController();


        //Assert
        assertTrue("All product should be returned successfully",
                products.getAllProducts().containsAll(productToBeVerified));

    }
}
