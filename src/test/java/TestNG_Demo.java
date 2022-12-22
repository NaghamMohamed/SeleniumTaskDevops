import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Demo{
    /////////////////// Before ////////////////
    @BeforeSuite
    public void beforeSuite(){ System.out.println("Before Suite"); }
    @BeforeTest
    public void beforeTest(){ System.out.println("Before Test"); }
    @BeforeClass
    public void beforeClass(){ System.out.println("Before Class"); }
    @BeforeMethod
    public void beforeMethod(){ System.out.println("Before Method"); }
//////////////////// After ////////////////////
     @AfterSuite
    public void afterSuite(){ System.out.println("After Suite"); }
    @AfterClass
    public void afterTest(){ System.out.println("After Test"); }
    @AfterClass
    public void afterClass(){ System.out.println("After Class"); }
    @AfterMethod public void afterMethod(){ System.out.println("After Method"); }
//////////////////////// Tests //////////////////
    @Test(dependsOnMethods = {"test2"})
    public void test1(){ System.out.println("Test 1"); }
    @Test
    public void test2(){
        System.out.println("Test 2");
        Assert.fail();
    }
    @Test
    public void test3(){ System.out.println("Test 3"); }
    @Test public void test4(){ System.out.println("Test 4"); }
}
