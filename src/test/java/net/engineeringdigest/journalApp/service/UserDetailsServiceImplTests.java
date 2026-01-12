// package net.engineeringdigest.journalApp.service;

// import net.engineeringdigest.journalApp.entity.User;
// import net.engineeringdigest.journalApp.repository.UserRepository;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.security.core.userdetails.UserDetails;

// import java.util.ArrayList;

// import static org.mockito.Mockito.*;
// import static org.mockito.MockitoAnnotations.openMocks;

// public class UserDetailsServiceImplTests {

//     @InjectMocks
//     private UserDetailsServiceImpl userDetailsService;

//     @Mock
//     private UserRepository userRepository;

//     @BeforeEach
//     void setUp(){
//         openMocks(this);
//     }

//     @Test
//     @Disabled
//     void loadUserByUsernameTest(){
//         when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("sanket").password("sds").roles(new ArrayList<>()).build());
//         UserDetails user = userDetailsService.loadUserByUsername("sanket");
//         Assertions.assertNotNull(user);
//     }

//     // In case if we are also using redis for caching in UserServiceTests then we need to annotate here with @SpringBootTest
//     // because we need to mock findByUserName and need not to mock redis i.e, one mock and other not mock situation since redis
//     // will be using UserRepository through AutoWire
// }
