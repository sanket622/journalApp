package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JournalEntryService journalEntryService;


//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "sanket",
//            "kishan",
//            "shikha"
//    })
//    public void testFindByUserName(String name){
//        assertNotNull(userRepository.findByUserName(name));
//    }


    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    @Disabled
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }


    @Disabled
    @Test
    public void testDeleteById(){
        assertTrue(journalEntryService.deleteById(new ObjectId("6961fd05696a2d96f0299321"), "shikha"));
    }

  // @ValueSource, @EnumSource

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}
